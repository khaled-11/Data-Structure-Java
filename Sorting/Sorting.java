import java.util.*;
import java.util.*;
import java.io.*;
import javax.swing.*;

class Sorting
{
  int compare = 0; int swap = 0;
  public static void main(String[] args)
  { 
    // Saving Files NAmes as parameters.
    String A = "10_Sorted.txt"; String B = "10_Reverse.txt"; String C = "10_Random.txt";
    String D = "50_Sorted.txt"; String E = "50_Reverse.txt"; String F = "50_Random.txt";
    String G = "100_Sorted.txt"; String H = "100_Reverse.txt"; String I = "100_Random.txt";
    
    // Reading Files and sending to Methods to read Data and sort.
    Scanner sc = new Scanner(new File(A));
    String R = sc.nextLine();
    System.out.println("The Original Array");
    System.out.println(R);  
    int Arr[] = new int[10];
    Read(sc, Arr);
    threeSort(Arr,sc,A);
    
    sc = new Scanner(new File(B));
    R = sc.nextLine();
    System.out.println("The Original Array");
    System.out.println(R);  
    int Arr2[] = new int[10];
    Read(sc, Arr2);
    threeSort(Arr2,sc,B);
    
    sc = new Scanner(new File(C));
    R = sc.nextLine();
    System.out.println("The Original Array");
    System.out.println(R);  
    int Arr3[] = new int[10];
    Read(sc, Arr3);
    threeSort(Arr3,sc,C);
    
    // 50 Records.
    sc = new Scanner(new File(D));
    R = sc.nextLine();
    System.out.println("The Original Array");
    System.out.println(R);  
    int Arr4[] = new int[50];
    Read(sc, Arr4);
    threeSort(Arr4,sc,D);
    
    sc = new Scanner(new File(E));
    R = sc.nextLine();
    System.out.println("The Original Array");
    System.out.println(R);  
    int Arr5[] = new int[50];
    Read(sc, Arr5);
    threeSort(Arr5,sc,E);
    
    sc = new Scanner(new File(F));
    R = sc.nextLine();
    System.out.println("The Original Array");
    System.out.println(R);  
    int Arr6[] = new int[50];
    Read(sc, Arr6);
    threeSort(Arr6,sc,F);
    
    // 100 Records.
    sc = new Scanner(new File(G));
    R = sc.nextLine();
    System.out.println("The Original Array");
    System.out.println(R);  
    int Arr7[] = new int[100];
    Read(sc, Arr7);
    threeSort(Arr7,sc,G);
    
    sc = new Scanner(new File(H));
    R = sc.nextLine();
    System.out.println("The Original Array");
    System.out.println(R);  
    int Arr8[] = new int[100];
    Read(sc, Arr8);
    threeSort(Arr8,sc,H);
    
    sc = new Scanner(new File(I));
    R = sc.nextLine();
    System.out.println("The Original Array");
    System.out.println(R);  
    int Arr9[] = new int[100];
    Read(sc, Arr9);
    threeSort(Arr9,sc,I);
  }
       
    // Method to read the data from file.
    public static void Read(Scanner sc, int arr[])
    {
      int i = 0;
      while (sc.hasNext())
      {
        arr[i] = sc.nextInt();
        System.out.print(arr[i] + " ");
        i++;
      } 
      System.out.println();
    }
      
    // Method to call the three sorts.
     public static void threeSort(int Arr[],Scanner sc, String X) throws Exception
     {   
       String N;
       Sort Q = new Sort();
       Q.sort(Arr, 0, Arr.length-1);  
       System.out.println("The Sorted Array with quick sort");
       for (int p=0; p < Arr.length; ++p) 
         System.out.print(Arr[p]+" "); 
       System.out.println();  
       System.out.println( "Number of comparison = " + Q.get_Compare() + ".  Number of Swaps = " + Q.get_Swap());
       // Second Sort. 
       System.out.println(); 
       sc = new Scanner(new File(X));
       N = sc.nextLine();
       System.out.println("The Original Array");
       System.out.println(N);
       Read(sc, Arr);  
       HeapSort H = new HeapSort();
       H.sort(Arr);  
       System.out.println("The Sorted Array with heap sort");
       for (int p=0; p < Arr.length; ++p) 
         System.out.print(Arr[p]+" "); 
       System.out.println();  
       System.out.println( "Number of comparison = " + H.get_Compare() + ".  Number of Swaps = " + H.get_Swap());
       // Third Sort.
       System.out.println(); 
       sc = new Scanner(new File(X));
       N = sc.nextLine();
       System.out.println("The Original Array");
       System.out.println(N);
       Read(sc, Arr);  
       BubbleSort B = new BubbleSort();
       B.bubbleSort(Arr);  
       System.out.println("The Sorted Array with bubble sort");
       for (int p=0; p < Arr.length; ++p) 
         System.out.print(Arr[p]+" "); 
       System.out.println();  
       System.out.println( "Number of comparison = " + B.get_Compare() + ".  Number of Swaps = " + B.get_Swap());
       System.out.println("__________________________________________________"); 
       Compare(Q, H, B);
       System.out.println("__________________________________________________"); 
       System.out.println(); 
     }
     
     // Method to compare the sorts.
     public static void Compare(Sort Q, HeapSort H, BubbleSort B)
     {
       // Comparing Comparisons.
       if (Q.get_Compare() < H.get_Compare() && H.get_Compare() < B.get_Compare())
       {
         System.out.println("The Quick Sort made the least comparisons = " + Q.get_Compare());
         System.out.println("The Bubble Sort made the most comparisons = " + B.get_Compare());
         System.out.println("The Heap Sort made the middle comparisons = " + H.get_Compare());
       }
       else if (Q.get_Compare() < B.get_Compare() && B.get_Compare() < H.get_Compare())
       {
         System.out.println("The Quick Sort made the least comparisons = " + Q.get_Compare());
         System.out.println("The Heap Sort made the most comparisons = " + H.get_Compare());
         System.out.println("The Bubble Sort made the middle comparisons = " + B.get_Compare());
       }
       else if (H.get_Compare() < B.get_Compare() && B.get_Compare() < Q.get_Compare())
       {
         System.out.println("The Heap Sort made the least comparisons = " + H.get_Compare());
         System.out.println("The Quick Sort made the most comparisons = " + Q.get_Compare());
         System.out.println("The Bubble Sort made the middle comparisons = " + B.get_Compare());
       }
       else if (H.get_Compare() < Q.get_Compare() && Q.get_Compare() < B.get_Compare())
       {
         System.out.println("The Heap Sort made the least comparisons = " + H.get_Compare());
         System.out.println("The Bubble Sort made the most comparisons = " + B.get_Compare());
         System.out.println("The Quick Sort made the middle comparisons = " + Q.get_Compare());
       }
       else if (B.get_Compare() < Q.get_Compare() && Q.get_Compare() < H.get_Compare())
       {
         System.out.println("The Bubble Sort made the least comparisons = " + B.get_Compare());
         System.out.println("The Heap Sort made the most comparisons = " + H.get_Compare());
         System.out.println("The Quick Sort made the middle comparisons = " + Q.get_Compare());
       }
       else if (B.get_Compare() < H.get_Compare() && H.get_Compare() < Q.get_Compare())
       {
         System.out.println("The Bubble Sort made the least comparisons = " + B.get_Compare());
         System.out.println("The Quick Sort made the most comparisons = " + Q.get_Compare());
         System.out.println("The Heap Sort made the middle comparisons = " + H.get_Compare());
       }
       else if (B.get_Compare() == H.get_Compare() && H.get_Compare() < Q.get_Compare())
       {
         System.out.println("The Bubble Sort made the same Compares as Heap Sort " + B.get_Compare());
         System.out.println("The Quick Sort made the most Compares = " + Q.get_Swap());
       }
       else if (B.get_Compare() == H.get_Compare() && H.get_Compare() > Q.get_Compare())
       {
         System.out.println("The Bubble Sort made the same Compares as Heap Sort " + B.get_Compare());
         System.out.println("The Quick Sort made the least Compares = " + Q.get_Compare());
       }
       else if (B.get_Compare() == Q.get_Compare() && Q.get_Compare() < H.get_Compare())
       {
         System.out.println("The Bubble Sort made the same Compares as Quick Sort " + B.get_Compare());
         System.out.println("The Heap Sort made the most Compares = " + H.get_Compare());
       }
       else if (B.get_Compare() == Q.get_Compare() && Q.get_Compare() > H.get_Compare())
       {
         System.out.println("The Bubble Sort made the same Compares as Quick Sort " + B.get_Compare());
         System.out.println("The Heap Sort made the least Compares = " + H.get_Compare());
       }
       else if (H.get_Compare() == Q.get_Compare() && Q.get_Compare() < B.get_Compare())
       {
         System.out.println("The Heap Sort made the same Compares as Quick Sort " + B.get_Compare());
         System.out.println("The Bubble Sort made the most Compares = " + B.get_Compare());
       }
       else if (H.get_Compare() == Q.get_Compare() && Q.get_Compare() > B.get_Compare())
       {
         System.out.println("The Heap Sort made the same Compares as Quick Sort " + B.get_Compare());
         System.out.println("The Bubble Sort made the least Compares = " + B.get_Compare());
       }
          System.out.println("__________________________________________________");
       
       // Comparing Swaps.
       if (Q.get_Swap() < H.get_Swap() && H.get_Swap() < B.get_Swap())
       {
         System.out.println("The Quick Sort made the least Swaps = " + Q.get_Swap());
         System.out.println("The Bubble Sort made the most Swaps = " + B.get_Swap());
         System.out.println("The Heap Sort made the middle Swaps = " + H.get_Swap());
       }
       else if (Q.get_Swap() < B.get_Swap() && B.get_Swap() < H.get_Swap())
       {
         System.out.println("The Quick Sort made the least Swaps = " + Q.get_Swap());
         System.out.println("The Heap Sort made the most Swaps = " + H.get_Swap());
         System.out.println("The Bubble Sort made the middle Swaps = " + B.get_Swap());
       }
       else if (H.get_Swap() < B.get_Swap() && B.get_Swap() < Q.get_Swap())
       {
         System.out.println("The Heap Sort made the least Swaps = " + H.get_Swap());
         System.out.println("The Quick Sort made the most Swaps = " + Q.get_Swap());
         System.out.println("The Bubble Sort made the middle Swaps = " + B.get_Swap());
       }
       else if (H.get_Swap() < Q.get_Swap() && Q.get_Swap() < B.get_Swap())
       {
         System.out.println("The Heap Sort made the least Swaps = " + H.get_Swap());
         System.out.println("The Bubble Sort made the most Swaps = " + B.get_Swap());
         System.out.println("The Quick Sort made the middle Swaps = " + Q.get_Swap());
       }
       else if (B.get_Swap() < Q.get_Swap() && Q.get_Swap() < H.get_Swap())
       {
         System.out.println("The Bubble Sort made the least Swap = " + B.get_Swap());
         System.out.println("The Heap Sort made the most Swaps = " + H.get_Swap());
         System.out.println("The Quick Sort made the middle Swaps = " + Q.get_Swap());
       }
       else if (B.get_Swap() < H.get_Swap() && H.get_Swap() < Q.get_Swap())
       {
         System.out.println("The Bubble Sort made the least Swaps = " + B.get_Swap());
         System.out.println("The Quick Sort made the most Swaps = " + Q.get_Swap());
         System.out.println("The Heap Sort made the middle Swaps = " + H.get_Swap());
       }  
       else if (B.get_Swap() == H.get_Swap() && H.get_Swap() < Q.get_Swap())
       {
         System.out.println("The Bubble Sort made the same Swaps as Heap Sort " + B.get_Swap());
         System.out.println("The Quick Sort made the most Swaps = " + Q.get_Swap());
       }
       else if (B.get_Swap() == H.get_Swap() && H.get_Swap() > Q.get_Swap())
       {
         System.out.println("The Bubble Sort made the same Swaps as Heap Sort " + B.get_Swap());
         System.out.println("The Quick Sort made the least Swaps = " + Q.get_Swap());
       }
       else if (B.get_Swap() == Q.get_Swap() && Q.get_Swap() < H.get_Swap())
       {
         System.out.println("The Bubble Sort made the same Swaps as Quick Sort " + B.get_Swap());
         System.out.println("The Heap Sort made the most Swaps = " + H.get_Swap());
       }
       else if (B.get_Swap() == Q.get_Swap() && Q.get_Swap() > H.get_Swap())
       {
         System.out.println("The Bubble Sort made the same Swaps as Quick Sort " + B.get_Swap());
         System.out.println("The Heap Sort made the least Swaps = " + H.get_Swap());
       }
       else if (H.get_Swap() == Q.get_Swap() && Q.get_Swap() < B.get_Swap())
       {
         System.out.println("The Heap Sort made the same Swaps as Quick Sort " + B.get_Swap());
         System.out.println("The Bubble Sort made the most Swaps = " + B.get_Swap());
       }
       else if (H.get_Swap() == Q.get_Swap() && Q.get_Swap() > B.get_Swap())
       {
         System.out.println("The Heap Sort made the same Swaps as Quick Sort " + B.get_Swap());
         System.out.println("The Bubble Sort made the least Swaps = " + B.get_Swap());
       }}}