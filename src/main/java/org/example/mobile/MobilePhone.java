package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    public MobilePhone(String myNumber,List<Contact> myContacts){
        this.myNumber=myNumber;
        this.myContacts=myContacts;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public boolean addNewContact(Contact contact){
        if(contact==null||contact.getPhoneNumber().equalsIgnoreCase(myNumber)||contact.getName()==null||contact.getPhoneNumber()==null){
            return false;
        }

        if(findContact(contact.getName())>=0){
            return false;
        }
        return this.myContacts.add(contact);
    }

    public boolean updateContact(Contact oldContact,Contact newContact){
        int index=findContact(oldContact);
        if(index<=0){
            return false;
        }
        this.myContacts.set(index,newContact);
        return true;
    }
    public boolean removeContact(Contact contact){
        if(contact==null||findContact(contact)<0){
            return false;
        }
        return this.myContacts.remove(contact);
    }
    public int findContact(Contact contact){
        return myContacts.indexOf(contact);
    }
    public int findContact(String contactName){
        for(int i=0;i<myContacts.size();i++){
            Contact contact=myContacts.get(i);
            if(contact.getName().equalsIgnoreCase(contactName) ){
                return i;
            }
        }
        return -1;
    }
    public Contact queryContact(String contactName){
        int contactIndex=findContact(contactName);
        if(contactIndex<0){
            return null;
        }
        return this.myContacts.get(contactIndex);

    }
    public void printContact(){
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact=myContacts.get(i);
            System.out.println((i+1)+". "+contact.getName()+" ->"+contact.getPhoneNumber());
        }
    }
}