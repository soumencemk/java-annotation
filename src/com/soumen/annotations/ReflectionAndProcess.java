package com.soumen.annotations;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * @author Soumen Karmakar
 * @Date 04/03/2021
 */
public class ReflectionAndProcess {

    public static void main(String[] args) {
        System.out.println("TESTING....");
        Class<UseTheAnnotations> useTheAnnotationsClass = UseTheAnnotations.class;
        // Class level :-
        if (useTheAnnotationsClass.isAnnotationPresent(SoumenAnnotation.class)) {
            SoumenAnnotation annotation = useTheAnnotationsClass.getAnnotation(SoumenAnnotation.class);
            System.out.println("   Created By : " + annotation.createdBy());
            System.out.println("Last modified : " + annotation.lastModified());
            System.out.println("     Priority : " + annotation.priority());
            System.out.println("         Tags : " + annotation.tags());
        }
        // Method :-
        Arrays.stream(useTheAnnotationsClass.getDeclaredMethods()).forEach(
                method -> {
                    if (method.isAnnotationPresent(TestAnnotation.class)) {
                        TestAnnotation annotation = method.getAnnotation(TestAnnotation.class);
                        if (annotation.enabled()) {
                            try {
                                method.invoke(useTheAnnotationsClass.newInstance());
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e) {
                                e.printStackTrace();
                            }

                        } else {
                            System.out.println(method.getName() + " :: not enabled, skipping...");
                        }
                    }
                }
        );

    }
}
