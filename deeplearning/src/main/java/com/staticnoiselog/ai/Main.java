package com.staticnoiselog.ai;

public class Main {
    public static void main(String[] args) {
        System.out.println("I am a workaround for 'package is empty or does not exist' build errors.");

        // we can call Kotlin code from Java, but requires the "--patch-module" workaround in build.gradle.kts
        new KotlinForJava("Java Duke").helloFromKotlin();
    }
}