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
    private static final String pu = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC9AJZR7jjzCjxSpe8rqfBDO8QjXkprTF6zThgz"
            + "xDVVlPMipj7XWKaWQTiJl/Nh532xgwtd9+P2j//+/NDcztJA8aw8Y3s0z92ImWUzDapIUBBYmdP0"
            + "D30Y2aH5dz3Tc3QPY0/DtfR9lV4RWdhQNirdDghPbMcqpv0aXZol83UiPwIDAQAB";
    private static final String pr = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAL0AllHuOPMKPFKl7yup8EM7xCNe"
            + "SmtMXrNOGDPENVWU8yKmPtdYppZBOImX82HnfbGDC1334/aP//780NzO0kDxrDxjezTP3YiZZTMN"
            + "qkhQEFiZ0/QPfRjZofl3PdNzdA9jT8O19H2VXhFZ2FA2Kt0OCE9sxyqm/RpdmiXzdSI/AgMBAAEC"
            + "gYB76CekXO3+/+XeNSTgVk/KdCM5ILbfMzkeigM55NcmXTksrRqjqV3FQcrkAbcwp0fzGTtZhotv"
            + "+KXWsD3plLmnc1Kaop/fBTaJQA8mnOXfo/58n1GQutbW09hKpgpuFejqZ9H1LJeOUNSVHXziW6/G"
            + "iIpEY36hr25UuUaM+hMzSQJBAOYtcztsFaZZI04sZJjIBlBws/nDf9XyTiD2X5sinR2ZOy3yvCgz"
            + "yAhsgb13RBTVueMiInFSCV2+zrA8+ol6nxUCQQDSNJxUnlOYVT6dXfuE6jDsN28bzlDv5MniFH6f"
            + "S4cUq6q0SScL1TNRHdTuA6hFYTUo7Zgh6ZvG+eGMtGRm2XEDAkEAlIJGktRNs6JXcRybWyfTSxss"
            + "Q72rQTKwzfun+8P9cxdmY2L1m0qtiSHZI5FLz9WFtdJUPqEbgeyWFoeBbio7cQJBALOVivGoChcc"
            + "zM+5GUbmpUFJ4rzIuNEaj3d8tuj0p8T7HG3GCXvMe3kTmXR2323WrIn44n4mjJWjqhSBkT1lC20C"
            + "QDs8t+AcKL6Kqgb9SKlkE2ULX3giuMZE5vmNWcEoKQkBLQ6lMKFI6QFG0zg8KDJPjp9IoJeUHVuO"
            + "hqE4SgxJy80=";

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

    public static void main(String[] args) throws Exception {
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