
import javax.swing.JOptionPane;
public class driverProj{

  public static void main(String args[])throws  PostfixEvaluatorProj.SyntaxErrorException,InfixToPostfixParensProj.SyntaxErrorException {
  PostfixEvaluatorProj evaluator = new PostfixEvaluatorProj();
  InfixToPostfixParensProj check = new InfixToPostfixParensProj();
  
  
  String infix = JOptionPane.showInputDialog("Enter an infix expression");
  System.out.println("The infix you entered is : "+infix);
    
    String postfixparens = check.convert(infix);
    System.out.println("The postfix conversion is : "+postfixparens);
    
    int answer = evaluator.eval(postfixparens);
    System.out.println("The answer is : "+answer);
  
  System.exit(0);
}
}