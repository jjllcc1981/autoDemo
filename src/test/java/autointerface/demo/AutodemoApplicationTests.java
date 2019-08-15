package autointerface.demo;


import autointerface.demo.mybatis.entity.MockDataInfo;
import autointerface.demo.mybatis.mapper.MockDataInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutodemoApplicationTests {

    @Autowired
    private MockDataInfoMapper mockDataInfoMapper;

    @Test
    public void contextLoads() {

//        MockDataInfo mockDataInfo = mockDataInfoMapper.selectByPrimaryKey(2);
        // /trailer/list/get
//        MockDataInfo mockDataInfo = mockDataInfoMapper.getByBusinessPath("/trailer/list/get");
        MockDataInfo mockDataInfo = mockDataInfoMapper.getById(10);
        System.out.println(mockDataInfo.toString());

//        List<MockDataInfo> list = mockDataInfoMapper.selectAll();
//        for(MockDataInfo mockdata : list){
//            System.out.println("*************** " + mockdata.toString());
//        }

    }

}
