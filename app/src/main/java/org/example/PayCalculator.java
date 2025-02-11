package org.example;

public class PayCalculator {

  public double roundnum (double value){
    return Math.round(value*100.00)/100.00;
  }

//Gross
  public double GrossCalc(double hours_worked) {
    double overtime = 0;
    double gross;

    if (hours_worked > 40){
      overtime = (hours_worked - 40) * 1.5 * 16.78;
      gross = (40 * 16.78) + overtime;
    }
    else{gross = hours_worked * 16.78;}

  return gross;
  }

  //Tax Deductions 
    public double SocialCalc(double gross){
    return (gross/100)*6;
    }

    public double FederalCalc(double gross){
    return (gross/100)*14;
    }
  
    public double StateCalc(double gross){
    return (gross/100)*5;
    }

  //Dependencies Deduction
    public double InsuranceCalc(double depend){
    double insurance;

    if(depend >= 3){insurance = 35;}
    else{return insurance = 15;}

    return insurance;
    }

  //Total Deduction
    public double TotalCalc(double sol, double fed, double state, double ins, double uni){
    return (sol+fed+state+ins+uni);
    }

//NetPay
  public double NetCalc(double gross, double total){
  return gross - total;
  }

}

