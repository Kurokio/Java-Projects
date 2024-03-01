import java.util.*;
// translates an infix expression with parenthesis 
// to a postfix expression

public class InfixToPostfixParensProj{
   public static class SyntaxErrorException extends Exception{
    SyntaxErrorException(String message){
      super(message);
    }
  }
   //Df 
   // the op 
   private LinkedStack<Character> operatorStack;
   // the operator s
   private static final String OPERATORS = "+-*/()";
   // the precedence of ther operators, matches order of OPERATORS
   private static final int[] PRECEDENCE = {1,1,2,2,-1,-1};
   // the postfix string 
   private StringBuilder postfix;
   // convert a string from infix to postfix 
   public String convert(String infix)
     throws SyntaxErrorException{
     operatorStack = new LinkedStack<Character>();
     postfix = new StringBuilder();
     try{
       // process each token in the infix string 
       String nextToken;
       Scanner scan = new Scanner(infix);
       while ((nextToken = scan.findInLine("[\\p{L}\\p{N}]+|[-+/\\*()]"))!=null){
         char firstChar = nextToken.charAt(0);
         if(Character.isJavaIdentifierStart(firstChar) || Character.isDigit(firstChar)){
           postfix.append(nextToken);
           postfix.append(' ');
         }
         else if(isOperator(firstChar)){
           processOperator(firstChar);
         }
         else{
           throw new SyntaxErrorException
             ("Unexepected Character encountered:" +firstChar);
         }
       }// end loop
       // pop any remaining operators 
       // and append them to postfix 
       while(!operatorStack.empty()){
         char op = operatorStack.pop();
         // any ( on the stack is not matched 
         if (op == '(')
           throw new SyntaxErrorException("Unmatched opening parenthesis");
         postfix.append(op);
         postfix.append(' ');
       }
     // assert: Stack is empty, return result 
       return postfix.toString();
     }catch(EmptyStackException ex){
       throw new SyntaxErrorException("Syntax Error: The stack is empty");
     }
   }
   // method to process operators 
   private void processOperator(char op){
     if(operatorStack.empty() || op=='('){
       operatorStack.push(op);
     }else{
       // peek the operator stack and let topOp be the top operator 
       char topOp = operatorStack.peek();
       if(precedence(op)>precedence(topOp)){
         operatorStack.push(op);
       }
       else{
         // pop all stacked operators with equal or higher precednece than op 
         while(!operatorStack.empty() && precedence(op) <= precedence(topOp)){
           operatorStack.pop();
           if(topOp == '('){
             // matching ( popped - exit loop 
             break;
           }
           postfix.append(topOp);
           postfix.append(' ');
           if(!operatorStack.empty()){
             // reset topOp
             topOp = operatorStack.peek();
           }
         }
         // assert: operator stack is empty or current operator prece> top of stack operatpr precedence 
         if(op!=')')
           operatorStack.push(op);
       }
     }
   }
    private boolean isOperator(char ch){
    return OPERATORS.indexOf(ch) != -1;
  }
    private int precedence(char op){
    return PRECEDENCE[OPERATORS.indexOf(op)];
  }
}
    


