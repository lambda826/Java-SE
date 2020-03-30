package common;

import java.util.concurrent.ForkJoinPool;

public class Singletons {
    public static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool();

}
