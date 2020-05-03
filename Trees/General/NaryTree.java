import java.util.*;

public class NaryTree
{
    private Node root;

    static public class Node
    {
        private List<Node> children;
        private String Name;

        public Node(List<Node> children, String Name)
        {
            this.children = children;
            this.Name = Name;
        }
        

        public void add(Node n)
        {
            if (children == null) children = new ArrayList<>();
            children.add(n);
        }
    }

    public void add(String ... Array) 
    {
        if (root == null) root = new Node(null, Array[0]);
        if (root.Name != Array[0]) { ; }
        else
        {
            if (Array.length >= 1) { Array = Arrays.copyOfRange(Array, 1, Array.length); }
            add(root, Array);
        }
    }

    public void add(Node tempRoot, String ... Array)
    {
        boolean present = false;
        int index = -1;

        for (int i = 0; i < Array.length; i++)
        {
            if (tempRoot.children != null)
            {
                for (int j = 0; j < tempRoot.children.size()-1; j++)
                {
                    if (tempRoot.children.get(j).Name == Array[0]) present = true;
                }
            }
            if (!present) { tempRoot.add(new Node(null, Array[0])); }
            for (Node f : tempRoot.children)
            {
                index++;
                if (f.Name == Array[0])
                {
                    if (index <= tempRoot.children.size()-1) tempRoot = tempRoot.children.get(index);
                    if (Array.length >= 1) Array = Arrays.copyOfRange(Array, 1, Array.length);
                    add(tempRoot, Array);
                    break;
                }}
            break;
        }}

    public boolean contains(String val) { return contains(root, val); }

    private boolean contains(Node n, String val)
    {
        boolean found = false;
        if (n == null) return found;
        if (n.Name == val) found = true;
        else if (n.children != null) for (Node f : n.children) { return contains(f, val); }
        return found;
    }

    public void print()
    {
        System.out.println("The family root is "+root.Name+".");
        for (Node n : root.children)
        {

            System.out.println(n.Name+" is a child of " + root.Name);
            printChildren(n);
        }
    }

    public void printChildren(Node n)
    {
        if (n.children != null)
        {
            for (Node child : n.children)
            {

                System.out.println(n.Name+" has "+child.Name+" as a child.");
                printChildren(child);
            }
        }
    }}