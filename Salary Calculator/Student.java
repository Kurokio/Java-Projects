public class Student extends Person
{
 // new Data Fields
  public double gradeptavg;
  public String major;
  public int graduationyear;
  
 // constructor
  public Student(String firstname, int ssnum, int yrage,
  String gen, String ad, int phonenum, double gpa, String maj, int gradyr)
  {
  super(firstname, ssnum, yrage, gen, ad, phonenum);
  gradeptavg = gpa;
  major = maj;
  graduationyear = gradyr;
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
  + "\nGPA: " + gradeptavg
  + "\nMajor: " + major
  + "\nGraduation Year: " + graduationyear;
  return result;
  }
} // end of class