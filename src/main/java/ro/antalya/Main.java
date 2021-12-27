package ro.antalya;


import java.util.Scanner;


public class Main {

   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.println("Cu ce va servim?");
       String product = scanner.nextLine();
       Order comanda = new Order(Product.valueOf(product));

  }
}
