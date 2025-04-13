import java.util.Scanner;

public class test {
    
    private static Scanner myScanner = new Scanner(System.in); 

       public static void main(String[] args){
        userInput();
    }

    public static void userInput(){
            System.out.println("Enter number 1:");
            int num1 = myScanner.nextInt();
            System.out.println("Enter number 2:");
            int num2 = myScanner.nextInt();
            operation(num1, num2);
    }

    public static void operation(int input1, int input2){
        System.out.println("What operation do you want to perform?");
        System.out.println("+ | - | * | / ");
        String operator = myScanner.next();

        switch (operator) {
            case "+":
                sum(input1 , input2);
                break;
            case "-":
                subtract(input1, input2);
                break;
            case "*":
                multiply(input1, input2);
                break;
            case "/":
                divide(input1, input2);
                break;
        }
    }
    
    public static void sum(float x, float y){
        int sumResult = (int) (x + y);
        System.out.println("Result is: " + sumResult);
        close();
    }

    public static void subtract(float x, float y){
        int subtractResult = (int) (x - y);
        System.out.println("Result is: " + subtractResult);
        close();
    }

    public static void multiply(float x, float y){
        int multiplyResult = (int) (x * y);
        System.out.println("Result is: " + multiplyResult);
        close();
    }

    public static void divide(float x, float y){
        System.out.println("Result is: " + (x / y));
        close();
    }

    public static void close(){
        System.out.println("Do you want to continue?");
        System.out.println("Y / N");
        String close = myScanner.next();

        if(close.equals('Y') || close.equals("y")){
            userInput();
        }
        else if (close.equals("N") || close.equals("n")){
            System.exit(0);
        }
        else{
            close();
        }
    }
}
