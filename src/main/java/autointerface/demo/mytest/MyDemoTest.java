package autointerface.demo.mytest;

import autointerface.demo.AutodemoApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Slf4j
@SpringBootTest(classes = AutodemoApplication.class)
public class MyDemoTest {
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
