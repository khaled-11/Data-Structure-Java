public class ware_house
{
  
private int[] item = new int[3];
private String name;

public ware_house()
{
item [0] = 0;
item [1] = 0;
item [2] = 0;
}

public ware_house(int a, int b, int c)
{
item [0] = a;
item [1] = b;
item [2] = c;
}

public String get_name()
{
return name;
}

public int get_item_0()
{
return item[0];
}

public int get_item_1()
{
return item[1];
}

public int get_item_2()
{
return item[2];
}

public void set_item_0(int a)
{
item[0] += a;
}

public void set_item_1(int a)
{
item[1] += a;
}

public void set_item_2(int a)
{
item[2] += a;
}

public void set_name(String n)
{
name = n;
}

}