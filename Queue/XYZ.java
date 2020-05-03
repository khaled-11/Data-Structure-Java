import java.util.*;
import java.io.*;

public class XYZ
  {
    public static void main(String[] args) throws Exception
    {  
      int discount = 0;
      int counter = 0;
      Queue <Integer> q = new LinkedQueue<Integer>();
      Scanner sc = new Scanner(new File("RSP-Data.txt"));
      
      while(sc.hasNext())
      {
        String type = sc.next();
        if (type.equals( "R"))
        {
          int a = sc.nextInt();
          double b = sc.nextDouble();
          q.insert(a , b);
          System.out.println("_________Widgets Recieved_________");
          System.out.println();
          System.out.println("# " + a + " Widgets  @  $" + b);
          System.out.println("__________________________________");
        }
        
        if (type.equals( "S"))
        {
          int order = sc.nextInt();
          int remain = order;
          double total = 0;
          System.out.println("______________SALES_______________");
          System.out.println();
          System.out.printf("      %d ((Widgets sold)" , order);
          while (remain > 0)
          {
            int u = q.get_quantity();
            if (u < remain)
            { 
              System.out.printf("\n%d @ $%.2f each    Sales: $%.2f" , u, (q.get_price()*1.3) , ((q.get_price()*1.3)* u));
              total += ((q.get_price()*1.3)*u);
              q.delete();;
              remain -= u;
            }
            else
            {
              System.out.printf("\n%d @ $%.2f each    Sales: $%.2f \n" , remain, (q.get_price()*1.3) , ((q.get_price()*1.3)* remain));
              total += ((q.get_price()*1.3)*remain);
              int y = u - remain;
              remain -= u; 
              q.adjust(y);
              if (q.get_quantity() == 0)
              {
                q.delete();;
              }
            }
            if (q.size() == 0)
            {
              System.out.printf("\nRemainder %d Widgets not available \n" , remain);
              break;
            }}
          System.out.printf("      Total Sales $%.2f \n", total);
          if (counter != 0)
          {
            System.out.println("****** DISCOUNT APPLIED %" + discount + " ******");
            System.out.printf("      Total Sales $%.2f \n", (total*(100-discount)/100));
            counter--;
          }
          System.out.println("__________________________________");
        }         
        
        if (type.equals( "P"))
        {
          discount = sc.nextInt();
          counter = 2;
          System.out.println("____________PROMOTION_____________");
          System.out.println();
          System.out.println("%" + discount + " Discount for the next 2 sales.");
          System.out.println("__________________________________");
        }}           
  
        System.out.println("________Widgets still left________");
        for (Integer i : q)
        {
        }
        System.out.println("__________________________________");
        System.out.println("__________________________________");}}