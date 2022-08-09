public class TestString
{
    public static class StackNode
    {
        private String data;
        private TestString.StackNode left;
        private TestString.StackNode right;

        public StackNode(String data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private TestString.StackNode root;

    public TestString()
    {
        root = null;
    }

    public void push(String data)
    {
        TestString.StackNode newNode = new TestString.StackNode(data);

        if(root == null)
        {
            root = newNode;
            return;
        }
        else
        {
            TestString.StackNode current = root;
            TestString.StackNode parent = null;

            //while(true)
            {
                parent = current;

                /*if(data < current.data)
                {
                    current = current.left;
                    if(current == null)
                    {
                        parent.left = newNode;
                        return;
                    }
                }*/
                //else
                {
                    current = current.right;
                    if(current == null)
                    {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void pop(String value)
    {
        root = delete(root, value);
    }

    public TestString.StackNode delete(TestString.StackNode node, String value)
    {
        if(node == null)
        {
            return null;
        }
        else
        {
            /*if(value < node.data)
                node.left = pop(node.left, value);
            else if(value > node.data)
                node.right = pop(node.right, value);*/
            //else
            {
                if(node.left == null && node.right == null)
                    node = null;
                else if(node.left == null)
                    node = node.right;
                else if(node.right == null)
                    node = node.left;
                else
                {
                    TestString.StackNode temp = minStackNode(node.right);
                    node.data = temp.data;
                    node.right = delete(node.right, temp.data);
                }
            }
            return node;
        }
    }

    public void print()
    {
        stackSearch(root);
        System.out.println();
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    public void stackSearch(TestString.StackNode node)
    {
        if(root == null)
        {
            System.out.println("Tree is empty");
        }
        else
        {
            if(node.left!= null)
                stackSearch(node.left);
            System.out.print(node.data + " ");
            if(node.right!= null)
                stackSearch(node.right);
        }
    }

    public static void main(String[] args)
    {
        TestString bst = new TestString();
        bst.startDemo();
    }

    public TestString.StackNode minStackNode(TestString.StackNode root)
    {
        if (root.left != null)
            return minStackNode(root.left);
        else
            return root;
    }

    public void startDemo()
    {
        push("5");
        print();
        push("6");
        print();
        pop("4");
        pop("h");
        print();
    }
}
