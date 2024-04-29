// Name: Tia Vanderyacht
//Date: 04/18/2024
// Class: CS 145 9:30am face to face
// Assignment: Lab 4 pay roll modification.
// Purpose: Subclass to employee class, the class is to calculate pay for hourly employees.
// Citation: This program references chapter 10 of the Deitel/Deitel-11th edition(Early Objects), w3schools.com,and youtube

//Custom package created
package payroll;

public class HourlyEmployee extends Employee {
   private double wage; // wage per hour
   private double hours; // hours worked for week

   // constructor
   public HourlyEmployee(String firstName, String lastName,
      String socialSecurityNumber, int month, int day, int year,
      double wage, double hours) {
      super(firstName, lastName, socialSecurityNumber, month, day, year);

      if (wage < 0.0) { // validate wage
         throw new IllegalArgumentException(
            "Hourly wage must be >= 0.0");
      }

      if ((hours < 0.0) || (hours > 168.0)) { // validate hours
         throw new IllegalArgumentException(
            "Hours worked must be >= 0.0 and <= 168.0");
      }

      this.wage = wage;
      this.hours = hours;
   }

   // set wage
   public void setWage(double wage) {
      if (wage < 0.0) { // validate wage
         throw new IllegalArgumentException(
            "Hourly wage must be >= 0.0");
      }

      this.wage = wage;
   }

   // return wage
   public double getWage() {
      return wage;
   }

   // set hours worked
   public void setHours(double hours) {
      if ((hours < 0.0) || (hours > 168.0)) { // validate hours
         throw new IllegalArgumentException(
            "Hours worked must be >= 0.0 and <= 168.0");
      }

      this.hours = hours;
   }

   // return hours worked
   public double getHours() {
      return hours;
   }

   // calculate monthly earnings earnings; override abstract method earnings in Employee
   @Override
   public double earnings() {
      if (getHours() <= 40) { // no overtime
         return getWage() * getHours() * 4;
      }
      else {
            double regularPay = 40 * getWage();
            double overtimePay = (getHours() - 40) * getWage() * 1.5;
         return (regularPay + overtimePay) * 4;
      }
   }

   // Applies $100 bonus to earnings,overrides abstract method in Employee
   @Override
   public double bonusEarnings(){
      return earnings() + 100;
   }

   // return String representation of HourlyEmployee object
   @Override
   public String toString() {
      return String.format("Hourly employee: %s%n%s: $%,.2f; %s: %,.2f",
         super.toString(), "Hourly wage", getWage(),
         "Hours worked", getHours());
   }
}


