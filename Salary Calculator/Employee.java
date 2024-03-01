public class Employee extends Person
{
 // new Data Fields
  public String department;
  public String jobtitle;
  public int yearofhire;
  
 // constructor
  public Employee(String firstname, int ssnum, int yrage,
  String gen, String ad, int phonenum, String dep, String job, int yrhired)
  {
  super(firstname, ssnum, yrage, gen, ad, phonenum);
  department = dep;
  jobtitle = job;
  yearofhire = yrhired;
  }
  
 // new methods
  public String toString()
  {
  String result = "Name: " + name
  + "\nSS Number: " + ssnumber
  + "\nAge: " + age + " years"
  + "\nGender: " + gender
  + "\nAddress: " + address
  + "\nPhone Number: " + phonenumber
  + "\nDepartment: " + department
  + "\nJob Title: " + jobtitle
  + "\nYear of Hire: " + yearofhire;
  return result;
  }
} // end of class