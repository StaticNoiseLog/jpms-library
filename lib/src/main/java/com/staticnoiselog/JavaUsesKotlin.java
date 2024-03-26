package com.staticnoiselog;

public class JavaUsesKotlin {
    public static void main(String[] args) {
        var lib = new Library();
        var res = lib.methodBasedOnOtherModule(17.0);
        System.out.printf("Result is %s%n", res);
    }
}
