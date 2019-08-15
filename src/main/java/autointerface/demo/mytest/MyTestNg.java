package autointerface.demo.mytest;

import autointerface.demo.AutodemoApplication;
import autointerface.demo.mybatis.entity.MockDataInfo;
import autointerface.demo.mybatis.mapper.MockDataInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

@SpringBootTest(classes = AutodemoApplication.class)
public class MyTestNg extends AbstractTestNGSpringContextTests {
    private final static Logger LOG = LoggerFactory.getLogger(MyTestNg.class);

    @Autowired
    private MockDataInfoMapper mockDataInfoMapper;

    @BeforeClass
    public void beforeClass() {
        LOG.info("====  star ====");
    }

    @AfterClass
    public void afterClass() {
        LOG.info("====  end ====");
    }

    @Test
    public void getPrimaryKey(){
        MockDataInfo mockDataInfo = mockDataInfoMapper.selectByPrimaryKey(2);
        LOG.info(mockDataInfo.toString());
    }

    @Test
    public void getById(){
        MockDataInfo mockDataInfo = mockDataInfoMapper.getById(10);
        LOG.info(mockDataInfo.toString());
    }

    @Test
    public  void getByBusinessPath(){
        MockDataInfo mockDataInfo = mockDataInfoMapper.getByBusinessPath("/order/list");
        LOG.info(mockDataInfo.toString());
    }

    @Test
    public void getAll(){
        List<MockDataInfo> mockDataInfos = mockDataInfoMapper.selectAll();
        for (MockDataInfo mockDataInfo : mockDataInfos){
            LOG.info(mockDataInfo.toString());
        }
    }
}
