package ex45;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.Formatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        //pseudocode
        // input File Scanner
        Scanner inputFile = new Scanner(Paths.get("exercise45_input.txt"));
        // use for loop to put into a String line by line
        String file = "";
        while (inputFile.hasNextLine()) {
            file += inputFile.nextLine() + "\n";
        }
        // use replace all to replace all instances of utilize
        file = file.replaceAll("utilize", "use");
        out(file);
    }

    private static void out(String file) throws FileNotFoundException {
        // prompt for output file name
        System.out.print("What file should this be written to? ");
        // save to new String
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();
        // create output using Formatter with String inside
        try (Formatter outputFile = new Formatter(fileName)) {
            // pass first string to output file
            outputFile.format("%s", file);
        }
    }
}
