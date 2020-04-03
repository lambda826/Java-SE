package lambda.behavior_parameterization;

import lambda.Constant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static utils.PrintUtil.println;

public class ExecuteAroundPattern_AOP {

    // BufferedReader -> String
    @FunctionalInterface
    public interface BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }

    // Method we want to refactor to make more flexible
    public static String processFileLimited() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(Constant.path))) {
            return br.readLine();
        }
    }

    public static String processFile(BufferedReaderProcessor processor) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(Constant.path))) {
            return processor.process(br);
        }
    }

    public static void main(String... args) throws IOException {

        // Limited behavior
        println(processFileLimited());

        // Passing lambda expression as behaviors, this lambda acts as an implementation instance of the functional interface BufferedReaderProcessor
        println(processFile((BufferedReader b) -> b.readLine()));
        println(processFile((BufferedReader b) -> b.readLine() + b.readLine()));

    }

}
