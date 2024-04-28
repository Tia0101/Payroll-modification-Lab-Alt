// Name: Tia Vanderyacht
//Date: 04/27/2024
// Class: CS 145 9:30am face to face
// Assignment: Lab 4 pay roll modification.
// Purpose: Subclass to employee class, the class is to calculate pay for commission employees.
// Citation: This program references chapter 10 of the Deitel/Deitel-11th edition(Early Objects), w3schools.com,and youtube


//Custom package created
package payroll;
public class CommissionEmployee extends Employee {
   private double grossSales; // gross weekly sales
   private double commissionRate; // commission percentage

   // constructor
   public CommissionEmployee(String firstName, String lastName,
      String socialSecurityNumber, int month, int day, int year,
      double grossSales, double commissionRate) {
      super(firstName, lastName, socialSecurityNumber, month, day, year);

      if (commissionRate <= 0.0 || commissionRate >= 1.0) { // validation
         throw new IllegalArgumentException(
            "Commission rate must be > 0.0 and < 1.0");
      }

      if (grossSales < 0.0) { // validate
         throw new IllegalArgumentException("Gross sales must be >= 0.0");
      }

      this.grossSales = grossSales;
      this.commissionRate = commissionRate;
   } 

   // set gross sales amount
   public void setGrossSales(double grossSales) {
      if (grossSales < 0.0) { // validation
         throw new IllegalArgumentException("Gross sales must be >= 0.0");
      }

      this.grossSales = grossSales;
   } 

   // return gross sales amount
   public double getGrossSales() {
      return grossSales;
   } 

   // set commission rate
   public void setCommissionRate(double commissionRate) {
      if (commissionRate <= 0.0 || commissionRate >= 1.0) { // validation
         throw new IllegalArgumentException(
            "Commission rate must be > 0.0 and < 1.0");
      }

      this.commissionRate = commissionRate;
   } 

   // return commission rate
   public double getCommissionRate() {
      return commissionRate;
   } 

   // calculate earnings; override abstract method earnings in Employee
   @Override
   public double earnings() {
      return getCommissionRate() * getGrossSales();
   }

   //Applies $100 bonus to earnings,overrides abstract method in Employee
   @Override
   public double bonusEarnings() {
      return earnings() + 100;
   }

   // return String representation of CommissionEmployee object
   @Override
   public String toString() {
      return String.format("%s: %s%n%s: $%,.2f; %s: %.2f",
         "Commission employee", super.toString(),
         "Gross sales", getGrossSales(),
         "Commission rate", getCommissionRate());
   } 
}
