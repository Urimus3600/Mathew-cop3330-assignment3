/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Austin Mathew
 */

package ex44;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        //pseudocode

        // make Gson class and hope it works
        // set input file pointer
        // input file into single string
        try (Scanner inputFile =new Scanner(Paths.get("exercise44_input.json"))){
            String json = "";
            while(inputFile.hasNextLine()){
                json = json + inputFile.nextLine();
                json += "\n";
            }
            // create class which holds a class for reception of the converted json string
            Gson gson = new Gson();
            Products product = gson.fromJson(json, Products.class);
            // use loops to prompt user input
            // use loop within previous loop to check each name in class and give output based on that
            // use this to output related information with an if loop
            boolean finished = false;
            Scanner input = new Scanner(System.in);
            while(!finished){
                System.out.print("What is the product name? ");
                String name = input.next();
                System.out.print("");
                for(int i=0; i < product.products.size(); i++){
                    if(name.equals(product.products.get(i).name)){
                        System.out.print("Name: " + product.products.get(i).name + "\nPrice: "+
                                String.format("%.2f", product.products.get(i).price) + "\nQuantity: "
                                + product.products.get(i).quantity);
                    finished = true;
                    break;
                    }
                }
                if(!finished) System.out.println("Sorry, that product was not found in our inventory.");
            }
        }
        catch (NoSuchElementException | IllegalStateException | IOException e) {
            e.printStackTrace();
        }


    }
}
