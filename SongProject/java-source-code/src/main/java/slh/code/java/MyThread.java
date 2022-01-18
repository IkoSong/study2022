package slh.code.java;

import java.util.concurrent.Callable;

public class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {

        return 1234;
    }
}
