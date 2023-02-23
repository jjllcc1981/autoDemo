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
public class MyShowTest extends AbstractTestNGSpringContextTests {
    @BeforeClass
    public void beforeClass() {
        log.info("====  star ====");
    }

    @AfterClass
    public void afterClass() {
        log.info("====  end ====");
    }

    @Test(description = " MyShowTest run one")
    public void runOne(){
        log.info("====== MyShowTest run one ======");
    }
    @Test(description = "MyShowTest run Two")
    public void runTwo(){
        log.info("====== MyShowTest run Two ======");
    }
}
