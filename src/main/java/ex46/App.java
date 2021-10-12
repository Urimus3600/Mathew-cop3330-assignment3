/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Austin Mathew
 */

package ex46;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        //pseudocode
        //Scanner for input file
        Scanner inputFile = new Scanner(Paths.get("exercise46_input.txt"));
        //Scan in one line at a time in a loop
        String transfer = "";
        while(inputFile.hasNextLine()){
            transfer += inputFile.nextLine() + "\n";
        }
        //initialize class with string
        Zoo zoo = new Zoo(transfer);
        // display class with a method
        zoo.displayZoo();
    }
}
