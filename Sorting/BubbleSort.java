class BubbleSort 
{ 
  private int Swap;
  private int Compare;
  
  public BubbleSort()
  { 
    Swap = 0;
    Compare = 0;
  }
  
  int get_Swap()
  {
    return Swap;
  }
  int get_Compare()
  {
    return Compare;
  }
  
  void bubbleSort(int arr[]) 
  { 
    int n = arr.length; 
    for (int i = 0; i < n-1; i++) 
      for (int j = 0; j < n-i-1; j++) 
    {
      Compare++;
      if (arr[j] > arr[j+1]) 
    { 
      // swap arr[j+1] and arr[i] 
      Swap++;
      int temp = arr[j]; 
      arr[j] = arr[j+1]; 
      arr[j+1] = temp; 
      }}}}