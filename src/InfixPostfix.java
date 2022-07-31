public class InfixPostfix
{
    private String[] values;
    private int size;

    public InfixPostfix()
    {
        values = new String[10];
        size = 0;
    }

    public boolean isOperator(String value)
    {
        boolean check = false;
        switch(value)
        {
            case "+":
                check = true;
                break;
            case "-":
                check = true;
                break;
            case "*":
                check = true;
                break;
            case "/":
                check = true;
                break;
            case "%":
                check = true;
                break;
            case "^":
                check = true;
                break;
            default:
                check = false;
                break;
        }
        return check;
    }

    public boolean precedence(String operator1, String operator2)
    {
        int op1pre = 0;
        int op2pre = 0;

        switch(operator1)
        {
            case "+":
                op1pre = 1;
                break;
            case "-":
                op1pre = 1;
                break;
            case "*":
                op1pre = 2;
                break;
            case "/":
                op1pre = 2;
                break;
            case "%":
                op1pre = 2;
                break;
            case "^":
                op1pre = 3;
                break;
        }

        switch(operator2)
        {
            case "+":
                op2pre = 1;
                break;
            case "-":
                op2pre = 1;
                break;
            case "*":
                op2pre = 2;
                break;
            case "/":
                op2pre = 2;
                break;
            case "%":
                op2pre = 2;
                break;
            case "^":
                op2pre = 3;
                break;
        }
        return op1pre > op2pre;
    }

    public void convertToPostfix()
    {

    }

    public static void main(String args[])
    {
        //record start time
        long startTime = System.nanoTime();

        InfixPostfix ip = new InfixPostfix();
        if(ip.isOperator("0") == true)
            System.out.println("NONONON");

        if(ip.precedence("+","*") == false)
            System.out.println("NONONON");

        //record end time and calculate run time
        long endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime) / 1000000000.0 + " seconds");
    }
}
