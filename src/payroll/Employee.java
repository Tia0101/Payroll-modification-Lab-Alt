// Name: Tia Vanderyacht
//Date: 04/27/2024
// Class: CS 145 9:30am face to face
// Assignment: Lab 4 pay roll modification.
// Purpose: Employee abstract super class for payroll.
// Citation: This program references chapter 10 of the Deitel/Deitel-11th edition(Early Objects), w3schools.com,and youtube

//(not sure if this was actualy extra credit)see lines 60 abstract bonusEarning method for polymorphism
// When I read the lab instructions I thought we were suppose to write our own method to show polymorphism.

//Custom package created
package payroll;

public abstract class Employee  {
   private final String firstName;
   private final String lastName;
   private final String socialSecurityNumber;
   private final Date birthDate;

   // constructor
   public Employee(String firstName, String lastName,String socialSecurityNumber, int month, int day, int year) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.socialSecurityNumber = socialSecurityNumber;
      this.birthDate = new Date(month, day, year);
   } 

   // return first name
   public String getFirstName() {
      return firstName;
   } 

   // return last name
   public String getLastName() {
      return lastName;
   } 
   // return social security number
   public String getSocialSecurityNumber() {
      return socialSecurityNumber;
   }

   // return birth date
   public Date getBirthDate() {
      return birthDate;
   }

   // return String representation of Employee object
   @Override
   public String toString() {
      return String.format("%s %s%n%s: %s%n%s: %s",
         getFirstName(), getLastName(),
         "Social security number", getSocialSecurityNumber(),
         "Birth date", getBirthDate());
   }

   // abstract method
   public abstract double earnings();
   
   //abstracted method
   public abstract double bonusEarnings();
}

