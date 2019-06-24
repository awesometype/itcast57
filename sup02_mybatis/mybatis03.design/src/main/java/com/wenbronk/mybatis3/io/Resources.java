package com.wenbronk.mybatis3.io;

import java.io.InputStream;

/**
 * 使用类加载器加载xml
 * @Author wenbronk
 * @Date 2019-06-20
 */
public class Resources {
    public static InputStream getResourceAsStream(String filePath) {
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
