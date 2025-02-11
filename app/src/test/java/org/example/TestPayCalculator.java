package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPayCalculator {

    PayCalculator payCalculator;

  @BeforeEach
  void setup() {
    payCalculator = new PayCalculator();
  }

  //|-------------------------------------------------GROSS----------------------------------------------------|
  @Test
  void itCalculatesThePayForZero(){
    assertEquals(payCalculator.GrossCalc(0), 0);
  }

  @Test
  void itCalculatesThePayForOne(){
    assertEquals(payCalculator.GrossCalc(1), 16.78);
  }

  @Test
  void itCalculatesThePayForTen(){
    assertEquals(payCalculator.GrossCalc(10), 167.80);
  }

  @Test
  void itCalculatesThePayForTwenty(){
    assertEquals(payCalculator.GrossCalc(50), (16.78*40)+(16.78*10*1.5));
  }

//|-------------------------------------------------DEDUCTION----------------------------------------------------|
  @Test
  void itCalculatesDeductions50() {
    double GrossPay = payCalculator.GrossCalc(50);
      
    double socialTax = payCalculator.SocialCalc(GrossPay); 
    double federalTax = payCalculator.FederalCalc(GrossPay); 
    double stateTax = payCalculator.StateCalc(GrossPay);  
    double insurance = payCalculator.InsuranceCalc(2);  
    double unionDues = 10.00; 

    double expectedTotalDeductions = socialTax + federalTax + stateTax + insurance + unionDues;
      
  
    assertEquals(expectedTotalDeductions, payCalculator.TotalCalc(socialTax, federalTax, stateTax, insurance, unionDues));
  }

  @Test
  void itCalculatesDeductions10() {
    double GrossPay = payCalculator.GrossCalc(10);
      
    double socialtax = payCalculator.SocialCalc(GrossPay); 
    double federaltax = payCalculator.FederalCalc(GrossPay); 
    double statetax = payCalculator.StateCalc(GrossPay);  
    double insurance = payCalculator.InsuranceCalc(5);  
    double uniondues = 10.00; 

    double expectedTotalDeductions = socialtax + federaltax + statetax + insurance + uniondues;
      
  
    assertEquals(expectedTotalDeductions, payCalculator.TotalCalc(socialtax, federaltax, statetax, insurance, uniondues));
  }

//|-------------------------------------------------NET----------------------------------------------------|
@Test
  void itCalculatesNet50() {
    double GrossPay = payCalculator.GrossCalc(50);
      
    double socialtax = payCalculator.SocialCalc(GrossPay); 
    double federaltax = payCalculator.FederalCalc(GrossPay); 
    double statetax = payCalculator.StateCalc(GrossPay);  
    double insurance = payCalculator.InsuranceCalc(5);  
    double uniondues = 10.00; 

    double expectedTotalDeductions = socialtax + federaltax + statetax + insurance + uniondues;
    double expectedNet = GrossPay - expectedTotalDeductions;
  
    assertEquals(expectedNet, payCalculator.NetCalc(GrossPay, expectedTotalDeductions));
  }

@Test
  void itCalculatesNet100() {
    double GrossPay = payCalculator.GrossCalc(100);
      
    double socialtax = payCalculator.SocialCalc(GrossPay); 
    double federaltax = payCalculator.FederalCalc(GrossPay); 
    double statetax = payCalculator.StateCalc(GrossPay);  
    double insurance = payCalculator.InsuranceCalc(5);  
    double uniondues = 10.00; 

    double expectedTotalDeductions = socialtax + federaltax + statetax + insurance + uniondues;
    double expectedNet = GrossPay - expectedTotalDeductions;
  
    assertEquals(expectedNet, payCalculator.NetCalc(GrossPay, expectedTotalDeductions));
  }

@Test
  void itCalculatesNetZero() {
    double GrossPay = payCalculator.GrossCalc(0);
      
    double socialtax = payCalculator.SocialCalc(GrossPay); 
    double federaltax = payCalculator.FederalCalc(GrossPay); 
    double statetax = payCalculator.StateCalc(GrossPay);  
    double insurance = payCalculator.InsuranceCalc(5);  
    double uniondues = 10.00; 

    double expectedTotalDeductions = socialtax + federaltax + statetax + insurance + uniondues;
    double expectedNet = GrossPay - expectedTotalDeductions;
  
    assertEquals(expectedNet, payCalculator.NetCalc(GrossPay, expectedTotalDeductions));
  }
}