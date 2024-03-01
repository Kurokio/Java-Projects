import java.util.*;

public class SLLZB<E>
{ 
   // inner class for node
  private static class Node<E>
  {
    private E data;
    private Node<E> next;
    
    // constructor 1
    public Node(E d)
    {
      data = d;
      next = null;
    }
    
    // constructor 2
    public Node(E data, Node<E> next)
    {
      this.data = data;
      this.next = next;
    }
  }  // end of inner class node
  
  // data fields
  private Node<E> head = null;  // head pointing to list
  private int size = 0;
  // end of data fields
  
  // constructor
  // not needed
  // end of constructor
  
  
  // beginning of private methods
  // Helper Methods
  
  // addFirst
  private void addFirst(E item)
  {
    head = new Node<E>(item, head);
    size++;
  }
  
  // addAfter
  private void addAfter(Node<E> node, E item)
  {
    node.next = new Node<E>(item, node.next);
    size++;
  }
  
  // Remove the first node from the list
  // @returns The removed node's data or null if the list is empty
  private E removeFirst() {
    Node<E> temp = head;
    if (head != null) {
      head = head.next;
    }
    if (temp != null) {
      size--;
      return temp.data;
    } else {
      return null;
    }
  }
  
  // Remove the node after a given node
  // @returns The data from the removed node, or null 
  // if there is no node to remove
  private E removeAfter(Node<E> node) {
    Node<E> temp = node.next;
    if (temp != null) {
      node.next = temp.next;
      size--;
      return temp.data;
    } else {
      return null; 
    }
  }
  
  private Node<E> getNode(int index) {
    Node<E> node = head;
    for (int i = 0; i < index && node != null; i++) {
      node = node.next;
    }
    return node;
  }
  
  // end of private methods
  
  // beginning of Public Methods program to Table 2.5
  
  // get
  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(Integer.toString(index));
    }
    Node<E> node = getNode(index);
    return node.data;
  }
  
 // size
  public int size() {
    return size;
  }
  
 // add w two parameters
  public void add(int index, E item) {
    if (index < 0 || index > size) {
     throw new IndexOutOfBoundsException(Integer.toString(index));
    }
    if (index == 0) {
      addFirst(item);
    } else {
      Node<E> node = getNode(index-1);
      addAfter(node, item);
    }
  }
  
 // remove
  public E remove(int index) {
    if (index < 0 || index > size) {
     throw new IndexOutOfBoundsException(Integer.toString(index));
    }
    if (index == 0) {
      return removeFirst();
    } else {
      Node<E> node = getNode(index-1);
      return removeAfter(node);
    }
  }
  
 // end of Public Methods program to Table 2.5
} // end of class