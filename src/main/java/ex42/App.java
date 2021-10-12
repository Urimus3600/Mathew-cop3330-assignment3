/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Austin Mathew
 */

package ex42;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //psuedocode
        //open file in and out
        //make linked list of a class or make a class holding a linked list
        // use constructor to take each person's info from the stuck together string
        // display the link list with a method using a loop to go through the link
        // list and print in required format
        try (Scanner input = new Scanner(Paths.get("exercise42_input.txt"))) {
            try (Formatter output = new Formatter("exercise42_output.txt")) {
                LinkedList<Employee> team = new LinkedList<>();
                while(input.hasNext()){
                    String info = input.nextLine();
                    team.add(new Employee(info));
                }
                fDisplayCompany(team, output);

            } catch (IOException | NoSuchElementException | IllegalStateException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fDisplayCompany(LinkedList<Employee> team, Formatter output) {
        output.format("%-20s%-20s%8s\n", "Last", "First", "Salary");
        for(int i=0; i<12; i++){
            output.format("----");
        }
        output.format("\n");
        while (!team.isEmpty()) {
            output.format("%-20s%-20s%8s\n", team.get(0).lastname, team.get(0).firstname, team.get(0).salary);
            team.removeFirst();
        }
    }
}