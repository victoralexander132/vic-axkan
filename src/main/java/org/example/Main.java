package org.example;


import org.example.controller.MarcaController;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        new MarcaController().printQuery();
        new MarcaController().printQuery(2);
    }
}