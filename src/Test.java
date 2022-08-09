public class Test
{
    public static class StackNode
    {
        private int data;
        private StackNode left;
        private StackNode right;

        public StackNode(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private StackNode root;

    public Test()
    {
        root = null;
    }

    public void push(int data)
    {
        StackNode newNode = new StackNode(data);

        if(isEmpty())
        {
            root = newNode;
        }
        else
        {
            StackNode current = root;
            StackNode parent = null;

            while(true)
            {
                parent = current;

                if(data < current.data)
                {
                    current = current.left;
                    if(current == null)
                    {
                        parent.left = newNode;
                        return;
                    }
                }
                else
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

    public void pop(int value)
    {
        root = delete(root, value);
    }

    public StackNode delete(StackNode node, int value)
    {
        if(node == null)
        {
            return null;
        }
        else
        {
            if(value < node.data)
                node.left = delete(node.left, value);
            else if(value > node.data)
                node.right = delete(node.right, value);
            else
            {
                if(node.left == null && node.right == null)
                    node = null;
                else if(node.left == null)
                    node = node.right;
                else if(node.right == null)
                    node = node.left;
                else
                {
                    StackNode temp = minStackNode(node.right);
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

    public void stackSearch(StackNode node)
    {
        if(isEmpty())
        {
            System.out.println("The stack is empty!");
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
        Test bst = new Test();
        bst.startDemo();
    }

    public StackNode minStackNode(StackNode root)
    {
        if (root.left != null)
            return minStackNode(root.left);
        else
            return root;
    }

    public void startDemo()
    {
        push(5);
        print();
        push(115);
        print();
        push(6);
        print();
        pop(4);
        pop(6);
        print();
    }
}
