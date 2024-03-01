// Class CMPS 221
// Proj 2
// Name: Zach Boquet
// Due date: 4-11-22
import javax.swing.*;

public class Proj2
{ 
 public static void main(String[] args)
 {
 // declare loop variable
   int i;
   
 // create two SLLZB objects
  SLLZB<Term> poly1 = new SLLZB<Term>();
  SLLZB<Term> poly2 = new SLLZB<Term>();
  
 // take input for both polynomials and display them after
  Term term;
  int n, m, a, b;
  String nstr = JOptionPane.showInputDialog("How many terms in Poly 1?");
  n = Integer.parseInt(nstr);
  for(i=0; i < n; i++) { 
        String str = JOptionPane.showInputDialog("Enter value for coefficient in Poly1 at index " +i+ " in order of decreasing degree.");
        a = Integer.parseInt(str);
        str = JOptionPane.showInputDialog("Enter value for exponent in Poly1 at index " +i+ " in order of decreasing degree. "
                                         + "No negatives allowed.");
        b = Integer.parseInt(str);
        term = new Term(a, b);
        poly1.add(i, term);
    }
  
  String mstr = JOptionPane.showInputDialog("How many terms in Poly 2?");
  m = Integer.parseInt(mstr);
   for(i=0; i < m; i++) { 
        String str = JOptionPane.showInputDialog("Enter value for coefficient in Poly2 at index " +i+ " in order of decreasing degree.");
        a = Integer.parseInt(str);
        str = JOptionPane.showInputDialog("Enter value for exponent in Poly2 at index " +i+ " in order of decreasing degree. "
                                         + "No negatives allowed.");
        b = Integer.parseInt(str);
        term = new Term(a, b);
        poly2.add(i, term); 
    }
   
   System.out.println("The two polynomials before doing addition are: ");
   
    for (i=0;i<(poly1.size()-1);i++) {
      if((poly1.get(i)).getExp() == 0)
      { System.out.print((poly1.get(i)).getCoef());
      }
      else {
        System.out.print((poly1.get(i)).getCoef()+ "x^" +(poly1.get(i)).getExp()+ " + ");
      }
  }
    i=poly1.size()-1; // for last term in poly1
    if((poly1.get(i)).getExp() == 0)
      { System.out.print((poly1.get(i)).getCoef());
      }
      else {
        System.out.print((poly1.get(i)).getCoef()+ "x^" +(poly1.get(i)).getExp());
      }
    
    System.out.println();
    System.out.println(" and ");
    
    for (i=0;i<(poly2.size()-1);i++) {
      if((poly2.get(i)).getExp() == 0)
      { System.out.print((poly2.get(i)).getCoef());
      }
      else {
        System.out.print((poly2.get(i)).getCoef()+ "x^" +(poly2.get(i)).getExp()+ " + ");
      }
  }
    i=poly2.size()-1; // for last term in poly2
    if((poly2.get(i)).getExp() == 0)
      { System.out.print((poly2.get(i)).getCoef());
      }
      else {
        System.out.print((poly2.get(i)).getCoef()+ "x^" +(poly2.get(i)).getExp());
      }
    System.out.println();
  
 // add the two polynomials and display the resulting polynomial
  // add polys  
  SLLZB<Term> polysum = new SLLZB<Term>();
  int q=0;
    while( 0 !=(poly1.size()) && 0 !=(poly2.size())) {
      Term ft = poly1.get(0);
      Term st = poly2.get(0);
      int fexp = (ft.getExp());
      int fco = (ft.getCoef());
      int sexp = (st.getExp());
      int sco = (st.getCoef());
      
       if(ft == null || fexp < sexp) {
         term = new Term(sco, sexp);
         poly2.remove(0);
       }
       else 
         if(st == null || sexp < fexp) {
         term = new Term(fco, fexp);
         poly1.remove(0);
       }
       else
         if((fexp == 0) && (sexp == 0)) {
         term = new Term((fco + sco), 0);
         poly1.remove(0);
         poly2.remove(0);
       }
       else {
         term = new Term((fco + sco), fexp);
         poly1.remove(0);
         poly2.remove(0);
       }
      polysum.add(q, term);
      q++;
    }
    if(poly1.size() == 0 && poly2.size() == 0) {
      // do nothing }
    }
      else {
      if(poly1.size() == 0) {
        Term st = poly2.get(0);
        int sexp = (st.getExp());
        int sco = (st.getCoef());
        term = new Term(sco, sexp);
        polysum.add(q, term);
      }
      else
        if(poly2.size() == 0) {
        Term ft = poly1.get(0);
        int fexp = (ft.getExp());
        int fco = (ft.getCoef());
        term = new Term(fco, fexp);
        polysum.add(q, term);
      }
      }

    // print the resulting poly
  System.out.println("The polynomial sum after doing addition is: ");
  for (i=0;i<(polysum.size()-1);i++) {
      if((polysum.get(i)).getExp() == 0)
      { System.out.print((polysum.get(i)).getCoef());
      }
      else {
        System.out.print((polysum.get(i)).getCoef()+ "x^" +(polysum.get(i)).getExp()+ " + ");
      }
  }
      i=polysum.size()-1; // for last term in polysum
      if((polysum.get(i)).getExp() == 0)
      { System.out.print((polysum.get(i)).getCoef());
      }
      else {
        System.out.print((polysum.get(i)).getCoef()+ "x^" +(polysum.get(i)).getExp());
      }
      System.out.println();
  }
  
 }