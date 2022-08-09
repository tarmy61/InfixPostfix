public class QueueADT
{
    private StackADT stk1 = new StackADT();
    private StackADT stk2 = new StackADT();

    public QueueADT()
    {
    }

    public void enqueue(char data)
    {
        while (!isEmpty())
        {
            stk2.push(stk1.pop());
        }

        stk1.push(data);

        while (!stk2.isEmpty())
        {
            stk1.push(stk2.pop());
        }
    }

    public char dequeue()
    {
        char data = '\0';
        if (!isEmpty())
        {
            //System.out.println("Value dequeued!");
            data = stk1.stackTop();
            stk1.pop();
        }
        else
            System.out.println("Queue empty! Ignoring!");
        return data;
    }

    public char queueFront()
    {
        if (!isEmpty());
            //System.out.println("First value is: " + stk1.stackTop());
        else
            System.out.println("Queue empty! Ignoring!");
        return stk1.stackTop();
    }

    public boolean isEmpty()
    {
        return stk1.isEmpty();
    }

    public void print()
    {
        System.out.println("Collection currently contains " + stk1.size + " elements");
        if (!isEmpty())
        {
            System.out.print("Elements include: ");
            stk1.print();
        }
    }

    public static void main(String[] args)
    {
        //record start time
        long startTime = System.nanoTime();

        //create a new queue and give it some values
        QueueADT que = new QueueADT();
        que.enqueue('1');
        que.enqueue('2');
        que.enqueue('3');
        que.enqueue('4');

        //print out the queue and display front value
        que.print();
        que.queueFront();

        //remove value at front of queue
        que.dequeue();
        que.print();

        //record end time and calculate run time
        long endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime) / 1000000000.0 + " seconds");
    }
}
