// Name: Tia Vanderyacht
//Date: 04/18/2024
// Class: CS 145 9:30am face to face
// Assignment: Lab 4 pay roll modification.
// Purpose: Test class for payroll, shows the use of polymorphism
// Citation: This program references chapter 10 of the Deitel/Deitel-11th edition(Early Objects), w3schools.com,and youtube
import java.util.ArrayList;
import java.util.Scanner; // program uses Scanner to obtain user input

//import of custom payroll packages.
import payroll.BasePlusCommissionEmployee;
import payroll.CommissionEmployee;
import payroll.Employee;
import payroll.HourlyEmployee;
import payroll.SalariedEmployee;

public class PayrollSystemTest {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in); 
      ArrayList <Employee> employees = new ArrayList<>();
      boolean quit;
      int currentMonth;


      // Do while loop to collect user input for creating payroll class objects and populating array list
      do {
         System.out.println("Is the employee salaried, hourly, commission, or basecommission");
         String employmentType = input.next().toLowerCase();
         
      switch(employmentType){

         case "salaried":
            System.out.println("Please enter employee's first name name:");
            String firstName= input.next();
            System.out.println("Please enter employee's last name name:");
            String lastName = input.next();
            System.out.println("Please enter employee's social security number:");
            String socialSecurityNumber = input.next();
            System.out.println("Please enter employee's birth month (1-12):");
            int birthMonth = input.nextInt();
            System.out.println("Please enter employee's birth day (1-31):");
            int birthDay = input.nextInt();
            System.out.println("Please enter employee's  birth year (ex 1985):");
            int birthYear = input.nextInt();
            System.out.println("Please enter employee's monthly salary:");
            double monthlySalary = input.nextDouble();
            SalariedEmployee salariedEmployee = new SalariedEmployee(firstName,lastName,socialSecurityNumber,birthMonth,birthDay,birthYear,monthlySalary);
            employees.add(salariedEmployee);//object add to array list
         break;

         case "hourly":
            System.out.println("Please enter employee's first name name:");
            firstName= input.next();
            System.out.println("Please enter employee's last name name:");
            lastName = input.next();
            System.out.println("Please enter employee's social security number:");
            socialSecurityNumber = input.next();
            System.out.println("Please enter employee's birth month (1-12):");
            birthMonth = birthMonth = input.nextInt();
            System.out.println("Please enter employee's birth day (1-31):");
            birthDay = birthDay = input.nextInt();
            System.out.println("Please enter employee's  birth year (ex 1985):");
            birthYear = birthYear = input.nextInt();
            System.out.println("Please enter employee's hourly rate:");
            double wage = input.nextDouble();
            System.out.println("Please enter hours worked per week:");
            double hours = input.nextDouble();
            //Class object created
            HourlyEmployee hourlyEmployee = new HourlyEmployee(firstName,lastName,socialSecurityNumber,birthMonth,birthDay,birthYear,wage,hours);
            //Class object add to array list
            employees.add(hourlyEmployee);
         break;

         case "commission":
            System.out.println("Please enter employee's first name name:");
            firstName= input.next();
            System.out.println("Please enter employee's last name name:");
            lastName = input.next();
            System.out.println("Please enter employee's social security number:");
            socialSecurityNumber = input.next();
            System.out.println("Please enter employee's birth month (1-12):");
            birthMonth = input.nextInt();
            System.out.println("Please enter employee's birth day (1-31):");
            birthDay = input.nextInt();
            System.out.println("Please enter employee's  birth year (ex 1985):");
            birthYear = input.nextInt();
            System.out.println("Please enter gross sales:");
            double grossSales = input.nextDouble();
            System.out.println("Please enter commission rate(0.1-0.9):");
            double commissionRate = input.nextDouble();

            //Class object created
            CommissionEmployee commissionEmployee = new CommissionEmployee
            (firstName,lastName,socialSecurityNumber,birthMonth,birthDay,birthYear,grossSales,commissionRate);

            //Class object add to array list
            employees.add(commissionEmployee);//object add to array list
         break;

         case "basecommission":
            System.out.println("Please enter employee's first name name:");
            firstName= input.next();
            System.out.println("Please enter employee's last name name:");
            lastName = input.next();
            System.out.println("Please enter employee's social security number:");
            socialSecurityNumber = input.next();
            System.out.println("Please enter employee's birth month (1-12):");
            birthMonth = input.nextInt();
            System.out.println("Please enter employee's birth day (1-31):");
            birthDay =input.nextInt();
            System.out.println("Please enter employee's  birth year (ex 1985):");
            birthYear = input.nextInt();
            System.out.println("Please enter gross sales:");
            grossSales =  input.nextDouble();
            System.out.println("Please enter commission rate(0.1-0.9):");
            commissionRate =  input.nextDouble();
            System.out.println("Please enter Employee's monthly base salary:");
            Double baseSalary = input.nextDouble();

            //Class object created
            BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee
            (firstName,lastName,socialSecurityNumber,birthDay,birthMonth,birthYear,grossSales,commissionRate,baseSalary);

            //Class object add to array list
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

      do {
         System.out.print("Enter the current month (1 - 12): ");
         currentMonth = input.nextInt();
         System.out.println();
      } while ((currentMonth < 1) || (currentMonth > 12));

      System.out.println("Employees processed polymorphically:\n");
      
      //for loop where the polymorphism occurs
      for (Employee currentEmployee : employees) {
         System.out.println(currentEmployee); // invokes toString

         // if month of employee's birthday, add $100 to salary
         if (currentMonth == currentEmployee.getBirthDate().getMonth()) {
            System.out.printf(
               "Wages: $%,.2f, %s\n\n", currentEmployee.bonusEarnings(), // polymorhpism occurs to add $100 bonus
               "$100 bonus was added to pay");
         }
         else {
            System.out.printf(
               "Wages: $%,.2f\n\n", currentEmployee.earnings());
         }
      }

   }

   
}

