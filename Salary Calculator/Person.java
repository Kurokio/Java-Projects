public class Person
{
 // Data Fields
  public String name;
  public int ssnumber;
  public int age;
  public String gender;
  public String address;
  public int phonenumber;
 
 // constructor
  public Person(String firstname, int ssnum, int yrage,
  String gen, String ad, int phonenum)
  {
  name = firstname;
  ssnumber = ssnum;
  age = yrage;
  gender = gen;
  address = ad;
  phonenumber = phonenum;
  }
 
 // methods or operations
  public String toString()
  {
  String result = "Name: " + name
  + "\nSS Number: " + ssnumber
  + "\nAge: " + age + " years"
  + "\nGender: " + gender
  + "\nAddress: " + address
  + "\nPhone Number: " + phonenumber;
  return result;
  }
} // end of class