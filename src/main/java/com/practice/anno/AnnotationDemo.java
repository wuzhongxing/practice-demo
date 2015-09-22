package com.practice.anno;

import java.util.ServiceLoader;

import javax.annotation.processing.Processor;

@PrintMe
public class AnnotationDemo {
    
    public void print() {
        System.out.println("demo");
    }
    
    public static void main(String[] args) {
        ServiceLoader<Processor> serviceLoader = ServiceLoader 
                .load(Processor.class); 
        for (Processor service : serviceLoader) { 
            System.out.println(service.getSupportedAnnotationTypes());
        }  
        
        AnnotationDemo demo = new AnnotationDemo();
        demo.print();
    }
}
