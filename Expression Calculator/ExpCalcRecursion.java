public class ExpCalcRecursion {
  
  String[] tokens = new String[1];
  Parse thing = new Parse();
  int result=0;
  int tempresult=0;
  int temporesult=0;
  int counter=0;
  int i, par, par2;
  String exp;
  
  public int expCalc(String s) {
    if(s.indexOf("+") != -1) {
      String[] tokens = s.split("[+]");
      for(i=0; i<tokens.length; i++)
      {
       System.out.println("this is token["+i+"] in add: "+tokens[i]);
      }
      for(i=0; i<tokens.length; i++) {
          System.out.println("i is " +i);
          result = (result + expCalc(tokens[i]));
          System.out.println("Hi50");
          System.out.println("This is result"+i+" "+result);
      }
    }
    if(s.indexOf("-") != -1) {
      String[] tokens = s.split("[-]");
      for(i=0; i<tokens.length; i++)
      {
       System.out.println("this is token["+i+"] in sub: "+tokens[i]);
      }
      for(i=0; i<tokens.length; i++) {
          System.out.println("i is " +i);
          result = (result - expCalc(tokens[i]));
          System.out.println("Hi5");
          System.out.println("This is result"+i+" "+result);
      }
    } else {
      if(s.indexOf("*") != -1) {
        String[] tokens = s.split("[*]");
      for(i=0; i<tokens.length; i++)
      {
       System.out.println("this is token["+i+"] in multi: "+tokens[i]);
      }
      for(i=0; i<tokens.length; i++) {
          System.out.println("i is " +i);
          result = (result * expCalc(tokens[i]));
          System.out.println("Hi4");
          System.out.println("This is result"+i+" "+result);
      }
    }
      if(s.indexOf("/") != -1) {
        String[] tokens = s.split("[/]");
      for(i=0; i<tokens.length; i++)
      {
       System.out.println("this is token["+i+"] in div: "+tokens[i]);
      }
      for(i=0; i<tokens.length; i++) {
          System.out.println("i is " +i);
          result = (result / expCalc(tokens[i]));
          System.out.println("Hi30");
          System.out.println("This is result"+i+" "+result);
      }
      } else {
        if(s.indexOf("(") != -1 && s.indexOf(")") != -1) {
        par = s.indexOf("(");
        par2 = s.indexOf(")");
        exp = s.substring((par+1), par2);
       System.out.println("this is expression in parentheses "+exp);
          result = (result + expCalc(exp));
          System.out.println("Hi10");
          System.out.println("This is result"+i+" "+result);
        } else {
          if(s = "0" || s = "1" || s = "2" || s = "3" || s = "4" ||
             s = "5" || s = "6" || s = "7" || s = "8" || s = "9") {
            result = thing.parseInt(s);
          } else {
          System.out.print("Syntax error");
          }
        }
      }
    }
  return result; }
}
            
        
    