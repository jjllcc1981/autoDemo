package autointerface.demo.tools;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class NetWorkUnit {
    private static final Logger LOG = LoggerFactory.getLogger(NetWorkUnit.class);

    // 请求接口获取到结果
    public static String netWorkRequest(String url, JSONObject paramJson) throws IOException {
        LOG.debug("######## url :"+url);
        LOG.debug("######## paramJson :"+paramJson);

        //声明一个client对象，用来执行
        DefaultHttpClient client = new DefaultHttpClient();
        //post方法
        HttpPost post = new HttpPost(url);
        //设置请求头信息 header
        post.setHeader("content-type", "application/json");
        //参数信息放入方法中
        StringEntity entity = new StringEntity(paramJson.toString(), "utf-8");
        post.setEntity(entity);
        //声明对象存储返回结果
        HttpResponse response = client.execute(post);
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);
        return result;
    }
}
