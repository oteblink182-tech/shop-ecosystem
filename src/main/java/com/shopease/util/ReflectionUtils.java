package com.shopease.util;


import java.lang.reflect.Field;

import com.shopease.annotations.ImportantField;

public class ReflectionUtils {
    
    public static void inspectObject(Object obj) {
         Class<?> clazz = obj.getClass();

        System.out.println("Inspecting object of class: " + clazz.getSimpleName());

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                System.out.println("->  Field: " + field.getName());
                System.out.println("    Type: " + field.getType().getSimpleName());
                System.out.println("    Value: " + field.get(obj));

                if (field.isAnnotationPresent(ImportantField.class)) {
                    ImportantField annotation = field.getAnnotation(ImportantField.class);
                    System.out.println("    ImportantField annotation found!");
                    System.out.println("    Description: " + annotation.description());
                } else {
                    System.out.println("    No important annotation.");
                }

            } catch (IllegalAccessException e) {
                System.out.println("    [ERROR] Could not access value: " + e.getMessage());
            }

            System.out.println("-----------------------------------");
        }
    }
}
