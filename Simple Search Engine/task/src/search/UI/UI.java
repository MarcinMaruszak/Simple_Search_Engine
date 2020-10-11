package search.UI;

import search.domain.DataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UI {
    private Scanner scanner;
    private DataBase dataBase;


    public UI(Scanner scanner,String file) {
        this.scanner = scanner;
        dataBase=new DataBase(file);
    }

    public void go(){
        dataBase.loadFile();
        int number;
        label:
        while (true){
            printMenu();
            number = Integer.parseInt(scanner.nextLine());
            switch (number){
                case 0:
                    break label;
                case 1:
                    find();
                    break;
                case 2:
                    System.out.println();
                    dataBase.printAll();
                    break;
            }
        }
    }

    private void find() {
        System.out.println();
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        String matching = scanner.nextLine().toUpperCase();
        System.out.println("Enter a name or email to search all suitable people.");
        String query = scanner.nextLine().toLowerCase();
        ArrayList<String> queryArray = new ArrayList<>(Arrays.asList(query.split(" ")));
        dataBase.setSearchAlgorithm(matching,queryArray);
        dataBase.find();
    }

    private void printMenu(){
        System.out.println();
        System.out.println("=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");
    }


}
