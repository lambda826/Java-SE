package interfaces;

import static utils.PrintUtil.println;

public class _121_TestRandVals {

    // Since the fields are static, they are initialized when the class is first loaded, which happens when any of the fields are accessed for the first time
    public static void main(String[] args) {
        println(_120_RandVals.RANDOM_INT);
        println(_120_RandVals.RANDOM_LONG);
        println(_120_RandVals.RANDOM_FLOAT);
        println(_120_RandVals.RANDOM_DOUBLE);
    }

}