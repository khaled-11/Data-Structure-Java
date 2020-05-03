import java.util.*;
import java.io.*;

class GFG { 
  
    static class NodeTemp 
    { 
        String Name;
        String Father;
        NodeTemp next, child; 
        public NodeTemp(String name, String father) 
        { 
            this.Name = name; 
            this.Father = father; 
            next = child = null; 
        }} 
      
    // Adds a sibling
    static public NodeTemp addSibling(NodeTemp node, String Name, String Father) 
    { 
        if(node == null) 
            return null; 
        while(node.next != null) 
            node = node.next; 
        return(node.next = new NodeTemp(Name, Father)); 
    } 
          
    // Add child
    static public NodeTemp addChild(NodeTemp node,String Name, String Father) 
    { 
        if(node == null) 
            return null; 
      
        // Check if child is not empty. 
        if(node.child != null) 
            return(addSibling(node.child,Name, Father)); 
        else
            return(node.child = new NodeTemp(Name, Father)); 
    } 
  
    // Traverses tree in level order 
    static public void traverseTree(NodeTemp root) 
    { 
        if(root == null) 
            return; 
        while(root != null) 
        { 
          System.out.print(root.Name + " Father Name is : " + root.Father + "     ");
            if(root.child != null) 
                traverseTree(root.child);   
            root = root.next;    
        }} 
    
    // Traverses tree in Post Order. 
    static public void postTraverse(NodeTemp root) 
    { 
        if(root == null) 
            return; 
        while(root != null) 
        {
            if(root.child != null) 
              postTraverse(root.child); 
            System.out.print(root.Name + " Father Name is : " + root.Father + "     ");
            root = root.next;    
        }} 
    
    // Father Searching Method.
    static public void searchFather(NodeTemp root, String X) 
    { 
      if(root == null) 
        return; 
      while(root != null) 
      { 
        if(root.child != null) 
          searchFather(root.child,X);
        if (X.equals(root.Name))
          System.out.print(root.Father);    
        root = root.next;  
      }}
    
    // Brothers Searching Method.
    static public void Brothers(NodeTemp root, NodeTemp Temp, String X) 
    { 
       if(root == null) 
        return; 
      while(root != null) 
      { 
        if(root.child != null) 
          Brothers(root.child,Temp,X);
        if (X.equals(root.Name))
        searchAllSons(Temp,root.Father);
        root = root.next; 
      }}
    
    // Grand Father Searching Method.
    static public void searchGrandFather(NodeTemp root, String X) 
    { 
          System.out.print(root.Name);
    }
    
    // All Sons Searching Method.
    static public void searchAllSons(NodeTemp root, String X) 
    { 
      NodeTemp q;
      if(root == null) 
        return; 
      while(root != null) 
      { 
        if(root.child != null) 
          searchAllSons(root.child,X);
        if (X.equals(root.Name))
        {
          q = root.child;
          System.out.print(q.Name + " ");
          while (q.next != null)
          {
            q = q.next;
            System.out.print(q.Name + " ");
          }
          return;
        } 
        root = root.next;  
      }}
    
    // Oldest Brothers Searching Method.
    static public void OldestBrother(NodeTemp root, NodeTemp Temp, String X) 
    { 
       if(root == null) 
        return; 
      while(root != null) 
      { 
        if(root.child != null) 
          OldestBrother(root.child,Temp,X);
        if (X.equals(root.Name))
        OldestSon(Temp,root.Father);
        root = root.next; 
      }}

    
    // Youngest Brothers Searching Method.
    static public void YoungestBrother(NodeTemp root, NodeTemp Temp, String X) 
    { 
       if(root == null) 
        return; 
      while(root != null) 
      { 
        if(root.child != null) 
          YoungestBrother(root.child,Temp,X);
        if (X.equals(root.Name))
        YoungestSon(Temp,root.Father);
        root = root.next; 
      }}
    
    // Youngest Son Searching Method.
    static public void YoungestSon(NodeTemp root, String X) 
    { 
      NodeTemp q,p;
      if(root == null) 
        return; 
      while(root != null) 
      { 
        if(root.child != null) 
          YoungestSon(root.child,X);
        if (X.equals(root.Name))
        {
          p= root.child;
          if (p == null)
          {
            System.out.print("Nothing Found");
            return;
          }
          if (p.next == null)
          {
            System.out.print(p.Name);
            return;
          }
          p = p.next;
          if (p.next == null)
          {
            System.out.print(p.Name);
            return;
          }
          p = p.next;
          if (p.next == null)
            System.out.print(p.Name);     
          return;
        }
        root = root.next;  
      }}
    
    // Oldest Son Searching Method.
    static public void OldestSon(NodeTemp root, String X) 
    { 
      NodeTemp q;
      if(root == null) 
        return; 
      while(root != null) 
      { 
        if(root.child != null) 
          OldestSon(root.child,X);
        if (X.equals(root.Name))
        {
          q = root.child;
          System.out.print(q.Name + " ");
          return;
        } 
        root = root.next;  
      }}
    
    // Uncles searching Method.
    static public void Uncles(NodeTemp root, NodeTemp Temp, NodeTemp R, String X) 
    { 
      NodeTemp p;
       if(root == null) 
        return; 
      while(root != null) 
      { 
        if(root.child != null) 
          Uncles(root.child,Temp,R,X);
        if (X.equals(root.Name))
        Brothers(Temp,R,root.Father);
        root = root.next; 
      }}
    
    public static void main(String args[]) throws Exception
    { 
 
      // Creating and printing N-Ary Family Tree by ONLY Full-Name of the sons.
      NaryTree Family = new NaryTree();       
      Family.add( new String[] {"Robert", "John", "Vector" });
      Family.add( new String[] {"Robert", "David", "Jenifer"}); 
      Family.add( new String[] {"Robert", "John", "Mitch" ,"Justin"});
      Family.add( new String[] {"Robert", "Sam", "Keith" , "Michael"});
      Family.add( new String[] {"Robert", "David", "Alex"});
      System.out.println("From the General N-Ary ordered Tree:");
      Family.print();
      System.out.println();
           
      // Reading the data into the Left-Child / Right-Sibling Tree.
      Scanner sc = new Scanner(new File("Family.txt"));
      String M = sc.next();
      NodeTemp root = new NodeTemp(M,"Root"); 
      String N = sc.next();
      NodeTemp n1  = addChild(root,N,M);
      String X = sc.next();
      NodeTemp n2 = addChild(root,X,M); 
      String Z = sc.next();
      NodeTemp n3 = addChild(root,Z,M); 
      String R = sc.next();
      NodeTemp n4 = addChild(n1,R,N);
      String P = sc.next();
      NodeTemp n5 = addChild(n1,P,N);
      NodeTemp n6 = addChild(n5,sc.next(),P);
      NodeTemp n7 = addChild(n2,sc.next(),X);
      NodeTemp n8 = addChild(n2,sc.next(),X);
      String Y = sc.next();
      NodeTemp n9 = addChild(n3,Y,Z);
      NodeTemp n10 = addChild(n9,sc.next(),Y);
        
      // Traverse the tree.
      System.out.print("Order traversal of the left-child / Right-Sibling Tree:");
      System.out.println();
      traverseTree(root); 
      System.out.println();
      System.out.println();
      System.out.print("Post-Order traversal of the left-child / Right-Sibling Tree:");
      System.out.println();
      postTraverse(root); 
      System.out.println();
      System.out.println();
      
      // Asking the questions and send to the Methods.
      System.out.println("Who is the father of John?");
      System.out.print("John Father is ");
      searchFather(root, "John");
      System.out.println();
      System.out.println("Who is the father of Mitch?");
      System.out.print("Mitch Father is ");
      searchFather(root, "Mitch");
      System.out.println();
      System.out.println("Who is the father of Justin?");
      System.out.print("Justin Father is ");
      searchFather(root, "Justin");
      System.out.println();   
      System.out.println("Who is the Grand Father of Justin?");
      System.out.print("Justin Grand Father is ");
      searchGrandFather(root, "Justin");
      System.out.println();
      System.out.println("Who is the Grand Father of Mitch?");
      System.out.print("Mitch Grand Father is ");
      searchGrandFather(root, "Mitch");
      System.out.println();
      System.out.println("Who all sons of David?");
      System.out.print("David all sons are : ");
      searchAllSons(root, "David");
      System.out.println();
      System.out.println("Who all sons of Robert?");
      System.out.print("Robert all sons are : ");
      searchAllSons(root, "Robert");
      System.out.println();
      System.out.println("Who all sons of Sam?");
      System.out.print("Sam all sons are : ");
      searchAllSons(root, "Sam");
      System.out.println();
      System.out.println("Who all sons of John?");
      System.out.print("John all sons are : ");
      searchAllSons(root, "John");
      System.out.println();
      System.out.println("Who is the oldest son of John?");
      System.out.print("John Oldest son is : ");
      OldestSon(root, "John");
      System.out.println();
      System.out.println("Who is the oldest son of Robert?");
      System.out.print("Robert Oldest son is : ");
      OldestSon(root, "Robert");
      System.out.println();
      System.out.println("Who is the Youngest son of Robert?");
      System.out.print("Robert Youngest son is : ");
      YoungestSon(root, "Robert");
      System.out.println();
      System.out.println("Who is the Youngest son of Keith?");
      System.out.print("Keith Youngest son is : ");
      YoungestSon(root, "Keith");
      System.out.println();
      System.out.println("Who is the Youngest son of Justin?");
      System.out.print("Justin Youngest son is : ");
      YoungestSon(root, "Justin");
      System.out.println();     
      System.out.println("Who are all the brothers of Sam?");
      System.out.print("Sam Brothers are ");
      Brothers(root,root,"Sam");
      System.out.println();
      System.out.println("Who is the youngest brother of John?");
      System.out.print("John Youngest Brothers are ");
      YoungestBrother(root,root,"John");
      System.out.println();
      System.out.println("Who is the youngest brother of Vector?");
      System.out.print("Vector Youngest Brothers are ");
      YoungestBrother(root,root,"Vector");
      System.out.println();
      System.out.println("Who is the youngest brother of Jenifer?");
      System.out.print("Jenifer Youngest Brother are ");
      YoungestBrother(root,root,"Jenifer");
      System.out.println();
      System.out.println("Who is the oldest brother of David?");
      System.out.print("David oldest Brothers are ");
      OldestBrother(root,root,"David");
      System.out.println();
      System.out.println("Who is the oldest brother of Alex?");
      System.out.print("Alex oldest Brother are ");
      OldestBrother(root,root,"Alex");
      System.out.println();
      System.out.println("Who are the uncles of Jenifer?");
      System.out.print("Jenifer Uncles father are : ");
      Uncles(root,root,root,"Jenifer");
      System.out.println();
      System.out.println("Who are the uncles of Justin?");
      System.out.print("Justin Uncles are : ");
      Uncles(root,root,root,"Justin");
      System.out.println();
      System.out.println();
      System.out.println();
      
      // Create a second Binary Tree to test.
      
      // Creating and printing N-Ary Family Tree by ONLY Full-Name of the sons.
      NaryTree Family2 = new NaryTree();       
      Family2.add( new String[] {"Jones", "Bob", "Richard" });
      Family2.add( new String[] {"Jones", "Dan"}); 
      Family2.add( new String[] {"Jones", "Bob", "Jake" ,"Bill"});
      Family2.add( new String[] {"Jones", "Brian", "Michael" , "Davielle"});
      Family2.add( new String[] {"Jones", "Dan"});
      System.out.println("From the General N-Ary ordered Tree:");
      Family2.print();
      System.out.println();
      // Reading the data into the Left-Child / Right-Sibling Tree.
      NodeTemp root2 = new NodeTemp("Jones","Root"); 
      NodeTemp n12  = addChild(root2,"Bob","Jones");
      NodeTemp n22 = addChild(root2,"Dan","Jones"); 
      NodeTemp n32 = addChild(root2,"Brian","Jones"); 
      NodeTemp n42 = addChild(n12,"Richard","Bob");
      NodeTemp n52 = addChild(n12,"Jake","Bob");
      NodeTemp n62 = addChild(n32,"Michael","Brian");
      NodeTemp n72 = addChild(n52,"Bill","Jake");
      NodeTemp n82 = addChild(n62,"Deville","Michael");;
        
      // Traverse the tree.
      System.out.print("Order traversal of the left-child / Right-Sibling Tree:");
      System.out.println();
      traverseTree(root2); 
      System.out.println();
      System.out.println();
      System.out.print("Post-Order traversal of the left-child / Right-Sibling Tree:");
      System.out.println();
      postTraverse(root2); 
      System.out.println();
      System.out.println();
      
      // Asking the questions and send to the Methods.

      System.out.println("Who is the father of Jake?");
      System.out.print("Jake Father is ");
      searchFather(root2, "Jake");
      System.out.println();
      System.out.println("Who is the father of Bill?");
      System.out.print("Bill Father is ");
      searchFather(root2, "Bill");
      System.out.println();   
      System.out.println("Who is the Grand Father of Bill?");
      System.out.print("Bill Grand Father is ");
      searchGrandFather(root2, "Bill");
      System.out.println();
      System.out.println("Who is the Grand Father of Jake?");
      System.out.print("Jake Grand Father is ");
      searchGrandFather(root2, "Jake");
      System.out.println();
      System.out.println("Who all sons of Bob?");
      System.out.print("Bob all sons are : ");
      searchAllSons(root2, "Bob");
      System.out.println();
      System.out.println("Who all sons of Jones?");
      System.out.print("Jones all sons are : ");
      searchAllSons(root2, "Jones");
      System.out.println();
      System.out.println("Who all sons of Brian?");
      System.out.print("Brian all sons are : ");
      searchAllSons(root2, "Brian");
      System.out.println();
      System.out.println("Who all sons of Bob?");
      System.out.print("Bob all sons are : ");
      searchAllSons(root2, "Bob");
      System.out.println();
      System.out.println("Who is the oldest son of Bob?");
      System.out.print("Bob Oldest son is : ");
      OldestSon(root2, "Bob");
      System.out.println();
      System.out.println("Who is the oldest son of Jones?");
      System.out.print("Jones Oldest son is : ");
      OldestSon(root2, "Jones");
      System.out.println();
      System.out.println("Who is the Youngest son of Jones?");
      System.out.print("Jones Youngest son is : ");
      YoungestSon(root2, "Jones");
      System.out.println();
      System.out.println("Who is the Youngest son of Michael?");
      System.out.print("Michael Youngest son is : ");
      YoungestSon(root2, "Michael");
      System.out.println();
      System.out.println("Who is the Youngest son of Bill?");
      System.out.print("Bill Youngest son is : ");
      YoungestSon(root2, "Bill");
      System.out.println();     
      System.out.println("Who are all the brothers of Brian?");
      System.out.print("Brian Brothers are ");
      Brothers(root2,root2,"Brian");
      System.out.println();
      System.out.println("Who is the youngest brother of Bob?");
      System.out.print("Bob Youngest Brothers are ");
      YoungestBrother(root2,root2,"Bob");
      System.out.println();
      System.out.println("Who is the youngest brother of Richard?");
      System.out.print("Richard Youngest Brothers are ");
      YoungestBrother(root2,root2,"Richard");
      System.out.println();
      System.out.println("Who is the youngest brother of Jake?");
      System.out.print("Jake Youngest Brother are ");
      YoungestBrother(root2,root2,"Jake");
      System.out.println();
      System.out.println("Who is the oldest brother of David?");
      System.out.print("David oldest Brothers are ");
      OldestBrother(root2,root2,"David");
      System.out.println();
      System.out.println("Who is the oldest brother of Alex?");
      System.out.print("Alex oldest Brother are ");
      OldestBrother(root2,root2,"Alex");
      System.out.println();
      System.out.println("Who are the uncles of Jenifer?");
      System.out.print("Jenifer Uncles father are : ");
      Uncles(root2,root2,root2,"Jenifer");
      System.out.println();
      System.out.println("Who are the uncles of Bill?");
      System.out.print("Bill Uncles are : ");
      Uncles(root2,root2,root2,"Bill");
      System.out.println();
     
    }} 