//Proj 6



 import javax.swing.*;
  
 public class Proj6 {
  
    //Opens the game and finds out how the player wants to play
    public static int StartDisplay()
    {
    System.out.println("================================");
    System.out.println("Welcome To the game Nim");
    System.out.println(" ") ;
    System.out.println("How would you like to play?");
    System.out.println("1 - Against another player");
    System.out.println("2 - Against a random computer");
    System.out.println("3 - Against a smart computer");
    System.out.println(" ");
    System.out.println("Enter 1, 2, or 3");
    System.out.println("================================");
    
    int decision;
    String stringDecision;
  
      stringDecision = JOptionPane.showInputDialog("Enter Game Mode");
     decision = Integer.parseInt(stringDecision);
    
     //Echo
     
     System.out.println("You entered "+ decision);
     if(decision == 1){
       System.out.println("You have choose player vs player");
       return decision;
     }
   
     if(decision == 2){
       System.out.println("You have choose player vs random computer");
       return decision;
     }
      if(decision == 3 ){
      System.out.println("You have choose player vs smart computer");
        return decision;
     }
      
       return 0;
    }
    
    





    //this will be player ones move for every game
    public static int PlayerOne(int coinStack)
    {
      String stringTake;
      int take,coin;     
      
   
      System.out.println("player one take 1 or 2 coins");
        
      stringTake = JOptionPane.showInputDialog("Player one do you want to take 1 or 2 coins");
     take = Integer.parseInt(stringTake);
      
     System.out.println("player one takes " + take + " coins");
    
     
    
     
     //this makes sure that the input was valid 
     if(take == 1){
        
       coinStack = coinStack - take;
      
        System.out.print("The table currently shows    ");
       
        for(coin = 0; coin < coinStack; coin++){
       System.out.print("x");
       
      
     }
     }
     
     else{
     
     if(take == 2){
    
        coinStack = coinStack - take;
       
       System.out.print("The table currently shows    ");
        
        for(coin = 0; coin < coinStack; coin++){
       System.out.print("x");
     }
     }
     
     
     else{
          System.out.println("Invalid input please try again");
          
          coinStack = PlayerOne(coinStack);
     }
     }
     
       return coinStack;
    } 
      
   
    




    //module for player two
     public static int PlayerTwo(int coinStack)
  {
      String stringTake;
      int take,coin;     
      
    System.out.println(" ");
      System.out.println("player Two take 1 or 2 coins");
        stringTake = JOptionPane.showInputDialog("Player Two do you want to take 1 or 2 coins");
     take = Integer.parseInt(stringTake);
      
     System.out.println("player Two takes " + take + " coins");
    
     
    
     
     //this makes sure that the input was valid 
     if(take == 1){
        
       coinStack = coinStack - take;
      
        System.out.print("The table currently shows    ");
       
        for(coin = 0; coin < coinStack; coin++){
       System.out.print("x");
       
      
     }
     }
     
     else{
     
     if(take == 2){
    
        coinStack = coinStack - take;
       
       System.out.print("The table currently shows    ");
        
        for(coin = 0; coin < coinStack; coin++){
       System.out.print("x");
     }
     }
     
     
     else{
          System.out.println("Invalid input please try again");
           coinStack = PlayerTwo(coinStack);
     }
     }
      
      return coinStack;
    } 
   
     


   

     public static int EasyComputer(int coinStack)
     {
     double random;
     int take,coin;
     random = Math.random();
     
     if(random>0.5){
       take = 1;
     }
       else{
       take = 2;
       }
     coinStack = coinStack - take;
      
      System.out.println(" ");
      System.out.println("The computer takes " + take + " coins");

       System.out.print("The table currently shows    ");
        
        for(coin = 0; coin < coinStack; coin++){
       System.out.print("x");
        }
      

     return coinStack;
     }
  
     
     
     
     
     
     public static int HardComputer(int coinStack)
     {
       int take,coin;
       
       
       
     
       if(coinStack == 1){
         take = 1;
       }
         else{
         
         if(coinStack == 2){
         take = 2;
         }
         else{
           if(coinStack % 2 == 0){
         take = 1;
        }
        else{
          take = 2;
        }
         }
         }
         
        coinStack = coinStack - take;
        
        System.out.println("The computer takes " + take + " coins");

       System.out.print("The table currently shows    ");
        
        for(coin = 0; coin < coinStack; coin++){
       System.out.print("x");
        }
        
        
        return coinStack;
     }
    
         
     





    //module for game mode person
    public static void Person()
    {
    
      int coinStack,coin;
      String stringCoinStack;
      
       stringCoinStack = JOptionPane.showInputDialog("How many coins are on the table");
     coinStack = Integer.parseInt(stringCoinStack);
     
     System.out.println("The coin stack has " + coinStack + " coins");
     
     System.out.print("The table currently shows    ");
      
      
        for(coin = 0; coin < coinStack; coin++){
       System.out.print("x");
        }
        System.out.println(" ");
        System.out.println("================================");
     
     while(coinStack > 0){
     
       
       
     coinStack = PlayerOne(coinStack);
      System.out.println(" ");
      System.out.print("================================");
     
     
     if(coinStack == 0){
       System.out.println(" ");
       System.out.println("Player one wins");
         coinStack = coinStack - 2;  
     }
      if(coinStack > 0){
      coinStack = PlayerTwo(coinStack);
      System.out.println(" ");
      System.out.print("================================");
      System.out.println(" ");
      }
      if(coinStack == 0){
        
        System.out.println("Player Two wins");
      }
     
       
       
     }
     
    }
   
    
    
    
    
    public static void  RandomComputer()
    {
     
        int coinStack,coin;
      String stringCoinStack;
      
       stringCoinStack = JOptionPane.showInputDialog("How many coins are on the table");
     coinStack = Integer.parseInt(stringCoinStack);
     
     System.out.println("The coin stack has " + coinStack + " coins");
     
     System.out.print("The table currently shows    ");
      
     
        for(coin = 0; coin < coinStack; coin++){
       System.out.print("x");
        }
        System.out.println(" ");
        System.out.println("================================");   
      
     while(coinStack > 0){
     
       
       
     coinStack = PlayerOne(coinStack);
      System.out.println(" ");
      System.out.print("================================");
     
     if(coinStack == 0){
       System.out.println(" "); 
       System.out.println("Player one wins");
         coinStack = coinStack - 2;  
     }
      if(coinStack > 0){
      coinStack = EasyComputer(coinStack);
      System.out.println(" ");
      System.out.print("================================");
      System.out.println(" ");
      }
      if(coinStack == 0){
        System.out.println("The computer wins");
      }
     
       
       
     }
     
    }
      
      
      
      
      
      
      
    
    public static void SmartComputer()
    {
       int coinStack,coin;
      String stringCoinStack;
      
       stringCoinStack = JOptionPane.showInputDialog("How many coins are on the table");
     coinStack = Integer.parseInt(stringCoinStack);
     
     System.out.println("The coin stack has " + coinStack + " coins");
     
      System.out.print("The table currently shows    ");
      
      
        for(coin = 0; coin < coinStack; coin++){
       System.out.print("x");
        }
        System.out.println(" ");
        System.out.println("================================"); 
   
     while(coinStack > 0){
     
       
       
     coinStack = PlayerOne(coinStack);
      System.out.println(" ");
      System.out.print("================================");
      System.out.println(" ");
     if(coinStack == 0){
        System.out.println("Player one wins");
         coinStack = coinStack - 2;  
     }
     if(coinStack > 0){
      coinStack = HardComputer(coinStack);
      System.out.println(" ");
      System.out.print("================================");
      System.out.println(" ");
     }
      if(coinStack == 0){
        System.out.println("The computer wins");
      }
     
       
       
     }
     
    }
      
      
  
    
    
   
    
    
    public static int GoAgain()
    {
     String sreplay;
     int replay;
     
     sreplay = JOptionPane.showInputDialog("Would you like to play another game?(0-no/1-yes)");
        replay = Integer.parseInt(sreplay);
     //echo
     System.out.println("Would you like to play another game?(0-no/1-yes)");
      System.out.println(replay);
     
     if(replay == 1){
        return replay;
     }
     if(replay == 0){
       System.out.println("Okay bye"); 
       return replay ; 
        
     }
     else{
       System.out.println("error please try again");
       replay = GoAgain();
     }
    return replay;
    }
 
    
    
    
    public static void DoIt()
    {
      int opponent,replay;
      
      
      
      replay = 1;
    
      while(replay == 1) {
      
        replay = 0;
        
     opponent = StartDisplay();
      
      if(opponent == 1){
        
       Person();  
      }
        
      if(opponent == 2){
        
      RandomComputer();
         
      }
        
      
      if(opponent == 3){
      
      SmartComputer();
      
      }
      
      if(opponent == 0){
        System.out.println("Invalid please retry");
        replay  = 1;
      }
      if(replay == 0){
      replay = GoAgain();
      }
      }  
    }
   
      
      
   
    public static void main(String args[])
    {
      DoIt();
  
    }
      }