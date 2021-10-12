/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Austin Mathew
 */

package ex41;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.FileNotFoundException;
import java.lang.SecurityException;


public class App {
    public static void main(String[] args) {
        //psuedocode
        //create input and output file pointers(?)
        try (Formatter output = new Formatter("exercise41_output.txt")) {
            try(Scanner input = new Scanner(Paths.get("exercise41_input.txt"))) {
                //use linked list to store names to allow for large amount of names
                // Instead in application I created a class with useful methods and to protect the information
                // from undesired alteration
                NameList list = new NameList();
                //use loop to take in names until the file is done
                while (input.hasNext()) {
                    list.addNames(input.nextLine());
                    list.setNameNum(list.getNameNum()+1);
                }
                // moved up here after realizing it is unnecessary past this point
                input.close();

                // use loops to check go through list as many times as there are names minus 1
                // then go through in an inner loop the same amount of times
                //compare current letters, if the same move to next letter compare, but keep same names.
                //if swapped reset letter position

                // I ended up putting these within my class
                list.sortAlpha();

                //loop through already ordered linked list and display each name in output file
                list.fDisplayNames(output);

                // close each file
                output.close();

            }
            catch (IOException | NoSuchElementException |
             IllegalStateException e) {
                 e.printStackTrace();
            }
        } catch (SecurityException | FormatterClosedException | IOException e) {
            e.printStackTrace();
        }
    }
}
