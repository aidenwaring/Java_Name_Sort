package com.aidenwaring;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadTextFile {

    public static void main(String[] args) { }


    public static void streamFile(String file) throws IOException {
        String sortedFileName = file.replace(".txt", "" + "-sorted.txt");
        try (Stream<String> stream = Files.lines(Paths.get(file))) {
            List<String> sortedNames = stream.sorted().collect(Collectors.toList());
            sortedNames.forEach(System.out::println);
//          Note: As of Java 16, Stream.toList() can be used directly on the Stream to get the list

//          File creator to be its own method for testing?
            Files.write(Paths.get(sortedFileName + "-sorted.txt"), sortedNames, Charset.defaultCharset());
        }
        System.out.println("Finished: created " + sortedFileName);
    }
}