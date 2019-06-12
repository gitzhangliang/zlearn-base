package com.zl.zzzz;

import java.io.*;

/**
 * @author tzxx
 * @date 2019/6/5.
 */
public class Fileco {
    public static byte[] toByteArray(InputStream input) throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        int a = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            System.out.println(a++);
        }
        return output.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        InputStream inputStream = new BufferedInputStream(new FileInputStream(new File("d:/12.mp4")));
        toByteArray(inputStream);
    }
}
