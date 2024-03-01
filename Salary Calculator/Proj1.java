// Class CMPS 221
// Project 1
// Name: Zach Boquet
// Due date:2-18-22

public class Proj1
{
 public static void main(String[] args)
 {
 // create a Person object
  Person p = new Person("Todd", 125455777, 31, "Male", "124 Lenux Lane", 1024584771);
  
 // create a Student object
  Student s = new Student("Felicity", 255330951, 25, "Female", "217 Bellevue Blvd", 1161208713, 3.5, "Accounting", 2022);
  
 // create a Employee object
  Employee e = new Employee("Bryan", 145593404, 47, "Male", "235 Faraway Road", 1020094512, "IT", "Electronics Repair Agent", 1989);
  
 // create a HourlyEmployee object
  HourlyEmployee he = new HourlyEmployee("Sue", 431124521, 21, "Female", "698 Divine Drive", 1177579131, "Faculty and Staff", "Kindergarten Teacher", 2015, 18.25, 64.5, 325.60);
  
 // create a SalaryEmployee object
  SalaryEmployee se = new SalaryEmployee("Max", 787522367, 61, "Male", "413 Champion Court", 1051343546, "R&D", "Senior Researcher", 1979, 24700.00);
  
 // printout the information of your Person object
 // using the toString method of the Person object
  System.out.println("The person’s info is:\n" + p.toString());
  System.out.println();
  
 // printout the information of your Student object
 // using the toString method of the Student object
  System.out.println("The student’s info is:\n" + s.toString());
  System.out.println();
  
  // printout the information of your Employee object
 // using the toString method of the Employee object
  System.out.println("The employee’s info is:\n" + e.toString());
  System.out.println();
  
  // printout the information of your HourlyEmployee object
 // using the toString method of the HourlyEmployee object
  System.out.println("The hourly employee’s info is:\n" + he.toString());
  System.out.println();
  
  // printout the information of your SalaryEmployee object
 // using the toString method of the SalaryEmployee object
  System.out.println("The salaried employee’s info is:\n" + se.toString());
  System.out.println();
 }
} 