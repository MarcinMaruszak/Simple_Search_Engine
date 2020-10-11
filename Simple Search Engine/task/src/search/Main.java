package search;

import search.UI.UI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new UI(scanner, args[1]).go();
    }
}
