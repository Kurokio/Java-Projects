public class Parse
{
  public int parseInt(String s){
    if (s.equals("")) {
            return 0;
        }
        int other = s.charAt(s.length()-1)-'0';
        String whatever = s.substring(0,s.length()-1);
        return other + (parseInt(whatever)*10);
    }
}