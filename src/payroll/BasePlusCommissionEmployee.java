// Name: Tia Vanderyacht
//Date: 04/18/2024
// Class: CS 145 9:30am face to face
// Assignment: Lab 4 pay roll modification.
// Purpose: Subclass to commission employee class, the class is to calculate pay for a salaried employee who also earns commission on sales.
// Citation: This program references chapter 10 of the Deitel/Deitel-11th edition(Early Objects), w3schools.com,and youtube



package payroll;
public class BasePlusCommissionEmployee extends CommissionEmployee {
   private double baseSalary; // base salary per week

   // constructor
   public BasePlusCommissionEmployee(String firstName, String lastName,
      String socialSecurityNumber, int month, int day, int year,
      double grossSales, double commissionRate, double baseSalary) {
      super(firstName, lastName, socialSecurityNumber,
         month, day, year, grossSales, commissionRate);

      if (baseSalary < 0.0) { // validate baseSalary
         throw new IllegalArgumentException("Base salary must be >= 0.0");
      }

      this.baseSalary = baseSalary;
   }

   // set base salary
   public void setBaseSalary(double baseSalary) {
      if (baseSalary < 0.0) { // validate baseSalary
         throw new IllegalArgumentException("Base salary must be >= 0.0");
      }

      this.baseSalary = baseSalary;
   }

   // return base salary
   public double getBaseSalary() {
      return baseSalary;
   }

   // calculate earnings; override method earnings in CommissionEmployee
   @Override
   public double earnings() {
      return getBaseSalary() + super.earnings();
   }

   // Applies $100 bonus to earnings,overrides abstract method in Employee
   @Override
   public double bonusEarnings(){
      return earnings() + 100;
   }

   // return String representation of BasePlusCommissionEmployee object
   @Override
   public String toString() {
      return String.format("%s %s; %s: $%,.2f",
         "Base-salaried", super.toString(),
         "Base salary", getBaseSalary());
   }
}

