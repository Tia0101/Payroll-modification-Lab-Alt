// Name: Tia Vanderyacht
//Date: 04/18/2024
// Class: CS 145 9:30am face to face
// Assignment: Lab 4 pay roll modification.
// Purpose: Subclass to employee class, the class is to calculate monthly pay for Salaried employees.
// Citation: This program references chapter 10 of the Deitel/Deitel-11th edition(Early Objects), w3schools.com,and youtube

//(not sure if this was actualy extra credit)see lines 52-55 bonusEarning method created to calculate bonus in to employee earnings.
// When I read the lab instructions I thought we were suppose to write our own method to show polymorphism.

//Custom package created
package payroll;

public class SalariedEmployee extends Employee  {
   private double monthlySalary;

   // constructor
   public SalariedEmployee(String firstName, String lastName,
      String socialSecurityNumber, int month, int day, int year,
      double monthlySalary) {
      super(firstName, lastName, socialSecurityNumber, month, day, year);

      if (monthlySalary < 0.0) {
         throw new IllegalArgumentException(
            "Weekly salary must be >= 0.0");
      }

      this.monthlySalary = monthlySalary;
   }

   // set salary
   public void setMonthlySalary(double monthlySalary) {
      if (monthlySalary < 0.0) {
         throw new IllegalArgumentException(
            "Weekly salary must be >= 0.0");
      }

      this.monthlySalary = monthlySalary;
   }

   // return salary
   public double getMonthlySalary() {
      return monthlySalary;
   }

   // calculate earnings; override abstract method earnings in Employee
   @Override
   public double earnings() {
      return getMonthlySalary();
   }

   // Applies $100 bonus to earnings,overrides abstract method in Employee
   @Override
   public double bonusEarnings(){
      return earnings() + 100;
   }


   // return String representation of SalariedEmployee object
   @Override
   public String toString() {
      return String.format("Salaried employee: %s%n%s: $%,.2f",
         super.toString(), "Monthly salary", getMonthlySalary());
   }
}


