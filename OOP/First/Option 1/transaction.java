public class transaction
{
String customer_number;
String transaction_number;
String transaction_type;
double amount;

public transaction()
{
customer_number = "null";
transaction_number = "null";
transaction_type = "null";
amount = 0;
}
public transaction(String N_customer_number, String N_transaction_number, String N_transaction_type, double N_amount)
{
customer_number = N_customer_number;
transaction_number = N_transaction_number;
transaction_type = N_transaction_type;
amount = N_amount;
}

public String get_customer_number()
{
return customer_number;
}

public String get_transaction_number()
{
return transaction_number;
}

public String get_transaction_type()
{
return transaction_type;
}

public double get_amount()
{
return amount;
}

public void set_customer_number(String N_customer_number)
{
customer_number = N_customer_number;
}

public void set_transaction_number(String N_transaction_number)
{
transaction_number = N_transaction_number;
}

public void set_transaction_type(String N_transaction_type)
{
transaction_type = N_transaction_type;
}

public void set_amount(double N_amount)
{
amount = N_amount;
}
}
