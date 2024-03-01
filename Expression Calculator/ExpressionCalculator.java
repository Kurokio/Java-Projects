public class ExpressionCalculator {
  
  String[] tokens = new String[1];
  Parse thing = new Parse();
  int result=0;
  int tempresult=0;
  int temporesult=0;
  int counter=0;
  int i;
  
 public int expCalc(String s) {
    if((s.indexOf("-") == -1) && (s.indexOf("*") == -1) && (s.indexOf("/") == -1) && (s.indexOf("+") == -1)) {
      result = thing.parseInt(s);
    }
    if(s.indexOf("+") != -1) {
      String[] tokens = s.split("[+]");
      for(i=0; i<tokens.length; i++)
      {
       System.out.println("this is token["+i+"] in add: "+tokens[i]);
      }
      if((s.indexOf("-") == -1) && (s.indexOf("*") == -1) && (s.indexOf("/") == -1)) {
      for(i=0; i<tokens.length; i++) {
        System.out.println("Hi12121");
        result = result + thing.parseInt(tokens[i]);
        System.out.println("This is result"+i+": "+result);
      }
      } else {
        for(i=0; i<tokens.length; i++) {
          System.out.println("i is " +i);
          result = (result + expCalc(tokens[i]));
          System.out.println("Hi50");
          System.out.println("This is result"+i+" "+result);
      }
    }
      s = s.substring(0, 2);
  /*   for(i=0; i<tokens.length; i++) { // only works if add is first operation
       if((minus.equals(s.charAt(i))) || (multi.equals(s.charAt(i))) || (div.equals(s.charAt(i)))) {
         counter++;
       
       }
      } */
    }
    if(s.indexOf("-") != -1) {
      System.out.println("Hi2");
      String[] tokens = s.split("[-]");
      for(i=0; i<tokens.length; i++)
      {
       System.out.println("this is token["+i+"] in sub: "+tokens[i]);
      }
      if((s.indexOf("*") == -1) && (s.indexOf("/") == -1)) {
      for(i=0; i<(tokens.length-1); i++) {
        System.out.println("Hi23");
        tempresult = (tempresult + (thing.parseInt(tokens[i]) - thing.parseInt(tokens[i+1])));
        System.out.println("The tempresult in sub is "+tempresult);
      }
      result = tempresult;
      System.out.println("The result before returning in sub is "+result);
      } else{
        for(i=0; i<tokens.length; i++) {
          System.out.println("Hi90");
        result = (result + expCalc(tokens[i]));
        System.out.println("The result in sub is "+result);
      }
    }
    }
   if(s.indexOf("*") != -1) {
      System.out.println("Hi3");
      String[] tokens = s.split("[*]");
      for(i=0; i<tokens.length; i++)
      {
       System.out.println("this is token["+i+"] in multi: "+tokens[i]);
      }
      if(s.indexOf("/") == -1) {
      for(i=0; i<tokens.length-1; i++) {
        System.out.println("Hi30");
        tempresult = (tempresult + (thing.parseInt(tokens[i])*thing.parseInt(tokens[i+1])));
        System.out.println("The tempresult in multi is "+tempresult);
      }
        result = tempresult;
        System.out.println("The result in multi is "+result);
      } else {
        for(i=0; i<tokens.length; i++) {
          System.out.println("Hi35");
        result = (result + expCalc(tokens[i]));
      }
    }
    }
    if(s.indexOf("/") != -1) {
      System.out.println("Hi4");
      String[] tokens = s.split("[/]");
      for(i=0; i<tokens.length; i++)
      {
       System.out.println("this is token["+i+"] in div: "+tokens[i]);
      }
      for(i=0; i<tokens.length-1; i++) {
        System.out.println("Hi45");
      temporesult = (temporesult + ((thing.parseInt(tokens[i]))/(thing.parseInt(tokens[i+1]))));
      System.out.println("The tempresult in div is "+temporesult);
      }
      result = temporesult;
    }
    return result;
 }
}
  
        
  
