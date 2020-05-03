class BinarySortedTree { 
  
    class Node { 
        int key; 
        Node left, right; 
  
        public Node(int value) { 
            key = value; 
            left = right = null; 
        }} 
    
    // Constructing the Tree.
    Node root;
    BinarySortedTree() 
    {  
      root = null;  
    } 
  
    // Inserting Records Sorted.
    void insert(int key) 
    { 
       root = insertRec(root, key); 
    } 
      
    Node insertRec(Node root, int key) 
    {
      if (root == null) { 
        root = new Node(key); 
        return root; 
      } 
      if (key < root.key) 
        root.left = insertRec(root.left, key); 
      else if (key > root.key) 
        root.right = insertRec(root.right, key);
      return root; 
    }
    
    // Counting and Print Children.
    void printChildren()  
     { 
       printChildren(root); 
     } 
  
     void printChildren(Node root) 
     { 
       if (root != null) 
       {
         System.out.println("Node " + root.key + " Number of Children = " + (countChildren(root)-1)); 
         printChildren(root.left); 
         printChildren(root.right); 
      }}
    private int countChildren(Node r)
    {
      if (r == null)
        return 0;
      else
      {
        int k = 1;
        k += countChildren(r.left);
        k += countChildren(r.right);
        return k;
      }}
    
    // Replacing Nodes Value Instead of Deleting.
    public boolean Replace(int val)
     { 
      if (root == null)
        return false;
       return Replace(root, val);
     }

     private boolean Replace(Node r, int val)
     {
       if (r.key == val)
         {
           r.key = 987987;
           return true;
         }
         if (r.left != null)
         {
           if (Replace(r.left, val))  
               return true;
         }
         if (r.right != null)
         {
           if (Replace(r.right, val))
             {
               return true;
             }}
         return false;         
     }
  
     // Count Nodes.
     public int countNodes()
     {
       return countNodes(root);
     }
     private int countNodes(Node r)
     {
       if (r == null)
         return 0;
       else
       {
         int l = 1;
         l += countNodes(r.left);
         l += countNodes(r.right);
         return l;
       }}
           
     // In_Order Print.            
     void inorder()  
     { 
       inorderRec(root); 
     } 
  
     void inorderRec(Node root) 
     { 
       if (root != null) { 
         inorderRec(root.left); 
         if (root.key != 987987)
           System.out.print(root.key + " "); 
         inorderRec(root.right); 
       }}
    
     // Post_Order Print.
     void postorder()  
     { 
       postorderRec(root); 
     } 
  
     void postorderRec(Node root) { 
       if (root != null) 
       { 
         postorderRec(root.left); 
         postorderRec(root.right); 
         if (root.key != 987987)
           System.out.print(root.key + " "); 
       }}
    
     // Pre_Order Print.
     void preorder()  
     { 
       preorderRec(root); 
     } 
  
     void preorderRec(Node root) 
     { 
       if (root != null) 
       { 
         if (root.key != 987987)
           System.out.print(root.key + " "); 
         preorderRec(root.left); 
         preorderRec(root.right); 
       }}
     
     // Free the Tree.
     void freeTree() 
     {
       root = null;  
       }} 
  