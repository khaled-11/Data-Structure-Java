public class HeapSort 
{ 
  private int Swap;
  private int Compare;

  
  public HeapSort()
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
      
  public void sort(int arr[]) 
  { 
    int n = arr.length; 
  
    // Build heap (rearrange array) 
    for (int i = n / 2 - 1; i >= 0; i--) 
      heapify(arr, n, i); 
  
    // One by one extract an element from heap 
    for (int i=n-1; i>=0; i--) 
    { 
      // Move current root to end
      Swap++;
      int temp = arr[0]; 
      arr[0] = arr[i]; 
      arr[i] = temp; 
  
      // call max heapify on the reduced heap 
      heapify(arr, i, 0); 
    }} 
  
  // To heapify a subtree rooted with node i which is 
  // an index in arr[]. n is size of heap 
  void heapify(int arr[], int n, int i) 
  { 
    int largest = i; // Initialize largest as root 
    int l = 2*i + 1; // left = 2*i + 1 
    int r = 2*i + 2; // right = 2*i + 2 
    
    // If left child is larger than root
    Compare++;
    if (l < n && arr[l] > arr[largest]) 
      largest = l; 
  
    // If right child is larger than largest so far
    Compare++;
    if (r < n && arr[r] > arr[largest]) 
      largest = r; 
  
    // If largest is not root 
    Compare++;
    if (largest != i) 
    { 
      Swap++;
      int swap = arr[i]; 
      arr[i] = arr[largest]; 
      arr[largest] = swap; 
  
      // Recursively heapify the affected sub-tree 
      heapify(arr, n, largest); 
    }}}