package autointerface.demo.tools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class TokenUnit {
    private final static Logger LOG = LoggerFactory.getLogger(TokenUnit.class);

    // 直接使用用户名密码回去到token
    public static String getToken(String name, String pwd) throws IOException {
        String url = "http://test-m-stg.ppppoints.com/trfood/provider-api/user/login";
        JSONObject headparam = new JSONObject();
        headparam.put("channel", "");
        headparam.put("clientId", "");
        headparam.put("token", "");
        headparam.put("userId", "");
        JSONObject myparam = new JSONObject();
        myparam.put("head", headparam);
        myparam.put("account", name);
        myparam.put("password", pwd);
        LOG.debug("myparam --> " + myparam);
        //声明一个client对象，用来进行方法执行
        DefaultHttpClient client = new DefaultHttpClient();
        //声明一个方法，方法使用post
        HttpPost post = new HttpPost(url);
        //设置请求头信息 设置header
        post.setHeader("content-type", "application/json");
        //参数信息放入方法中
        StringEntity entity = new StringEntity(myparam.toString(), "utf-8");
        post.setEntity(entity);
        //声明对象来进行相应结果存储
        String result;
        HttpResponse response = client.execute(post);

        result = EntityUtils.toString(response.getEntity(), "utf-8");
        LOG.debug("result --> " + result);
        JSONObject getresultjson = JSONObject.parseObject(result);
        LOG.debug(JSON.toJSONString(getresultjson, SerializerFeature.PrettyFormat, SerializerFeature.SortField));
        String token = JSONObject.parseObject(getresultjson.getString("head")).getString("token");
        return token;
    }
}
