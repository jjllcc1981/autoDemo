package autointerface.demo.mytest;

import autointerface.demo.tools.ExcelUnit;
import autointerface.demo.tools.SleepUnit;
import autointerface.demo.tools.TestReport_original;
import autointerface.demo.tools.Tools;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
@Listeners({TestReport_original.class})
public class MyExcelDemo extends AbstractTestNGSpringContextTests {

    private final static Logger LOG = LoggerFactory.getLogger(MyExcelDemo.class);
    private String url = "http://www.lianchengjiang.com:8799/mock/api/cy/coupon/cancel";


    @BeforeClass
    public void beforeClass() {
        LOG.info("==== LogInTest star ====");
    }

    @AfterClass
    public void afterClass() {
        LOG.info("==== LogInTest end ====");
    }

    @DataProvider(name = "ExcelDemo")
    public static Object[][] data() throws IOException {
        System.out.println(System.getProperty("user.dir"));
//        String FilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\excel.mytest";
        String FilePath = System.getProperty("user.dir") + "/classes/excel.mytest";
        String FileName = "exceldemo.xlsx";
        String sheetName = "testData";
        return ExcelUnit.getExcelData(FilePath, FileName, sheetName);
    }

    @Test(dataProvider = "ExcelDemo", description = "Mock接口")
    public void mockDataByExcelTest(String id, String channel, String merchantId, String sign,String seqNo,String cardNo,
                                 String productCode,String mobile, String msg) throws IOException, InterruptedException {
        LOG.info("id :" + id + " channel : " + channel + " merchantId : " + merchantId + " sign : " + sign +
                "seqNo :" + seqNo + " cardNo : " + cardNo + " productCode : " + productCode + " mobile : " + mobile +
                "msg :"+ msg);

        //构造json
        JSONObject innerJson = new JSONObject();
        innerJson.put("channel", channel);
        innerJson.put("merchantId", merchantId);
        innerJson.put("sign", sign);
        JSONObject outterJson = new JSONObject();
        outterJson.put("head", innerJson);
        outterJson.put("seqNo", seqNo);
        outterJson.put("cardNo", cardNo);
        outterJson.put("productCode", productCode);
        JSONObject ownerJson = new JSONObject();
        ownerJson.put("mobile", mobile);
        outterJson.put("owner", ownerJson);
        LOG.info("outterjson---");
        LOG.info(JSON.toJSONString(outterJson, SerializerFeature.PrettyFormat, SerializerFeature.SortField));

        String markMsg = Tools.getMsg(url, outterJson);
        Assert.assertEquals(markMsg, msg);
        LOG.info("******* id =" + id + " 执行完成 ******");
        LOG.info("******* msg =" + msg + " 符合预期结果 ******");
        // 休眠
        int s = 3;
        SleepUnit.sleep(s);
    }
}
