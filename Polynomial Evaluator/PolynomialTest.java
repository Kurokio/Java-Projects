import java.util.*;
import javax.swing.*;

public class PolynomialTest
{ 
  // inner class for term
  private static class Term
  {
    private int coef;
    private int exp;
    private Term next = null;
    private Term prev = null;
    
    // constructor 
    private Term(int coefficient, int exponent)
    {
      exp = exponent;
      coef = coefficient;
    }
  }
    
  // data fields
  // reference to head of list
  private Term head = null;
  // reference to end of list
  private Term tail = null;
  // size of list
  private int size = 0;
  
  /*addTerm
  public void addTerm(int coefficient, int exponent) {
    Term node = new Term(coefficient, exponent);
    if (size==0) {
      head = node;
    }
    else {
      tail.next = node;
    }
    tail = node;
    size++;
  } */
  
  // makePoly
  public void makePoly(int n) {
    int a, b;
    String str;
    //DLLZB p = new DLLZB();
    ZBListIter myiter = new ZBListIter(0);
    for(int i=0; i<n; i++) {
      str = JOptionPane.showInputDialog("Enter value for coefficient at index " +n);
      a = Integer.parseInt(str);
      str = JOptionPane.showInputDialog("Enter value for exponent at index " +n);
      b = Integer.parseInt(str);
      Term node = new Term(a, b);
      myiter.add(node);
     // myiter.nextExp();
      //myiter.set(node); needed?
    }
    //return p.head;
  }
      
  
  // printpoly
  public void printPoly(Term node) {
    String poly;
    for (Term i = node; i != null; i = node.next)
    {
      if(i.coef > 0 || i.coef < 0) {
        poly = i.coef + "x^" + i.exp;
      }
      else
        if(i.coef==0) {
        poly = i.coef + "";
      }
    }  
    System.out.println(poly);
  }
  
  // addpoly
  public void addPoly(Term poly1, Term poly2) {
    //Term pf; // head that points to list that holds result
    Term first = poly1;
    Term second = poly2;
    ZBListIter iter = new ZBListIter(0);
    Term sum;
    
    while(first != null && second != null) {
      if(first == null || first.exp < second.exp) {
        sum = new Term(second.coef, second.exp);
        second = second.next;
      }
      else 
        if(second == null || second.exp < first.exp) {
        sum = new Term(first.coef, first.exp);
        first = first.next;
      }
      else // if exponents are equal
        if(first.coef == 0 && second.coef == 0) {
        first = first.next;
        second = second.next;
      }
      else
        if(first.exp == 0 && second.exp == 0) {
        sum = new Term((first.coef + second.coef), 0);
        first = first.next;
        second = second.next;
      }
      else {
        int co = first.coef + second.coef;
        int ex = first.exp;
        sum = new Term(co, ex);
        first = first.next;
        second = second.next;
      }
      iter.add(sum);
      //iter.nextExp(); // dont need to return anything here so change next?
      //iter.set(sum);
    }
    //return pf;
  }
      
      
  
  // method to implement the listIterator
  public ListIterator listIterator(int index) {
    if(index < 0 || index > size) {
      throw new IndexOutOfBoundsException(Integer.toString(index));
    }
    ZBListIter theList = new ZBListIter(index);
    return theList;
  }
  
  // methods that implemement LinkedList
  
  // add
  public void add(int index, E obj) {
    listIterator(index).add(obj);
  }
  /*
  // getExp
  public int getCoef(int index) {
    return listIterator(index).nextCoef();
  }
  
  // getExp
  public int getExp(int index) {
    return listIterator(index).nextExp();
  }
  
  // other methods
  
  // getsize
    public int getSize() {
      return size;
    }
  
  // indexOf
  public int indexOf(E target) {
    ZBListIter iter = new ZBListIter(0);
    while(iter.hasNext()) {
        if (target.equals(iter.next())) {
          return iter.previousIndex();
        }
    }
        return -1;
  } */
  
  // inner class for ListIterator
  private class ZBListIter implements ListIterator {
    // reference to last item returned
    private Term lastItemReturned;
    // reference to next item
    private Term nextItem;
    // index of current item
    private int index = 0;
    
    // constructor
    public ZBListIter(int i) {
      // validate i parameter
      if (i < 0 || i > size) {
        throw new IndexOutOfBoundsException("Invalid index " + i);
      }
      lastItemReturned = null; // no item returned yet
      // last item
      if (i == size) {
        index = size;
        nextItem = null;
      } else { //start at beginning
              nextItem = head;
              for(index = 0; index < i; index++) {
                nextItem = nextItem.next;
              }
      }
    }
            
  // inner class methods
    
  // hasNext
    public boolean hasNext() {
      return nextItem != null;
    }
  
  // nextCoef
    public int nextCoef() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      lastItemReturned = nextItem;
      nextItem = nextItem.next;
      index++;
      return lastItemReturned.coef;
    }
    
  // nextExp
    public int nextExp() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      lastItemReturned = nextItem;
      nextItem = nextItem.next;
      index++;
      return lastItemReturned.exp;
    }
    
  // hasPrevious
    public boolean hasPrevious() {
      return (nextItem == null && size != 0) || nextItem.prev != null;
    }
    
  // previousCoef
    public int previousCoef() {
      if (!hasPrevious()) {
        throw new NoSuchElementException();
      }
      if (nextItem == null) { //Iterator is past the last element
        nextItem = tail;
      } else {
        nextItem = nextItem.prev;
      }
      lastItemReturned = nextItem;
      index--;
      return lastItemReturned.coef;
    }
    
  // previousExp
    public int previousExp() {
      if (!hasPrevious()) {
        throw new NoSuchElementException();
      }
      if (nextItem == null) { //Iterator is past the last element
        nextItem = tail;
      } else {
        nextItem = nextItem.prev;
      }
      lastItemReturned = nextItem;
      index--;
      return lastItemReturned.exp;
    }
    
  // add
    public void add(E obj) {
      if (head == null) { // Add to an empty list
        head = new Term(obj.coef, obj.exp);
        tail = head;
      } else
        if (nextItem == head) { // Insert at head
          // create a new node
          Term newNode = new Term(obj.coef, obj.exp);
          // link it to the next item
          newNode.next = nextItem;
          // link the next item to the new node
          nextItem.prev = newNode;
          // new node is now head
          head = newNode;
        } else
          if (nextItem == null) { // Insert at tail
            // create a new node
            Term newNode = new Term(obj.coef, obj.exp);
            // link tail to the new node
            tail.next = newNode;
            // link the new node to the tail
            newNode.prev = tail;
            // new node is now new tail
            tail = newNode;
          } else { // Insert into the middle
            // create a new node
            Term newNode = new Term(obj.coef, obj.exp);
            // link it to nextItem.prev
            newNode.prev = nextItem.prev;
            nextItem.prev.next = newNode;
            // link it to the nextItem
            newNode.next = nextItem;
            nextItem.prev = newNode;
          }
      // Increase size and index and set lastItemReturned
      size++;
      index++;
      lastItemReturned = null;
    } 
    
  // set
  public void set(E obj) {
    if (lastItemReturned == null) {
      throw new IllegalStateException();
    }
    lastItemReturned.coef = obj.coef;
    lastItemReturned.exp = obj.exp;
  }
  
  // nextIndex
  public int nextIndex() {
    if (nextItem == null) {
      return size;
    }
      return index;
  }
 
  // previousIndex
  public int previousIndex() {
    if (lastItemReturned == null) {
      return -1;
    }
      return index-1;
  }
  
  // remove
  public void remove() {
    if (lastItemReturned == null) {
      throw new IllegalStateException();
    }
    lastItemReturned.prev.next = lastItemReturned.next;
    lastItemReturned.next.prev = lastItemReturned.prev;
  }
  
  
  } // end of inner class
} // end of class