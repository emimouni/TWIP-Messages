package com.company;
import java.text.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);


    System.out.println("Enter your phone number:");
    String number = kb.next();
    System.out.println("Enter the message you would like to input:");
    String text = kb.next();

    DateFormat df = new SimpleDateFormat("HH:mm:ss");
    Date dateobj = new Date();
        //System.out.println(df.format(dateobj));
    }
}
