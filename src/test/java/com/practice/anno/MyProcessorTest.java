package com.practice.anno;

import static org.junit.Assert.*;

import org.junit.Test;

@PrintMe
public class MyProcessorTest {

    @Test
    public void test() {
        AnnotationDemo demo = new AnnotationDemo();
        demo.print();
    }

}
