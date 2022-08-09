/*public class Combination
{
    public static class StackNode
    {
        private String data;
        private StackNode left;
        private StackNode right;

        public StackNode(String data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private StackNode root;
    private int size;

    public Combination()
    {
        root = null;
    }

    //taken from 19.3
    public void push(String value)
    {
        StackNode newNode = new StackNode(value);
        if (isEmpty())
        {
            size++;
            root = newNode;
            //oot.data[root.data.length - size] = value;
        }
        else
        {
            StackNode current = root;
            StackNode parent = null;

            while(true)
            {
                parent = current;
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

    //taken from 19.3
    public void pop()
    {
        if (!isEmpty())
        {
            System.out.println("Value popped!");
            root.data[root.data.length - size] = null;
            size--;
        }
        else
            System.out.println("Stack empty! Ignoring!");
    }

    //taken from 19.3
    public String stackTop()
    {
        if (!isEmpty())
            System.out.println("Topmost value is: " + root.data[root.data.length - size]);
        else
            System.out.println("Stack empty! Ignoring!");
        return root.data[root.data.length - size];
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    //taken from 19.3
    public void print()
    {
        System.out.println("Collection currently contains: " + size + " elements");
        if (!isEmpty())
        {
            System.out.print("Elements include: ");
            for (int i = 0; i < root.data.length; i++)
            {
                System.out.print(root.data[i]);
                if (i < root.data.length - 1)
                    System.out.print(" ");
                else
                    System.out.println();
            }
        }
        //System.out.println("");
    }

    public void run()
    {

        push("12");
        push("14");
        push("1344");
        print();
        stackTop();
        pop();
        print();
        stackTop();
    }

    public static void main(String args[])
    {
        Combination stk = new Combination();
        stk.run();

    }


}
*/