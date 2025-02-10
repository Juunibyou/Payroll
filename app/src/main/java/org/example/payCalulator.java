package org.example;

public class payCalulator {
    public double gross (double hours_worked){
      double overtime = 0;
      double gross;

      if (hours_worked > 40){
        overtime = (hours_worked - 40) * 1.5;
        gross = (40 * 16.78) + overtime; 
        } 
      else {gross = hours_worked * 16.78;}

      return gross;
    }
}
