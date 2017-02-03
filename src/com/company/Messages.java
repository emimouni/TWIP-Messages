package com.company;
import java.text.*;
import java.util.*;

/**
 * Created by emimo on 2/1/2017.
 */
public class Messages {
    Date time;
    public String num,text;
    public Messages(String number, String mes){
        num = number;
        text = mes;
        time = new Date(System.currentTimeMillis());
    }

    public Date getTheTime(){
        return time;
    }

    public String getTheRealTime(){
        DateFormat x = new SimpleDateFormat("HH:mm");
        return x.format(time);
    }

    public void changeUserInfo(String x, String y){
        num = x;
        text = y;
    }

    public String getPhoneNumber(){
        return num;
    }

    public String getMessage(){
        return text;
    }
}
