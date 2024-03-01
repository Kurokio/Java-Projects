import java.util.*;
import javax.swing.JOptionPane;
import java.util.Scanner;

// class that can evaluate aa postfix expression 
public class PostfixEvaluatorProj{
  // nested class 
  // class to report a syntax error 3.6
  public static class SyntaxErrorException extends Exception{
    SyntaxErrorException(String message){
      super(message);
    }
  }
  // constant 
  // list of op 
  private static final String OPERATORS = "+-*/()";
  //DF 
  // the op stack
  private LinkedStack<Integer> operandStack;
  // methods
  // Evauluats the current op
  //this function pops the to op off the op 
  // stack and appllies the op 
  private int evalOp(char op){
    // pop he two op off the stack 
    int rhs = operandStack.pop();
    int lhs = operandStack.pop();
    int result = 0;
    // eva the op 
    switch (op){
      case '+' : result = lhs + rhs;
      break;
      case '-': result = lhs - rhs;
      break;
      case'/': result = lhs/rhs;
      break;
      case'*': result = lhs *rhs;
      break;
    }
    return result;
  }
  private boolean isOperator(char ch){
    return OPERATORS.indexOf(ch) != -1;
  }
  public static int parse(String s){
    if (s.equals("")) {
      return 0;
    }
    int other = s.charAt(s.length()-1)-'0';
    String whatever = s.substring(0,s.length()-1);
    return other + (parse(whatever)*10);
  }
  // use this one for driver class 
  public int eval(String expression) throws SyntaxErrorException{
    // create an empty stack 
    operandStack = new LinkedStack<Integer>();
    // process each token 
    String[] tokens = expression.split("\\s+");
    try{
      for (String nextToken : tokens){
        char firstChar = nextToken.charAt(0);
        if(Character.isDigit(firstChar)){
          // get the interger value 
          int value = parse(nextToken);
          // push value onto op staack 
          operandStack.push(value);
        } // is it an op?
        else if(isOperator(firstChar)){
          // eval the operator 
          int result = evalOp(firstChar);
          // push result onto the operand stack 
          operandStack.push(result);
        }
        else{
          // invalid character 
          throw new SyntaxErrorException("invalid character encountered: "+ firstChar);
        }
      }// end for 
      // no more tokens - popresult from op stack 
      int anwser = operandStack.pop();
      // opernd stack should be empty 
      if(operandStack.empty()){
        return anwser;
      }else{
        // indicate syntax error 
        throw new SyntaxErrorException("Syntax Error: Stack should be empty");
      }
    }catch (EmptyStackException ex){
      // pop was attemtped on an empty stack.
      throw new SyntaxErrorException("Syntax Error: the stack is empty");
    }
  }

}
