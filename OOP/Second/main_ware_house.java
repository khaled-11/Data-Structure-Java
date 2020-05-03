import java.io.*;
import java.util.*;

public class main_ware_house
{
    public static void main(String[] args) throws Exception
    {   
      // Decalring and Creating Data Containers.  
      String city , type ;
      double[] price = new double[3];
      ware_house[] Company = new ware_house [5];
      for (int i = 0 ; i < 5 ; i++)
      {
      Company[i] = new ware_house();  
      }
      Company[0].set_name("New_York");
      Company[1].set_name("L_Angeles");
      Company[2].set_name("Miami");
      Company[3].set_name("Houston");
      Company[4].set_name("Chicago");
      
      // Loading the File and read the prices.
      Scanner sc = new Scanner(new File("company_data.txt")); 
      for (int i = 0 ; i < 3 ; i++)
      {
      price[i] = sc.nextDouble();
      }
            
      // Reading the transaction type and the city name.
      // Then the program will call a method to read the rest of the transaction.
      while(sc.hasNext())
      {
        type = sc.next();
        city = sc.next();
        
        if (city.equals( "New_York"))
        {
          New(0, sc, Company, price, type);
        }
           
        else if (city.equals("L_Angeles"))
        {
          New(1, sc, Company, price, type);
        }
        
        else if (city.equals("Miami"))
        {
          New(2, sc, Company, price, type);
        }
                 
        else if (city.equals("Houston"))
        {
          New(3, sc, Company, price, type);
        }
                 
        else if (city.equals("Chicago"))
        {
          New(4, sc, Company, price, type);
        }}}
    
   
    
    // Method to read the rest of the tranasaction and update the records.
    
    public static void New(int l, Scanner sc, ware_house[] Company, double[] price, String type)
    {
      int a , b , c; double p = 0; double p1 = 0; double p2 = 0; double p3 = 0;
      
      if (type.equals("o"))
          {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            System.out.println("_____New Order Transaction______");
            System.out.println(Company[l].get_name() + "     " + a + "     " + b + "     " + c);
            
            if (Company[l].get_item_0() >= a)
            {
              p1 = a * price[0];  
            }
                        
            if (Company[l].get_item_0() < a)
            {
              int t = 0; int s = 0;  int q = (a - Company[l].get_item_0());
              for (int n = 0 ; n < 5 ; n++)
              {
                if (Company[n].get_item_0() >= t)
                {
                  t = Company[n].get_item_0();
                  s = n;
                }}
              if (t > q)
              {
                System.out.println();
                System.out.println( q + " of item 1 shipped from " + Company[s].get_name() + "\n" + " to " + Company[l].get_name());          
                System.out.println();
                p = 1.1*(q*price[0]);
                p1 = p + (Company[l].get_item_0()*price[0]);
                Company[s].set_item_0(-q);
                Company[l].set_item_0(q);
                System.out.printf("Item Cost = $%.2f" , p );
                System.out.println();
              }
            else
            {
              System.out.println();
              System.out.println("Order Unfilled");
              System.out.println("________________________________");
              System.out.println();
              return;
            }}
            
            if (Company[l].get_item_1() >= b)
            {
              p2 = b * price[1];  
            }
                        
            if (Company[l].get_item_1() < b)
            {
              int t = 0; int s = 0;  int q = (b - Company[l].get_item_1());
              for (int n = 0 ; n < 5 ; n++)
              {
                if (Company[n].get_item_1() >= t)
                {
                  t = Company[n].get_item_1();
                  s = n;
                }}
              if (t > q)
              {
                System.out.println();
                System.out.println( q + " of item 2 shipped from " + Company[s].get_name() + "\n" + " to " + Company[l].get_name());
                System.out.println();
                p = 1.1*(q*price[1]);
                p2 = p + (Company[l].get_item_1()*price[1]);
                Company[s].set_item_1(-q);
                Company[l].set_item_1(q);
                System.out.printf("Item Cost = $%.2f" , p );
                System.out.println();
              }
            else
            {
              System.out.println();
              System.out.println("Order Unfilled");
              System.out.println("________________________________");
              System.out.println();
              return;
            }}
            
            if (Company[l].get_item_2() >= c)
            {
              p3 = c * price[2];  
            }
                        
            if (Company[l].get_item_2() < c)
            {
              int t = 0; int s = 0;  int q = (c - Company[l].get_item_2());
              for (int n = 0 ; n < 5 ; n++)
              {
                if (Company[n].get_item_2() >= t)
                {
                  t = Company[n].get_item_2();
                  s = n;
                }}
              if (t > q)
              {
                System.out.println();
                System.out.println( q + " of item 3 shipped from " + Company[s].get_name() + "\n" + " to " + Company[l].get_name());
                System.out.println();
                p = 1.1*(q*price[2]);
                p3 = p + (Company[l].get_item_1()*price[1]);
                Company[s].set_item_2(-q);
                Company[l].set_item_2(q);
                p = 1.1*(q*price[2]);
                System.out.printf("Item Cost = $%.2f" , p );
                System.out.println();
              }
            else
            {
              System.out.println();
              System.out.println("Order Unfilled");
              System.out.println("________________________________");
              System.out.println();
              return;
            }}
                        
            Company[l].set_item_0(-a);
            Company[l].set_item_1(-b);
            Company[l].set_item_2(-c);
            System.out.printf("Total Cost = $%.2f" ,(p1 + p2 + p3));
            System.out.println();
            System.out.println("_________Updated Record_________");
            System.out.println(Company[l].get_name() + "     " + Company[l].get_item_0() + "     " + Company[l].get_item_1() + "     " + Company[l].get_item_2());
            System.out.println("________________________________"); 
            System.out.println();
            System.out.println();
          }
          else
          {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            System.out.println("____New Shipment Transaction____");
            System.out.println(Company[l].get_name() + "     " + a + "     " + b + "     " + c);
            Company[l].set_item_0(a);
            Company[l].set_item_1(b);
            Company[l].set_item_2(c);
            System.out.println("_________Updated Record_________");
            System.out.println(Company[l].get_name() + "     " + Company[l].get_item_0() + "     " + Company[l].get_item_1() + "     " + Company[l].get_item_2());
            System.out.println("________________________________");
            System.out.println();
            System.out.println();
          }}}
