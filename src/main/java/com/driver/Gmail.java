package com.driver;

import java.util.*;
import java.util.Date;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    private List<Mail> g;
    private List<Mail> trash;
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity=inboxCapacity;
        this.g=new ArrayList<>();
        this.trash=new ArrayList<>();
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        if(g.size()>=inboxCapacity){
           Mail temp = g.remove(0);
            trash.add(temp);
            Mail newMail = new Mail(date,sender,message);
            g.add(newMail);
        }

    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        int count=0;
        for(Mail mail:g){
            String messages = mail.getMessage();
            if(messages.equals(message)){
                Mail temp = g.remove(count);
                trash.add(temp);
                break;
            }
            count++;
        }

    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(g.size()==0){
            return null;
        }
        Mail temp = g.get(g.size()-1);
        return temp.getMessage();

    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(g.size()==0){
            return null;
        }
        Mail temp = g.get(0);
        return temp.getMessage();
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int count = 0;

        for (Mail mail : g) { // Assuming inbox is your list of Mail objects
            Date mailDate = mail.getDate();

            // Check if the mailDate is within the specified range (inclusive)
            if (!mailDate.before(start) && !mailDate.after(end)) {
                count++;
            }
        }

        return count;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return g.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        trash.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }
}
