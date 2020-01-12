package com.lin.bootdemo.utils;

import java.io.*;
import java.util.Properties;

/**
 * Created by Administrator on 2018/5/25.
 */
public class ReadUtil {

    // 全局配置文件
    private static Properties properties = null;

    //读取配置值
    public static String get(String name) {
        if (properties == null) {
            properties = new Properties();
            // 使用ClassLoader加载properties配置文件生成对应的输入流
            InputStream in = ReadUtil.class.getClassLoader().getResourceAsStream("application.yaml");
            //InputStream in = ReadUtil.class.getResourceAsStream("application.properties");
            // 使用properties对象加载输入流
            try {
                properties.load(in);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return properties.getProperty(name);
    }

    public static void savePic(InputStream inputStream, String fileName) {
        OutputStream os = null;
        try {
            String path = "c:\\testFile\\";

            // 2、保存到临时文件

            // 1K的数据缓冲

            byte[] bs = new byte[1024];

            // 读取到的数据长度

            int len;

            // 输出的文件流保存到本地文件

            File tempFile = new File(path);

            if (!tempFile.exists()) {

                tempFile.mkdirs();

            }

            os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);

            // 开始读取

            while ((len = inputStream.read(bs)) != -1) {

                os.write(bs, 0, len);

            }


        } catch (IOException e) {

            e.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            // 完毕，关闭所有链接

            try {

                os.close();

                inputStream.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }
    }

    public static byte[] is2ByeteArray(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buff = new byte[1024 * 5];
        int n = 0;
        while (-1 != (n = is.read(buff))) {
            baos.write(buff, 0, n);
        }
        return baos.toByteArray();
    }
}
