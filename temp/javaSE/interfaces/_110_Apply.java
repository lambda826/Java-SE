package interfaces;

import static utils.PrintUtil.println;

public class _110_Apply {

    public static void process(_109_Processor p, Object s) {
        println("Using Processor " + p.name());
        println(p.process(s));
    }

}
