/*
 * Copyright (c) 2021, 2030, lucas and his teacher kimmking. All rights reserved.
 */

package com.geek.week1jvm;

import java.io.InputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 自定义类加载器
 *
 * @author lucas
 * @since 2021.11.06 14:54
 */
public class ClassLoaderDemo extends ClassLoader {

    private final static String SPECIFIED_CLASS_NAME = "Hello";
    private final static String SPECIFIED_METHOD_NAME = "hello";
    private final static String SPECIFIED_FILE_NAME = "Hello.xlass";

    public static void main(String[] args) {
        try {
            Class<?> clazz = new ClassLoaderDemo().findClass(SPECIFIED_CLASS_NAME);
            Method method = clazz.getMethod(SPECIFIED_METHOD_NAME);
            Object obj = clazz.newInstance();
            method.invoke(obj);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 自定义类加载器的findClass方法
     *
     * @param className className
     * @return Class<?>
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {

        byte[] sourceBytes = readSoruceBytes();
        if(sourceBytes.length == 0) {
            throw new ClassNotFoundException("cannot find specified class, please check it out!");
        }

        for(int i = 0; i < sourceBytes.length; i++) {
            sourceBytes[i] = (byte)(255-sourceBytes[i]);
        }

        return defineClass(className, sourceBytes, 0, sourceBytes.length);

    }

    /**
     * 获取存放在Spring框架资源目录下的Hello.class文件，并转为字节数组返回
     * 如果有异常返回空byte数组
     *
     * @return byte[]
     */
    private byte[] readSoruceBytes() {
        try(InputStream fis = this.getClass().getClassLoader().getResourceAsStream(SPECIFIED_FILE_NAME)) {
            if(fis == null) {
                return new byte[0];
            }
            byte[] sourceBytes = new byte[fis.available()];
            fis.read(sourceBytes);
            return sourceBytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回空byte数组
        return new byte[0];
    }

}
