package ex42;

public class Employee {
    String lastname, firstname, salary;

    Employee(String stuck){
        //Constructor will use a parser method to split string and assign values
        // instead I wrote the code straight into the constructor
        String hold = "";
        int start = 0;
        int order = 0;
        // the string will be evaluated character by character and at each comma or end of line it will be passed to
        // one of the 3 strings unless I find a way to read a string with a scanner
        for(int i=0; i < stuck.length(); i++){
            if(stuck.charAt(i) == ',' || i == stuck.length()-1){
                hold += stuck.substring(start, i);
                switch (order++){
                    case 0:
                        lastname = hold;
                        break;
                    case 1:
                        firstname = hold;
                    case 2:
                        salary = hold + stuck.charAt(i);
                }
                hold = "";
                start=i+1;
            }
        }
    }
}
