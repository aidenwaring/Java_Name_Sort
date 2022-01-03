package com.aidenwaring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class ReadTextFile {

    public static String myFile = "src\\main\\resources\\names.txt";

    public static void main(String[] args) throws Exception
    {
        bufferedReaderMethod();
        readFileAsString();
        streamFile();
    }

//    Method One: BufferedReader
    public static void bufferedReaderMethod() throws Exception {
        File file = new File(myFile);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null)
            System.out.println(st);
    }

//    Method Two: Read File As String
    public static void readFileAsString() throws Exception {
        String data = new String(Files.readAllBytes(Paths.get(myFile)));
        System.out.println(data);
    }

//    Method Three: String Stream File
    public static void streamFile() throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(myFile))) {
            stream.forEach(System.out::println);
        }
    }
}