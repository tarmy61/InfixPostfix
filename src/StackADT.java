public class StackADT
{
    private class StackNode
    {
        char data;
        StackNode next;

        public StackNode(char data, StackNode next)
        {
            this.data = data;
            this.next = next;
        }

        public char getData()
        {
            return data;
        }

        public StackNode getNext()
        {
            return next;
        }

        public void setData(char data)
        {
            this.data = data;
        }

        public void setNext(StackNode next)
        {
            this.next = next;
        }
    }

    StackNode root;
    int size;

    public StackADT()
    {
        root = null;
        size = 0;
    }

    public void push(char data)
    {
        root = new StackNode(data, root);
        size++;
    }

    public char pop()
    {
        char data = '\0';
        if (!isEmpty())
        {
            //System.out.println("Value popped!");
            data = root.getData();
            StackNode tmp = root;
            root = root.getNext();
            tmp.setNext(null);
            size--;
        }
        return data;
    }

    public char stackTop()
    {
        char data = '\0';
        if (!isEmpty())
        {
            data = root.getData();
            //System.out.println("The topmost value is: " + data);
        }
        else
            System.out.println("Stack empty! Ignoring!");
        return data;
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    public void print()
    {
        //System.out.println("The STACK currently contains " + size + " elements.");
        StackNode temp = root;
        if (root != null && root.data != '\0')
        {
            //System.out.println("These elements include:");
            do
            {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != null);
        }
        System.out.println();
    }

    public static void main (String[] args)
    {
        StackADT stk = new StackADT();
        stk.push('1');
        stk.push('2');
        stk.push('3');
        stk.print();
        stk.pop();
        stk.print();
    }
}