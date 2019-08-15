package autointerface.demo.tools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Tools {
    public final static Logger LOG = LoggerFactory.getLogger(Tools.class);

    public static String getCode(String url, JSONObject jsonObject) throws IOException {
        String result = NetWorkUnit.netWorkRequest(url, jsonObject);
        JSONObject compJson = JSON.parseObject(result);
        LOG.info("PrettFormt -->" + JSON.toJSONString(compJson, SerializerFeature.PrettyFormat, SerializerFeature.SortField));
        String markcode = compJson.getString("code");
        return markcode;
    }

    public static String getMsg(String url, JSONObject jsonObject) throws IOException {
        String result = NetWorkUnit.netWorkRequest(url, jsonObject);
        JSONObject compJson = JSON.parseObject(result);
        LOG.info("PrettFormt -->" + JSON.toJSONString(compJson, SerializerFeature.PrettyFormat, SerializerFeature.SortField));
        String markMsg = compJson.getString("msg");
        return markMsg;
    }
}
