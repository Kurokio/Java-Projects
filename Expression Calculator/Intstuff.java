import java.util.*;
import java.util.Scanner;


public class Intstuff
{
  public static int parse(String s){
    if (s.equals("")) {
            return 0;
        }
        int other = s.charAt(s.length()-1)-'0';
        String whatever = s.substring(0,s.length()-1);
        return other + (parse(whatever)*10);
  }
}