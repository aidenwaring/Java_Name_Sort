package com.aidenwaring;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);  // Create a Scanner object
        String fileName;

        System.out.println("Welcome to Name Sorter app.");

        if (args.length == 0) {
            System.out.println("Provide a string that represents a text file.");
            fileName = input.nextLine();  // Read user input
        } else {
            fileName = args[0];
        }
        ReadTextFile.streamFile(fileName);
    }
}
