package autointerface.demo.mytest;

import autointerface.demo.AutodemoApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Slf4j
@SpringBootTest(classes = AutodemoApplication.class)
public class MyShowTest {
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
