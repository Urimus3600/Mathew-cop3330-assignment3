/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Austin Mathew
 */

package ex43;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.Format;
import java.util.Formatter;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("Site name: ");
        String siteName = input.nextLine();
        System.out.print("Author: ");
        String author = input.nextLine();
        System.out.print("Do you want a folder for JavaScript? ");
        boolean javaScript = input.next().toLowerCase(Locale.ROOT).equals("y");
        System.out.print("Do you want a folder for CSS? ");
        boolean CSS = input.next().toLowerCase(Locale.ROOT).equals("y");
        String website = "./website/" + siteName;
        new File(website).mkdirs();
        System.out.print("Created " + website + "\n");

        String html = website + "/index.html";

        new File(html).mkdirs();
        System.out.print("Created " + html + "\n");

        String htmlString = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>Page_Title</title>\n" +
                "<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\n" +
                "<meta author=\"Author\" content=\"\">\n" +
                "\n" +
                "\n" +
                "<link rel=\"stylesheet\" href=\"\">\n" +
                "<style>\n" +
                "</style>\n" +
                "<script src=\"\"></script>\n" +
                "<body>\n" +
                "\n" +
                "<img src=\"img_la.jpg\" alt=\"LA\" style=\"width:100%\">\n" +
                "\n" +
                "<div class=\"\">\n" +
                "    <h1>This is a Heading</h1>\n" +
                "    <p>This is a paragraph.</p>\n" +
                "    <p>This is another paragraph.</p>\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        htmlString = htmlString.replaceFirst("Page_Title", siteName);
        htmlString = htmlString.replaceFirst("Author", author);

        try (Formatter output = new Formatter(html)) {
            output.format("%s", htmlString);
        }

        if (javaScript) {
            String js = website + "/js/";
            new File(js).mkdirs();
            System.out.print("Created " + js +"\n");

        }
        if (CSS) {
            String css = website + "/css/";
            new File(css).mkdirs();
            System.out.print("Created " + css + "\n");
        }
    }

}
