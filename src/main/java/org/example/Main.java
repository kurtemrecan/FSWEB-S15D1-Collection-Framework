package org.example;

import org.example.mobile.Contact;
import org.example.mobile.MobilePhone;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //       Grocery grocery=new Grocery();
        //       grocery.startGrocery();
        MobilePhone mob=new MobilePhone("32132",new ArrayList<>());
        mob.addNewContact(new Contact("Emre","2325234"));
        mob.addNewContact(new Contact("ŞÖMXCV","2325234"));
        mob.addNewContact(new Contact("lsşdfaş","2325234"));
        mob.addNewContact(new Contact("wererw","2325234"));
        mob.addNewContact(new Contact(null,"2325234"));
        mob.printContact();
    }
}
