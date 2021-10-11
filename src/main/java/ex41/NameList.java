package ex41;

import java.util.Formatter;
import java.util.LinkedList;

public class NameList {
    //keep track of number of elements
    // store names
    // string manipulation for sorting, split as needed
        // turned out this split would be swap, sort alphabetically, and display to file
        // also added getters and setters for privacy
    private int nameNum;

    public int getNameNum() {
        return nameNum;
    }

    public void setNameNum(int nameNum) {
        this.nameNum = nameNum;
    }

    public String getNameAtIndex(int i) {
        return names.get(i);
    }

    public void addNames(String name) {
        this.names.add(name);
    }

    private LinkedList<String> names = new LinkedList<String>();

    NameList(){
        nameNum = 0;
    }

    public void swap(int first, int second){
        String temp = names.get(first);
        names.set(first, names.get(second));
        names.set(second, temp);
    }

    public void sortAlpha(){
        int letter = 0;
        int name = 0;
        for(int i=0; i< nameNum; i++){
            for(int j=0; j<nameNum-1; j++){
                if(names.get(j).charAt(letter) > names.get(j+1).charAt(letter)){
                    swap(j, j+1);
                    letter = 0;
                }
                else if(names.get(j).charAt(letter) == names.get(j+1).charAt(letter)){
                    j--;
                    letter++;
                }
            }
        }
    }

    public void fDisplayNames(Formatter output){
        for(int i=0; i<nameNum; i++){
            output.format("%s\n", names.get(i));

        }

    }
}
