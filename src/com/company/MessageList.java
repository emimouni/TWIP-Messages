package com.company;

import com.intellij.openapi.compiler.CompilationException;

import java.util.ArrayList;

/**
 * Created by emimo on 2/1/2017.
 */
public class MessageList {
    public String number;
    public ArrayList<Messages> texts = new ArrayList<Messages>();

    public MessageList(String num){
        number = num;
    }

    public void add(Messages mes){
        long time = mes.getTheTime().getTime();
        int i = 0;
        for (Messages msg: texts){
            if (time > msg.getTheTime().getTime()){
                i++;
            }
        }
        texts.add(i, mes);
    }

    public void remove(int position){
        texts.remove(position);
    }

    public void clear(){
        texts.clear();
    }

    public Messages get(int position){
        return texts.get(position);
    }

    public void move(int position, MessageList ml1, MessageList ml2){
        if (ml1 != null){
            ml1.add(ml2.get(position));
            ml2.remove(position);
        }
        else {
            System.out.println("The message list that you are referring to does not exist.");
        }
    }

    public void displayMessages(){
        System.out.println("Messages belonging to: " + number);
        for (Messages m: texts){
            System.out.println(m.getMessage() + "\tTime Received: " + m.getTheRealTime());
        }
    }

    public String getNum(){
        return number;
    }

}
