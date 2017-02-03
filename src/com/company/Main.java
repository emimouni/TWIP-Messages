package com.company;
import java.text.*;
import java.util.*;

public class Main {
public static ArrayList<MessageList> list = new ArrayList<MessageList>();
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        boolean b = true;
        while (b==true) {
            System.out.println("Would you like to (1)Send a Message, (2)Delete a Message, (3)Move a Message, or (4)View a Message?");
            String response = kb.next();
            String phoneNumber;
            MessageList m;
            Messages n;


            switch (response) {
                case "1":
                    System.out.println("What phone number would you like to send your text to?");
                    String number = kb.next();
                    System.out.println("Type Message here:");
                    String message = kb.next();
                    Messages text = new Messages(number, message);
                    addToList(text);
                    System.out.println("Delivered");
                    break;
                case "2":
                    System.out.println("Enter the number that the text is from.");
                    phoneNumber = kb.nextLine();
                    System.out.println("Would you like to delete all of your texts(1) or just the one(2)?");
                    String deleting = kb.next();
                    if (deleting.equalsIgnoreCase("1")) {
                        m = whichList(phoneNumber);
                        m.clear();
                    } else {
                        System.out.println("Enter the position of the text you want to delete (the first position is the newest text)");
                        int position = kb.nextInt();
                        while (true) {
                            m = whichList(phoneNumber);
                            if (m != null) {
                                m.remove(position);
                                System.out.println("Deleted");
                                break;
                            } else {
                                System.out.println("This number is not available, please try again:");
                                phoneNumber = kb.nextLine();
                            }
                        }
                    }
                    break;
                case "3":
                    System.out.println("What number would you like to move the message from?");
                    phoneNumber = kb.nextLine();
                    System.out.println("Starting from zero, enter the position of the message that you want to move.");
                    int position = kb.nextInt();
                    MessageList any = null;
                    for (MessageList x : list) {
                        if (x.getNum().equalsIgnoreCase(phoneNumber)) {
                            n = new Messages(phoneNumber, x.get(position).getMessage());
                            any = x;
                        }
                    }
                    System.out.println("What number would you like to move this number to?");
                    phoneNumber = kb.nextLine();
                    m = whichList(phoneNumber);
                    if (m != null) {
                        any.move(position, m, any);
                        System.out.println("Moved");
                    } else {
                        System.out.println("This number is not available.");
                    }
                    break;
                case "4":
                    System.out.println("From which number do you want to display messages to?");
                    phoneNumber = kb.nextLine();
                    whichList(phoneNumber).displayMessages();
                    break;
            }
        }
    }
    public static MessageList whichList(String num){
        for (MessageList m : list){
            if (m.getNum().equalsIgnoreCase(num)){
                return m;
            }
        }
        return null;
    }
    public static void addToList(Messages msg){
        if(list.isEmpty()){
            list.add(new MessageList(msg.getPhoneNumber()));
            list.get(0).add(msg);
        }
        else{
            boolean flag = false;
            for(MessageList ml: list){
                if(ml.getNum().equals(msg.getPhoneNumber())){
                    ml.add(msg);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                list.add(new MessageList(msg.getPhoneNumber()));
                list.get(list.size() - 1).add(msg);
            }
        }
    }
}
