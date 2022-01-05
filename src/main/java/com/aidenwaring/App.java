package com.aidenwaring;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  // Create a Scanner object
        String fileName;

        if (args.length == 0) {
            System.out.println("Provide a string that represents a text file.");
            fileName = input.nextLine();  // Read user input
        } else {
            fileName = args[0];
        }

        streamFile(fileName);




    }

    private static void streamFile(String file) {
        String sortedFileName = file.replace(".txt", "" + "-sorted.txt");

        try (Stream<String> stream = Files.lines(Paths.get(file))) {
            List<String> sortedNames = stream.sorted().collect(Collectors.toList());
            sortedNames.forEach(System.out::println);
//          Note: As of Java 16, Stream.toList() can be used directly on the Stream to get the list

//          File creator to be its own method for testing?
            Files.write(Paths.get(sortedFileName + "-sorted.txt"), sortedNames, Charset.defaultCharset());
            System.out.println("Finished: created " + sortedFileName);

        } catch (NoSuchFileException e) { // namo.txt
            System.out.println("Exception! No such file exists." + e);
        } catch (AccessDeniedException e) { // [return]
            System.out.println("Exception!  Access denied." + e);
        } catch (InvalidPathException e) { //               [spaces]
            System.out.println("Exception! Invalid path." + e);
        } catch (IOException e) {
            System.out.println("Exception! An I/O error occurred." + e);
        }
    }

}
