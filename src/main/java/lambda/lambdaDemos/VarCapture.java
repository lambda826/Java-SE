package lambda.lambdaDemos;


public class VarCapture {

    interface MyFunc {
        int func(int n);
    }

    public static void main(String[] args) {
        int num = 10; // effectively final
        MyFunc myLambda = (n) -> {
            // OK
            int v = num + n; // n doesn't change
            // num++; // not ok, n changes the value
            return v;
        };
        // num = 9; 
    }

}
