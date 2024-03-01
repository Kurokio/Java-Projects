// Class CMPS 221
// Proj 3
// Name: Zach Boquet and Gustavo Perez
// Due date: 5-2-22

import java.util.*;
import java.util.Scanner;

public class Proj3 
{
  public static void main(String[] args) 
  {
   
    ExpCalcRecursion a = new ExpCalcRecursion();
    Scanner print = new Scanner(System.in);
    System.out.println("What is the expression?");
    String input = print.nextLine();
    System.out.println("The answer is "+a.expCalc(input)); 
    System.exit(0);
  }
}
    