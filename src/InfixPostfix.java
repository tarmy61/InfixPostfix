public class InfixPostfix
{
    public InfixPostfix()
    {
    }

    public boolean isOperator(char value)
    {
        return switch (value)
                {
                    case '+' -> true;
                    case '-' -> true;
                    case '*' -> true;
                    case '/' -> true;
                    case '%' -> true;
                    case '^' -> true;
                    default -> false;
                };
    }

    public boolean precedence(char operator1, char operator2)
    {
        int op1pre = 0;
        int op2pre = 0;

        switch (operator1)
        {
            case '+' -> op1pre = 1;
            case '-' -> op1pre = 1;
            case '*' -> op1pre = 2;
            case '/' -> op1pre = 2;
            case '%' -> op1pre = 2;
            case '^' -> op1pre = 3;
        }

        switch (operator2)
        {
            case '+' -> op2pre = 1;
            case '-' -> op2pre = 1;
            case '*' -> op2pre = 2;
            case '/' -> op2pre = 2;
            case '%' -> op2pre = 2;
            case '^' -> op2pre = 3;
        }
        return op1pre >= op2pre;
    }

    public void convertToPostfix(String expression)
    {
        System.out.println("The infix expression is: " + expression);

        //create a new queue 'infix'
        QueueADT infix = new QueueADT();
        for (int i = 0; i < expression.length(); i++)
        {
            if (!("" + expression.charAt(i)).equals(" "))
            {
                infix.enqueue(expression.charAt(i));
            }
        }

        //create a stack to be used as an intermediate between infix and postfix
        StackADT stack = new StackADT();

        //create a new queue 'postfix'
        QueueADT postfix = new QueueADT();

        //algorithm begins
        stack.push('(');
        infix.enqueue(')');
        while (!infix.isEmpty())
        {
           /*if (infix.queueFront() == '(')
           {
               stack.push(infix.queueFront());
               infix.dequeue();
           }
           else if (infix.queueFront() == ')')
           {
               while (!stack.isEmpty() && stack.stackTop() != '(')
                   postfix.enqueue(stack.pop());
               //stack.pop();
           }*/

           if (!stack.isEmpty())
           {
               char c = infix.dequeue();
               if (!isOperator(c) && c != '(' && c != ')')
               {
                   postfix.enqueue(c);
               }
               else if (c == '(')
               {
                   stack.push(c);
               }
               else if (isOperator(c))
               {
                   while (precedence(stack.stackTop(),c))
                   {
                       postfix.enqueue(stack.pop());
                   }
                   stack.push(c);
               }
               else if (c == ')')
               {
                   while (stack.stackTop() != '(')
                   {
                       postfix.enqueue(stack.pop());
                   }
                   /*boolean topop = false;
                   while (!topop)
                   {
                       if (stack.stackTop() != '(')
                       {
                           postfix.enqueue(stack.pop());
                       }
                       if (stack.stackTop() == '(')
                       {
                           topop = true;
                       }
                   }*/
                   stack.pop();
               }
           }

        }

        //convert postfix queue into string
        StringBuilder answer = new StringBuilder();
        while (!postfix.isEmpty())
        {
            answer.append(postfix.dequeue());
        }
        System.out.println("The postfix expression is: " + answer);

        //System.out.println("INFIX");
        //infix.print();
        //System.out.println("STACK");
        //stack.print();
        //System.out.println("POSTFIX");
        //postfix.print();
    }

    public static void main(String[] args)
    {
        //record start time
        long startTime = System.nanoTime();

        //run program with manual input
        InfixPostfix ip = new InfixPostfix();
        ip.convertToPostfix("(6+2)*5-8/4");

        //record end time and calculate run time
        long endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime) / 1000000000.0 + " seconds");
    }



    /*if(ip.isOperator("0") == true)
            System.out.println("OKOKOK");

    if(ip.precedence("+","*") == false)
            System.out.println("NONONON");*/
}
