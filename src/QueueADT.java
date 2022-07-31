public class QueueADT
{
    private String[] values;
    private int size;
    private int first;
    private int last;

    public QueueADT()
    {
        values = new String[10];
        size = 0;
        first = 0;
        last = 0;
    }

    public void enqueue(String value)
    {
        if (size < values.length)
        {
            values[last] = value;
            last++;
            last %= values.length;
            size++;
        }
        else
            System.out.println("Queue limit reached! Ignoring!");
    }

    public void dequeue()
    {
        if (size != 0)
        {
            System.out.println("Value dequeued!");
            values[first] = " ";
            first++;
            first %= values.length;
            size--;
        }
        else
            System.out.println("Queue empty! Ignoring!");
    }

    public void queueFront()
    {
        if (size != 0)
            System.out.println("First value is: " + values[first]);
        else
            System.out.println("Queue empty! Ignoring!");
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void print()
    {
        System.out.println("Collection currently contains: " + size + " elements");
        if (values.length > 0)
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
    }

    public static void main(String args[])
    {
        //record start time
        long startTime = System.nanoTime();

        //create two new stacks and give them some data
        StackADT stk1 = new StackADT();
        stk1.push("3");
        stk1.push("1");

        StackADT stk2 = new StackADT();
        stk2.push("4");
        stk2.push("2");

        //combine them in a queue, ensuring to pop the numbers after they are added to the queue
        QueueADT que = new QueueADT();

        que.enqueue(stk1.stackTop());
        stk1.pop();
        que.enqueue(stk2.stackTop());
        stk2.pop();
        que.enqueue(stk1.stackTop());
        stk1.pop();
        que.enqueue(stk2.stackTop());
        stk2.pop();

        que.print();

        //record end time and calculate run time
        long endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime) / 1000000000.0 + " seconds");
    }
}
