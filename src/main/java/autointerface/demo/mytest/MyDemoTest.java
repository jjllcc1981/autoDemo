package autointerface.demo.mytest;

import autointerface.demo.tools.TestReport_original;
import lombok.extern.slf4j.Slf4j;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Slf4j
@Listeners({TestReport_original.class})
public class MyDemoTest extends AbstractTestNGSpringContextTests {
    @BeforeClass
    public void beforeClass() {
        log.info("==== MyDemoTest  star ====");
    }

    @AfterClass
    public void afterClass() {
        log.info("==== MyDemoTest end ====");
    }

    @Test(description = " MyDemoTest run one")
    public void runOne(){
        log.info("====== MyDemoTest run one ======");
    }
    @Test(description = "MyDemoTest run Two")
    public void runTwo(){
        log.info("====== MyDemoTest run Two ======");
    }
}
