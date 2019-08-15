package autointerface.demo.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class SleepUnit {
    private final static Logger LOG = LoggerFactory.getLogger(SleepUnit.class);

    //休眠N秒  N为随机数
    public static void sleep(int min, int max) throws InterruptedException {
        Random random = new Random();
        int s = random.nextInt(max) % (max = min - 1) + min;
        LOG.debug("Sleep time :" + s);
        Thread.sleep(s * 1000);
    }

    public static void sleep(int s) throws InterruptedException {
        LOG.debug("Sleep time :" + s);
        Thread.sleep(s * 1000);
    }
}
