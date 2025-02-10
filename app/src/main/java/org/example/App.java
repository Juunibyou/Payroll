package org.example;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Hello welcome to the payroll caluclator!");

    //User Input
    System.out.println("How many hours did you work? Enter: ");
    double hours = scanner.nextInt();

    System.out.println("How many depenencies do you have? Enter: ");
    int depend = scanner.nextInt();
    scanner.close();

    //Calculate pay and deduction
    double overtime = 0;
    double gross;

      //Gross earning
      if(hours > 40){
        overtime = Math.abs(40-hours)*1.5;
        gross = (hours*16.78)+overtime;
      }
      else{gross = hours*16.78;}

      //Deduction
      double socialtax = (gross/100)*6;
      double federaltax = (gross/100)*14;
      double statetax = (gross/100)*5;

        //dependencies deduction
        double insurance = 0;
        if(depend >= 3){insurance = 35;}
        else{insurance = 15;}

      double totalDeduction = (socialtax+federaltax+statetax+insurance);

      //Net pay
      double netpay = gross - totalDeduction;

    //Display final
    System.out.println("Hours worked: "+ hours);
    System.out.println("Number of dependencies: "+ depend);
    System.out.println("Rate of Pay: $16.78\n");

    System.out.println("Gross earning: $"+ gross);
    System.out.println("Social Security tax: -$"+ socialtax);
    System.out.println("Federal Income tax: -$"+ federaltax);
    System.out.println("States Income tax: -$"+ statetax);
    System.out.println("Health Insurance Pay: -$"+ insurance);
    System.out.println("Union dues: -$10.00");
    System.out.println("Total deduction: -$"+ totalDeduction);
    System.out.println("Net pay: $"+ netpay);

    System.out.println("Thank you for using the payroll calculator! Goodbye....");
  }
}
