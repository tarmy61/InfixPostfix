public class StackADT
{
    private String[] values;
    private int size;

    public StackADT()
    {
        values = new String[10];
        size = 0;
    }

    /*public StackADT(String[] values, int size)
    {
        this.values = values;
        this.size = size;
    }*/

    //taken from 19.3
    public void push(String value)
    {
        if (size < values.length)
        {
            size++;
            values[values.length - size] = value;
        }
        else
            System.out.println("Stack limit reached! Ignoring!");
    }

    //taken from 19.3
    public void pop()
    {
        if (!isEmpty())
        {
            System.out.println("Value popped!");
            values[values.length - size] = " ";
            size--;
        }
        else
            System.out.println("Stack empty! Ignoring!");
    }

    //taken from 19.3
    public String stackTop()
    {
        if (!isEmpty())
            System.out.println("Topmost value is: " + values[values.length - size]);
        else
            System.out.println("Stack empty! Ignoring!");
        return values[values.length - size];
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    //taken from 19.3
    public void print()
    {
        System.out.println("Collection currently contains: " + size + " elements");
        if (!isEmpty()) //values.length > 0)
        {
            System.out.print("Elements include: ");
            for (int i = 0; i < values.length; i++)
            {
                System.out.print(values[i]);
                if (i < values.length - 1)
                    System.out.print(" ");
                else
                    System.out.println();
            }
        }
        //System.out.println("");
    }

    public static void main(String args[])
    {
        StackADT stk = new StackADT();
        stk.push("12");
        stk.push("14");
        stk.print();
        stk.stackTop();
    }

    //TBC
    public static class StackNode
    {
        private String data;
        private StackNode nextAddress;

        public StackNode()
        {
        }

        public StackNode(String data)
        {
            this.data = data;
            nextAddress = null;
        }

        public String getData()
        {
            return data;
        }

        public StackNode getNext()
        {
            return nextAddress;
        }

        public void setData(String data)
        {
            this.data = data;
        }

        public void setNext(StackNode n)
        {
            nextAddress = n;
        }
    }
}
