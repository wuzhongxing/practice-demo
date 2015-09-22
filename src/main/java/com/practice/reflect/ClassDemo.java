package com.practice.reflect;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ClassDemo {

    public static void main(String[] args) {
        Date date = new Date();
        ArrayList<String> list = new ArrayList<String>();
        String[] sArray = new String[] {};

        clazMethods(list.getClass());
    }

    public static void clazMethods(Class claz) {
        System.out.println("getCanonicalName=" + claz.getCanonicalName());
        System.out.println("getModifiers=" + claz.getModifiers() + "#" + Modifier.toString(claz.getModifiers()));
        System.out.println("getName=" + claz.getName());
        System.out.println("getSimpleName=" + claz.getSimpleName());
        System.out.println("getClass=" + claz.getClass());
        System.out.println("getEnclosingMethod=" + claz.getEnclosingMethod());
        System.out.println("getSuperclass=" + claz.getSuperclass());
        System.out.println("getGenericSuperclass=" + claz.getGenericSuperclass());
        System.out.println("getPackage=" + claz.getPackage());
        System.out.println("getComponentType=" + claz.getComponentType());
        
        System.out.println("getDeclaredAnnotations=" + Arrays.toString(claz.getDeclaredAnnotations()));
        System.out.println("getAnnotations=" + Arrays.toString(claz.getAnnotations()));
        System.out.println("getClasses=" + Arrays.toString(claz.getClasses()));
        System.out.println("getDeclaredFields=" + Arrays.toString(claz.getDeclaredFields()));
        System.out.println("getDeclaredMethods=" + Arrays.toString(claz.getDeclaredMethods()));
        System.out.println("getFields=" + Arrays.toString(claz.getFields()));
        System.out.println("getGenericInterfaces=" + Arrays.toString(claz.getGenericInterfaces()));
        System.out.println("getInterfaces=" + Arrays.toString(claz.getInterfaces()));
        System.out.println("getMethods=" + Arrays.toString(claz.getMethods()));
        System.out.println("getTypeParameters=" + Arrays.toString(claz.getTypeParameters()));
        System.out.println("getTypeParameters=" + Arrays.toString(claz.getTypeParameters()));

    }

}
