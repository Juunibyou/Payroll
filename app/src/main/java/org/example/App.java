package org.example;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    PayCalculator payCalculator = new PayCalculator();

    //User Input
    System.out.println("Hello welcome to the payroll caluclator!");
    System.out.println("How many hours did you work? Enter: ");
    double hours = scanner.nextDouble();

    System.out.println("How many depenencies do you have? Enter: ");
    double depend = scanner.nextInt();
    scanner.close();
    

    double gross = payCalculator.GrossCalc(hours);
    double socialtax = payCalculator.SocialCalc(gross);
    double federaltax = payCalculator.FederalCalc(gross);
    double statetax = payCalculator.StateCalc(gross);
    double insurance= payCalculator.InsuranceCalc(gross);
    double uniondue = 10.00;
    double totaldeduction = payCalculator.TotalCalc(socialtax,federaltax,statetax,insurance,uniondue);
    double netpay = payCalculator.NetCalc(gross,totaldeduction);

    //Display final
    System.out.println("Hours worked: "+ hours);
    System.out.println("Number of dependencies: "+ depend);
    System.out.println("Rate of Pay: $16.78\n");

    System.out.println("Gross earning: $"+ String.format("%.2f", payCalculator.roundnum(gross)));
    System.out.println("Social Security tax: -$"+ String.format("%.2f",payCalculator.roundnum(socialtax)));
    System.out.println("Federal Income tax: -$"+ String.format("%.2f",payCalculator.roundnum(federaltax)));
    System.out.println("States Income tax: -$"+ String.format("%.2f",payCalculator.roundnum(statetax)));
    System.out.println("Health Insurance Pay: -$"+ String.format("%.2f",payCalculator.roundnum(insurance)));
    System.out.println("Union dues: -$"+ String.format("%.2f",uniondue));
    System.out.println("Total deduction: -$"+ String.format("%.2f",payCalculator.roundnum(totaldeduction)));
    System.out.println("Net pay: $"+ String.format("%.2f",payCalculator.roundnum(netpay)));

    System.out.println("Thank you for using the payroll calculator! Goodbye....");
  }
}
