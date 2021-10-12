package ex46;

import java.util.LinkedList;
import java.util.Scanner;

public class Zoo {
    //make class within a class, one to hold the link list of the other to prevent complicated and surplus files
    private LinkedList<Animal> animals = new LinkedList<>();
    //create class for word and frequency
    private class Animal{
        int freq;
        String name;
        //have a constructor initialize the name
        Animal(String name){
            this.name=name;
            freq=1;
        }
    }
    //make function to create linked list based on input string
    // compiler suggested making this my constructor
    Zoo(String original){
        // treat string like a file or input with a scanner
        Scanner input = new Scanner(original);
        // use loop to go through string and then the linked list to look for matches
        //increase frequency and/or create node
        while(input.hasNext()){
            String name = input.next();
            System.out.println(name);
            boolean add= true;
            for(int i=0; i < animals.size(); i++){

                if(animals.get(i).name.equals(name)){
                    animals.get(i).freq++;
                    add = false;
                }
            }
            if(add){
                createAnimal(name);
            }
        }

    }
    //use method to append new objects to linked list
    public void createAnimal(String name){
        animals.add(new Animal(name));
    }
    // go through linked list once per object to find one with highest frequency and print its values
    public void displayZoo(){
        for(int j=0; j<animals.size(); j++){
            int n = 0;
            for(int i = 1; i< animals.size(); i++){
                if(animals.get(n).freq < animals.get(i).freq){
                    n=i;
                }
            }
            System.out.printf("%20s", animals.get(n).name + ":");
            for(int i=0; i<animals.get(n).freq; i++) System.out.print("*");
            System.out.println();
            animals.get(n).freq = 0;
        }
    }
}
