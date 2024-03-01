// Proj4

import javax.swing.*;

public class Proj4 {
   //get years and put them into an array
public static int [] infoObtainer()
  {
  int []x = new int[4];
 
  int guilty_Guilty, guilty_NotGuilty, notGuilty_Guitly, notGuilty_NotGuilty;
   String sguilty_Guilty, sguilty_NotGuilty, snotGuilty_Guitly, snotGuilty_NotGuilty;
    
   sguilty_Guilty = JOptionPane.showInputDialog("Enter number of years for Guilty, Guilty:");
       guilty_Guilty = Integer.parseInt(sguilty_Guilty);
    
    sguilty_NotGuilty = JOptionPane.showInputDialog("Enter number of years for Guilty, Not Guilty:");
       guilty_NotGuilty = Integer.parseInt(sguilty_NotGuilty);

    snotGuilty_Guitly = JOptionPane.showInputDialog("Enter number of years for Not Guilty, Guilty:");
       notGuilty_Guitly = Integer.parseInt(snotGuilty_Guitly);
    
    snotGuilty_NotGuilty = JOptionPane.showInputDialog("Enter number of years for Not Guilty, Not Guilty:");
       notGuilty_NotGuilty = Integer.parseInt(snotGuilty_NotGuilty);
       
       // echo results
        System.out.println("Years for Guilty Guilty:"+ guilty_Guilty);
        System.out.println("Years for Guilty NotGuilty:"+ guilty_NotGuilty);
        System.out.println("Years for NotGuilty Guilty:"+ notGuilty_Guitly);
        System.out.println("Years for notGuilty_NotGuilty:"+ notGuilty_NotGuilty);
       
       x[0] = guilty_Guilty;
       x[1] = guilty_NotGuilty;
       x[2] = notGuilty_Guitly;
       x[3] = notGuilty_NotGuilty;
       
       return x;
}

public static void decisionMaker(){
  
  //variables for choices

   int guilty_Guilty, guilty_NotGuilty, notGuilty_Guitly, notGuilty_NotGuilty,leftBest,rightBest;
  
  //get array from first method
 
   int []x = infoObtainer();
   
   //put array back into variables to do calculations easier
   guilty_Guilty = x[0];
   guilty_NotGuilty = x[1];
   notGuilty_Guitly = x[2];
   notGuilty_NotGuilty = x[3];
   
   //0 means not guilty is best choice for that column
   //1 means guilty is best choice for that column
   //-1 means neither choice matters for that column
  
   //find best choice for left column using column strategery
   if(guilty_Guilty > notGuilty_Guitly){
    leftBest =  0;
   }   
   else{
     leftBest = 1;
   }
   //check if both choices are equal
   if(guilty_Guilty == notGuilty_Guitly){
     leftBest = -1;
   }
   //find best choice for right side
    if(guilty_NotGuilty <  notGuilty_NotGuilty){
    rightBest =  1;
   }   
   else{
     rightBest = 0;
   }
  
    //check if choice does not matter for right side
   if(guilty_NotGuilty == notGuilty_NotGuilty){
     rightBest = -1;
   }
   //compare columns to see best plead
   if(rightBest==leftBest){
     if(rightBest==1){
       System.out.println("Guilty is best plea for both people");
   }
     if(rightBest==0){
     System.out.println("Not Guilty is the best plea  for both people");
   }
     //The choice does not matter so the computer will just respond with Guilty   
     if(rightBest==-1){
      System.out.println("Guilty is best plea for both people");
     }
   } 
     else{
        System.out.println("I can not help");
     
   }
}
   
  
  public static void main(String args[])
  {
    decisionMaker();
      
  } 
} 
