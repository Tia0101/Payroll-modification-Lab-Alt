// Name: Tia Vanderyacht
//Date: 04/27/2024
// Class: CS 145 9:30am face to face
// Assignment: Lab 4 pay roll modification.
// Purpose: Test class for payroll, shows the use of polymorphism
// Citation: This program references chapter 10 of the Deitel/Deitel-11th edition(Early Objects), w3schools.com,and youtube

// Extra Credit I rewrote this test class so the class object were created with user input for the parameters instead of being harder coded.
// This way the program can populate they ArrayList with as many employees as needed.


import java.util.ArrayList;
import java.util.Scanner;

//import of custom payroll packages.
import payroll.BasePlusCommissionEmployee;
import payroll.CommissionEmployee;
import payroll.Employee;
import payroll.HourlyEmployee;
import payroll.SalariedEmployee;

public class PayrollSystemTest {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      ArrayList <Employee> employees = new ArrayList<>();//Employee arraylist created for class objects to populate.
      boolean quit;
      int currentMonth;

      System.out.println("Welcome to Company X Payroll system\n");

      // Do while loop for collecting user input to create payroll class objects and populating array list
      do {
         System.out.println("Is the employee salaried, hourly, commission, or base-commission?");
         String employmentType = input.next().toLowerCase();
         
         switch(employmentType) {

            case "salaried":
               System.out.println("Please enter employee's first name name:");
               String firstName= input.next();
               System.out.println("Please enter employee's last name name:");
               String lastName = input.next();
               System.out.println("Please enter employee's social security number:");
               String socialSecurityNumber = input.next();
               System.out.println("Please enter employee's birth date in mm/dd/yyyy format:");
               String birthDate = input.next();
               int birthMonth = Integer.parseInt(birthDate.substring(0, 2));
               int birthDay = Integer.parseInt(birthDate.substring(3, 5));
               int birthYear = Integer.parseInt(birthDate.substring(6, 10));
               System.out.println("Please enter employee's monthly salary:");
               double monthlySalary = input.nextDouble();
               //Class object created
               SalariedEmployee salariedEmployee = new SalariedEmployee(firstName,lastName,socialSecurityNumber,birthMonth,birthDay,birthYear,monthlySalary);
               //Class object added to arraylist
               employees.add(salariedEmployee);
            break;

            case "hourly":
               System.out.println("Please enter employee's first name:");
               firstName= input.next();
               System.out.println("Please enter employee's last name:");
               lastName = input.next();
               System.out.println("Please enter employee's social security number:");
               socialSecurityNumber = input.next();
               System.out.println("Please enter employee's birth date in mm/dd/yyyy format:");
               birthDate = input.next();
               birthMonth = Integer.parseInt(birthDate.substring(0, 2));
               birthDay = Integer.parseInt(birthDate.substring(3, 5));
               birthYear = Integer.parseInt(birthDate.substring(6, 10));
               System.out.println("Please enter employee's hourly rate:");
               double hourlyPay= input.nextDouble();
               System.out.println("Please enter hours worked per week:");
               double hours = input.nextDouble();
               //Class object created
               HourlyEmployee hourlyEmployee = new HourlyEmployee(firstName,lastName,socialSecurityNumber,birthMonth,birthDay,birthYear,hourlyPay,hours);
               //Class object added to array list
               employees.add(hourlyEmployee);
            break;

            case "commission":
               System.out.println("Please enter employee's first name:");
               firstName= input.next();
               System.out.println("Please enter employee's last name:");
               lastName = input.next();
               System.out.println("Please enter employee's social security number:");
               socialSecurityNumber = input.next();
               System.out.println("Please enter employee's birth date in mm/dd/yyyy format:");
               birthDate = input.next();
               birthMonth = Integer.parseInt(birthDate.substring(0, 2));
               birthDay = Integer.parseInt(birthDate.substring(3, 5));
               birthYear = Integer.parseInt(birthDate.substring(6, 10));
               System.out.println("Please enter gross sales:");
               double grossSales = input.nextDouble();
               System.out.println("Please enter commission rate(0.1-0.9):");
               double commissionRate = input.nextDouble();

               //Class object created
               CommissionEmployee commissionEmployee = new CommissionEmployee
               (firstName,lastName,socialSecurityNumber,birthMonth,birthDay,birthYear,grossSales,commissionRate);

               //Class object added to array list
               employees.add(commissionEmployee);//object add to array list
            break;

            case "base-commission":
               System.out.println("Please enter employee's first name:");
               firstName = input.next();
               System.out.println("Please enter employee's last name:");
               lastName = input.next();
               System.out.println("Please enter employee's social security number:");
               socialSecurityNumber = input.next();
               System.out.println("Please enter employee's birth date in mm/dd/yyyy format:");
               birthDate = input.next();
               birthMonth = Integer.parseInt(birthDate.substring(0, 2));
               birthDay = Integer.parseInt(birthDate.substring(3, 5));
               birthYear = Integer.parseInt(birthDate.substring(6, 10));
               System.out.println("Please enter gross sales:");
               grossSales =  input.nextDouble();
               System.out.println("Please enter commission rate(0.1-0.9):");
               commissionRate =  input.nextDouble();
               System.out.println("Please enter Employee's monthly base salary:");
               Double baseSalary = input.nextDouble();

               //Class object created
               BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee
               (firstName,lastName,socialSecurityNumber,birthMonth,birthDay,birthYear,grossSales,commissionRate,baseSalary);

               //Class object added to array list
               employees.add(basePlusCommissionEmployee);
            break;
            default: System.out.println("Invalid employment type");
            }
         
         System.out.println("Do you have any other employee's to add to the payroll");
         String exit = input.next();

         if (exit.equalsIgnoreCase("no")){
            quit = true;
         } else {
            quit = false;
         }
      } while (!quit);

      System.out.println("Employee wages before any bonuses have been applied");

      //for loop to show wages before the bonus polymorphism, this for loop uses polymorphism.
      for(Employee wage: employees){
         System.out.printf("%n%s%n",wage);
         System.out.printf(
               "Wages: $%,.2f\n\n", wage.earnings());
      }

      do {
         System.out.print("Enter the current month (1 - 12): ");
         currentMonth = input.nextInt();
         System.out.println();
      } while ((currentMonth < 1) || (currentMonth > 12));

      System.out.println("Employees processed polymorphically:\n");
      
      //for loop where the bonus polymorphism occurs
      for (Employee currentEmployee : employees) {
         System.out.println(currentEmployee); // invokes toString

         // if month of employee's birthday, add $100 to salary
         if (currentMonth == currentEmployee.getBirthDate().getMonth()) {
            System.out.printf(
               "Wages: $%,.2f, %s\n\n", currentEmployee.bonusEarnings(), //polymorphism of the method I created occurs to add $100 bonus.
               "$100 bonus was added to pay");
         }
         else {
            System.out.printf(
               "Wages: $%,.2f\n\n", currentEmployee.earnings());
         }
      }
   }
}

