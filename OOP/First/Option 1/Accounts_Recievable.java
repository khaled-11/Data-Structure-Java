import java.io.*;
import java.util.*;

public class Accounts_Recievable
  {
    public static void main(String[] args) throws Exception
    {   
      // Loading the maaster file, and declaring Variables.
      Scanner sc = new Scanner(new File("master_file.txt"));      
      String transaction_type;
      int quantity; boolean check = true;
      double order_amount;
      double net_balance= 0;
      double total_balance = 0;
      int x = 0;     int z = 0;
      int p = 0;     int u = 0;
      String [] M_Error = new String [100];
      customer[] N_customer = new customer [100];
      transaction[] N_transaction = new transaction [100];

       // Reading Records from the Master File One at a time.
          while(sc.hasNext()) 
          {
            N_customer[x] = new customer();      
            N_customer[x].set_customer_number(sc.next());
            N_customer[x].set_customer_name(sc.next());
            N_customer[x].set_previous_balance(sc.nextDouble());    
            for (int n = 0 ; n < x ; n++ )
            {
              if (N_customer[x].get_customer_number().equals(N_customer[n].get_customer_number()))
              {
              M_Error[p] = ("Error - Customer Number  # "+ N_customer[x].get_customer_number() + " is repeated, but voided.");
              p++;  
              if (sc.hasNext())
              {
                N_customer[x].set_customer_number(sc.next());
                N_customer[x].set_customer_name(sc.next());
                N_customer[x].set_previous_balance(sc.nextDouble());  
              }
              else
              {
                check = false;
                x--;
              }}}
               
            // Reading Records from the transaction File and updating the Master Records.
            
            Scanner sd = new Scanner(new File("transaction_file.txt"));
            if (check == true)
            {
            while(sd.hasNext())
            {
            String temp = sd.next();
            
            // Check if it belongs to the same master record, and update.
            
            if (N_customer[x].get_customer_number().equals(temp))
            {
            transaction_type = sd.next();
            if (transaction_type.equals("P"))
            {
            N_transaction[z] = new transaction();           
            N_transaction[z].set_customer_number(temp);
            N_transaction[z].set_transaction_number(sd.next());
            N_transaction[z].set_amount(-sd.nextDouble());
            N_transaction[z].set_transaction_type("PAYMENT");
            z++;
            }
            if (transaction_type.equals("O"))
            {
            N_transaction[z] = new transaction();
            N_transaction[z].set_customer_number(temp);
            N_transaction[z].set_transaction_number(sd.next());
            N_transaction[z].set_transaction_type(sd.next());
            quantity = sd.nextInt();
            order_amount = sd.nextDouble();
            N_transaction[z].set_amount(quantity * order_amount); 
            z++;
            }}     
            // Keeping the same reading sequence if it does not belong to the same record. 
            else
            {
            transaction_type = sd.next();
            if (transaction_type.equals("P"))
            {
              sd.next();    sd.nextDouble();
            }
            if (transaction_type.equals("O"))
            {
              sd.next();      sd.next();
              sd.nextInt();  sd.nextDouble();
            }}}}x++;}
            
            
      
     
            // Catching transactions without master record.

            String [] Name = new String [x+1];
            String [] Error = new String [100];
            int count = 0;
            
            for (int t = 0 ; t < x ; t++)
            {
              Name[t] = N_customer[t].get_customer_number();
            }    
            List<String> list = Arrays.asList(Name);
            Scanner sd = new Scanner(new File("transaction_file.txt"));
            while(sd.hasNext())
            {
            String temp = sd.next();
            if (list.contains(temp))
                  {
            transaction_type = sd.next();
            if (transaction_type.equals("P"))
            {
              sd.next();     sd.nextDouble();
            }
            if (transaction_type.equals("O"))
            {
              sd.next();      sd.next();
              sd.nextInt();   sd.nextDouble();
            }}
                else
                  {
                   transaction_type = sd.next();
                   if (transaction_type.equals("P"))
                   {
                   String Num = sd.next();    sd.nextDouble();
                   Error[count] = ( "The Transaction Number # " + Num + " ,and the client name is: " + temp );
                   count++;
                   }
                   if (transaction_type.equals("O"))
                   {
                   String Num = sd.next();
                   sd.next();    sd.nextInt();
                   sd.nextDouble();
                   Error[count] = ( "Error - Transaction Number # " + Num + "  Customer number: " + temp);
                   count++;
                   }}}
              
          // Preparing and Printing balances and invoices..
            
          for (int q = 0; q < x ; q++)
          {
            double b_due = 0;
            
            System.out.println(N_customer[q].get_customer_name() + "              " + N_customer[q].get_customer_number());
            System.out.println("                       Previous Balance          $" + N_customer[q].get_previous_balance());
            System.out.println();
            for (int y = 0; y < z ; y++)
            {
              if (N_transaction[y].get_customer_number().equals(N_customer[q].get_customer_number()))
                    {
                System.out.println(N_transaction[y].get_transaction_number() + "              " + N_transaction[y].get_transaction_type()+ "              $" + N_transaction[y].get_amount());
                b_due += N_transaction[y].get_amount();
              }} 
            N_customer[q].set_balance_due(b_due);
            net_balance = N_customer[q].get_previous_balance() + b_due;
            System.out.println();
            System.out.println("                       Balance Due               $" + net_balance );
            System.out.println("________________________________________________________");  
            total_balance += net_balance;
          }
            System.out.println("________________________________________________________");  
            System.out.println("________________________________________________________");  
            System.out.println("         Total Balance Due   =   $" + total_balance); 
            System.out.println("________________________________________________________");  
            System.out.println("________________________________________________________"); 
            System.out.println("_______Transactions Found without Master record_________");
            System.out.println("________________________________________________________");
            for (int o = 0; o < count ; o++)
            {
              System.out.println(Error[o]);
            }
            System.out.println("________________________________________________________");
            System.out.println("________________________________________________________");
            System.out.println("_______________Duplicate Master record__________________");
            System.out.println("________________________________________________________");
            for (int o = 0; o < p ; o++)
            {
              System.out.println(M_Error[o]);
            }
            System.out.println("________________________________________________________");
    }}