package com.zl.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * @author tzxx
 */
public class IoTest implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -3111870242835529558L;


    public void test2() throws Exception {
        File file1 = new File("F:/excelupload/清单.xlsx");
        file1.mkdirs();
        File file = new File("F:/excelupload/59c5c8f4-7a7c-4c05-84cf-da6cbc9285a7_清单.xlsx");
        System.out.println(file.getPath());
        System.out.println(file.getParent());
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.list());


    }

    public void test3() {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            String str = "";
            Set<String> s = new HashSet<>();
            fis = new FileInputStream("f:\\1.txt");
            // InputStreamReader 是字节流通向字符流的桥梁,
            isr = new InputStreamReader(fis, "UTF-8");
            // 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象
            br = new BufferedReader(isr);
            while ((str = br.readLine()) != null) {
                s.add(str.trim());
            }
            for (String string : s) {
                System.out.print(string + ",");
            }
        } catch (FileNotFoundException e) {
            System.out.println("找不到指定文件");
        } catch (IOException e) {
            System.out.println("读取文件失败");
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void createFile() {
        File f = new File("f:/excelupload1/create.txt");
        try {
            f.mkdirs();  //创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
