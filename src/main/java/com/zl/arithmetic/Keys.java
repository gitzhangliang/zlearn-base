package com.zl.arithmetic;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@SuppressWarnings("unused")
public class Keys {
    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";
    private static final String pu = "";
    private static final String pr = "";

    public static void main1(String[] args) {
        Map<String, Object> keyMap;
        try {
            keyMap = initKey();

            String publicKey = getPublicKey(keyMap);
            System.out.println(publicKey);

            String privateKey = getPrivateKey(keyMap);
            System.out.println(privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main2(String[] args) throws Exception {
//        Map<String, Object> keyMap;
//
//            keyMap = initKey();
//
//            String publicKey = getPublicKey(keyMap);
//            System.out.println(publicKey);
//
//            String privateKey = getPrivateKey(keyMap);
//            System.out.println(privateKey);

        // 签名生成
        String content = "appId＝23232323&&testestesjfijfe12";

        String sign = sign(content.getBytes(), pr);
        System.out.println("内容：" + sign);
        String lastSign = URLEncoder.encode(sign.replace("\n", ""), "UTF-8");
        System.out.println("签名内容：" + content);
        System.out.println("最终签名：" + lastSign);

        // 签名验证
        boolean bverify = verify(content.getBytes(), pu, URLDecoder.decode(lastSign, "UTF-8"));

        System.out.println("验证结果：" + bverify);
        System.out.println("URLDecoder：" + URLDecoder.decode(lastSign, "UTF-8"));

    }

    public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
        Key key = ( Key ) keyMap.get(PUBLIC_KEY);
        byte[] publicKey = key.getEncoded();
        return encryptBASE64(key.getEncoded());
    }

    public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
        Key key = ( Key ) keyMap.get(PRIVATE_KEY);
        byte[] privateKey = key.getEncoded();
        return encryptBASE64(key.getEncoded());
    }



    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    public static void main(String[] args) {
        String s ="eyJWb2QiOnsiVGl0bGUiOiIxMjZf5rWL6K+VdGVzdDEubXA0IiwiRGVzY3JpcHRpb24iOiJ0aGlzIGlzIGRlc2MuIiwiQ2F0YUlkIjoiMCIsIlRhZ3MiOiIiLCJVc2VyRGF0YSI6InVzZXIgZGF0YSJ9fQ==";
        try {
            System.out.println(new String(decryptBASE64(s)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Map<String, Object> initKey() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();

        RSAPublicKey publicKey = ( RSAPublicKey ) keyPair.getPublic();
        RSAPrivateKey privateKey = ( RSAPrivateKey ) keyPair.getPrivate();

        Map<String, Object> keyMap = new HashMap<String, Object>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);

        return keyMap;
    }

    /**
     * 用私钥对信息生成数字签名
     *
     * @param data       加密数据
     * @param privateKey 私钥
     * @return
     * @throws Exception
     */
    public static String sign(byte[] data, String privateKey) throws Exception {
        // 解密由base64编码的私钥
        byte[] keyBytes = decryptBASE64(privateKey);

        // 构造PKCS8EncodedKeySpec对象
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);

        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

        // 取私钥匙对象
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);

        // 用私钥对信息生成数字签名
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(priKey);
        signature.update(data);

        return encryptBASE64(signature.sign());
    }

    /**
     * 校验数字签名
     *
     * @param data      加密数据
     * @param publicKey 公钥
     * @param sign      数字签名
     * @return 校验成功返回true 失败返回false
     * @throws Exception
     */
    public static boolean verify(byte[] data, String publicKey, String sign) throws Exception {

        // 解密由base64编码的公钥
        byte[] keyBytes = decryptBASE64(publicKey);

        // 构造X509EncodedKeySpec对象
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);

        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

        // 取公钥匙对象
        PublicKey pubKey = keyFactory.generatePublic(keySpec);

        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(pubKey);
        signature.update(data);

        // 验证签名是否正常
        return signature.verify(decryptBASE64(sign));
    }
}