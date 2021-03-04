package com.soumen.annotations;

/**
 * @author Soumen Karmakar
 * @Date 04/03/2021
 */
@SoumenAnnotation(
        priority = SoumenAnnotation.Priority.HIGH,
        createdBy = "SoumenK",
        lastModified = "2020-01-22",
        tags = {"SOUMEN", "TEST"}
)
public class UseTheAnnotations {

    @TestAnnotation
    void someMethod() {
        System.out.println("SOME METHOD");
    }

    @TestAnnotation(enabled = false)
    void someOtherMethod() {
        System.out.println("SOME METHOD");
    }

    @TestAnnotation(enabled = true)
    void someOtherMethod2() {
        System.out.println("SOME METHOD");
    }
}
