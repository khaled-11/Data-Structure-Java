import java.io.*;
import java.util.*;

public class Accounts_Recievable_2
  {
    public static void main(String[] args) throws Exception
    {   
      
      // Loading the master file, and declaring Variables.
      Scanner sc = new Scanner(new File("master_file.txt"));
      String Temp = "null";
      String C_Number;
      String T_Number; 
      String Type;
      double amount;
      String C_Name = "Null";
      double P_Balance = 0;
      String transaction_type = "null";
      int quantity;
      double order_amount;
      double net_balance= 0;
      double total_balance = 0;
      double final_balance = 0;
      String [] M_Error = new String [100];
      int x = 0;

       // Reading Records from the Master File One at a time.
          while(sc.hasNext()) 
          {      
            C_Number = sc.next();
            if (Temp.equals(C_Number))
            {
              System.out.println("Error - Customer Number  # "+ C_Number + " is repeated, but voided.");
              System.out.println("________________________________________________________");
              sc.next();
              sc.nextDouble(); 
              if (sc.hasNext())
              {
              C_Number = sc.next();
              C_Name = sc.next();
              P_Balance = (sc.nextDouble()); 
              }
              else
              {
                break;
              }}
           else
           {
              C_Name = sc.next();
              P_Balance = (sc.nextDouble()); 
           }
            Temp = C_Number;
            M_Error [x] = C_Number;
            x++;
            System.out.println(C_Name + "              " + C_Number);
            System.out.println();
            System.out.println("                       Previous Balance          $" + P_Balance);
            System.out.println();
            
            // Reading Records from the transaction file, and update the master record.
            Scanner sd = new Scanner(new File("transaction_file.txt"));
            while(sd.hasNext())
            {
            String t = sd.next();
            
            // Check if it belongs to the same master record, and update.
            if (C_Number.equals(t))
            {
            transaction_type = sd.next();
            if (transaction_type.equals("P"))
            {
            T_Number = sd.next();
            amount = -sd.nextDouble();
            System.out.println(T_Number + "              " + "PAYMENT"+ "              $" + amount);
            total_balance += amount;
            }
            if (transaction_type.equals("O"))
            {
            T_Number = sd.next();
            Type = (sd.next());
            quantity = sd.nextInt();
            order_amount = sd.nextDouble();
            net_balance = (quantity * order_amount); 
            System.out.println(T_Number + "              " + Type + "              $" + net_balance);
            total_balance += net_balance;
            }}}  
            System.out.println();
            System.out.println("                          Total Balance         $" + (total_balance+P_Balance));
            System.out.println("________________________________________________________");
            
            final_balance += total_balance+P_Balance;
            total_balance = 0; 
          }
          System.out.println("_______________Total Balance  = $" +final_balance + "_______________");
          System.out.println("________________________________________________________");
          
          // Catch Transaction without master record.
          List<String> list = Arrays.asList(M_Error);
          Scanner sd = new Scanner(new File("transaction_file.txt"));
          System.out.println();
          System.out.println("_______Transactions Found without Master record_________");
          System.out.println("________________________________________________________");
          while(sd.hasNext())
          {
            String k = sd.next();
            if (list.contains(k))
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
                System.out.println("The Transaction Number #" + sd.next() + " ,and the client number is: " + k);
                sd.nextDouble();
              }
              if (transaction_type.equals("O"))
              {
                System.out.println("Transaction Number #" + sd.next() + " ,and the client number is: " + k);
                sd.next();   sd.nextInt();   sd.nextDouble();
                System.out.println("________________________________________________________");
              }}}
            System.out.println("_________________________END____________________________");}}
