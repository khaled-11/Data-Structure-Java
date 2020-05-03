public interface Queue <Item> extends Iterable <Item>
{
  int delete();
  void insert(int item, double item2);
  void adjust(int q);
  int get_quantity();
  double get_price();
  boolean isEmpty();
  int size();
}