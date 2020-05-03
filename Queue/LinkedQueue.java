import java.lang.Iterable;
import java.util.*;
 
class LinkedQueue <Item> implements Queue <Item>
{
  private Node front, rear;
  private int size;
 
  private class Node
  { 

    int item;
    double item2;
    Node next;
  }
 
  public LinkedQueue()
  {
    front = null;
    rear = null;
    size = 0;
  }
  
  public boolean isEmpty()
  {
    return (size == 0);
  }
  
  public int delete()
  {
    int item = front.item;
    front = front.next;
    if (isEmpty()) 
    {
      rear = null;
    }
    size--;
    return item;
  }
  
  
  public int get_quantity()
  {
    if (isEmpty()) throw new NoSuchElementException("Queue underflow");
    return front.item;
  }
  
  public double get_price() 
  {     
    if (isEmpty()) throw new NoSuchElementException("Queue underflow");
    return front.item2;
  }     
  
  public void insert(int item, double item2)
  {
    Node oldRear = rear;
    rear = new Node();
    rear.item = item;
    rear.item2 = item2;
    rear.next = null;
    if (isEmpty())
    {
      front = rear;
    }
    else
    {
      oldRear.next = rear;
    }
    size++;
  }

  public void adjust(int q)
  {
    front.item = q ; 
  }
  
  public int size()
  {
    return size;
  }

  public Iterator<Item> iterator()
  {
    return new LinkedQueueIterator();
  }
  
  private class LinkedQueueIterator implements Iterator <Item>
  {
    private int i = size;
    private Node first = front;
 
    public boolean hasNext()
    {
      return (i > 0);
    }
 
    public Item next()
    {
     int item = first.item;
      double item2 = first.item2;
      first = first.next;
      i--;
      System.out.println(item + " Widgets left @ $" + item2);
      return null;
    }}}