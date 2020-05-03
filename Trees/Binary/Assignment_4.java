import java.util.*;
import java.io.*;

class Assignment_4
{
public static void main(String[] args) { 
BinarySortedTree tree = new BinarySortedTree();
int q = 000;
  
  do
  {
    System.out.println("");
    System.out.println("Please choose what you want to do from below (1 - 2 - 3 - 4).");
    System.out.println("1- Insert Records.");
    System.out.println("2- Print the Tree.");
    System.out.println("3- Delete Records.");
    System.out.println("4- Count the Nodes.");
    System.out.println("5- Count the Children of each Node.");
    System.out.println("6- Free the Tree.");
    Scanner sc = new Scanner(System.in);
    q = sc.nextInt();

    if (q == 1)
    {
      for (int i = 1 ; i < 100 ; i ++)
      {
        System.out.println("Please enter the Entery # " + i);
        int b = sc.nextInt();
        if (b == 999)
          break;
        tree.insert(b);
      }}
 
    else if (q == 2)
    {
      System.out.println("Pre_Order");
      tree.preorder();
      System.out.println();
      System.out.println("Post_Order");
      tree.postorder();
      System.out.println();
      System.out.println("In_Order");
      tree.inorder();
      System.out.println();
    }
  
    else if (q == 3)
    {
      System.out.println("Please Eneter the Vlaue to be Deleted.");
      System.out.println("** The Value will be replaced and voided, but the Node will stay in the tree **");
      int c = sc.nextInt();
      tree.Replace(c);
    }
    else if (q == 4)
    {
      System.out.println("The Tree Has Nodes = " + tree.countNodes());
    }
    else if (q == 5)
    {
      tree.printChildren();
    }
    else if (q == 6)
    {
      tree.freeTree();
        
      System.out.println("The Tree is Free Now!");
    }
  
  
  } while (q != 000);
}}
        
       