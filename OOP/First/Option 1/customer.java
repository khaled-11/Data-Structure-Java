public class customer
{
String customer_number;
String customer_name;
double previous_balance;
double balance_due;

public customer()
{
customer_number = "null";
customer_name = "null";
previous_balance = 0;
balance_due = 0;
}
public customer(String N_customer_number, String N_customer_name, double N_previous_balance, double N_balance_due)
{
customer_number = N_customer_number;
customer_name = N_customer_name;
previous_balance = N_previous_balance;
balance_due = N_balance_due;
}
public String get_customer_number()
{
return customer_number;
}

public String get_customer_name()
{
return customer_name;
}

public double get_previous_balance()
{
return previous_balance;
}

public double get_balance_due()
{
return balance_due;
}

public void set_customer_number(String N_customer_number)
{
customer_number = N_customer_number;
}

public void set_customer_name(String N_customer_name)
{
customer_name = N_customer_name;
}

public void set_previous_balance(double N_previous_balance)
{
previous_balance = N_previous_balance;
}

public void set_balance_due(double N_balance_due)
{
balance_due = N_balance_due;
}

}
