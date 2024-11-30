package org.example.models;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {


    public static ArrayList<String> groceryList=new ArrayList<>();
    Scanner scanner=new Scanner(System.in);
    public void startGrocery(){
        int choice=-1;
        do {
            System.out.println("Yapmak istenen işlem (0=>Çıkış 1=>Ekleme 2=>Çıkarma)");
            if(scanner.hasNextInt()){
                choice=scanner.nextInt();
                scanner.nextLine();
                switch (choice){
                    case 1:
                        System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                        String itemsToAdd=scanner.nextLine();
                        addItems(itemsToAdd.toLowerCase());
                        printSorted();
                        break;
                    case 2:
                        System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                        String itemsToRemove=scanner.nextLine();
                        removeItems(itemsToRemove.toLowerCase());
                        printSorted();
                        break;
                    default:
                        System.out.println("Geçerli işlem yapınız!");
                }
            }else {
                System.out.println("Lütfen geçerli bir işlem seçiniz (0, 1, 2)!");
                scanner.nextLine();
            }
        }
        while (choice!=0);
        scanner.close();
    }

    public static void removeItems(String itemsToRemove) {
        String[] splitItems=itemsToRemove.split(",");
        for(String item:splitItems){
            item=item.trim();
            if(checkItemIsInList(item)){
                groceryList.remove(item);
            }else{
                System.out.println("Silmek istenen ürün listede mevcut değil! "+ item);
            }
        }
        printSorted();
    }

    public static void addItems(String itemsToAdd) {
        String[] splitItems=itemsToAdd.split(",");
        for (String item:splitItems){
            item=item.trim();
            if(checkItemIsInList(item)){
                System.out.println("Eklemek istediğiniz eleman listede mevcut: "+item);
            }else {
                groceryList.add(item);
            }
        }
        printSorted();
    }

    public static boolean checkItemIsInList(String item) {
        return groceryList.contains(item);
    }

    public static void printSorted(){
        Collections.sort(groceryList);
        System.out.println("Mevcut pazar listesi: ");
        for (String item:groceryList){
            System.out.println(item);
        }
    }


}