package autointerface.demo.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 *@data 2017年4月7日上午10:10:30
 *@auther liuyanghui
 *@desc:
 */
public class HttpUtils {
	

	private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);

	private static final String[][] jsonHeaders = { { "Content-Type", "application/json" } };

	public static String doJsonHeadersPost(String url, String body){
		return doPost(url, body, jsonHeaders, 3, 10, "utf-8");
	}

	/**
	 * ********************************************
	 * method name   : doPost 
	 * description   : Http协议Post方式请求
	 * @return       : String
	 * @param        : @param url
	 * @param        : @param body
	 * @param        : @param headers
	 * @param        : @param connectionTimeout
	 * @param        : @param readTimeout
	 * @param        : @param charset
	 * @param        : @return
	 * modified      : hejinyun@umpay.com ,  2016-11-7  下午3:28:02
	 * @see          : 
	 * *******************************************
	 */
	public static String doPost(String url, String body, String[][] headers,
			int connectionTimeout, int readTimeout, String charset){
		URL uri = null;
		HttpURLConnection urlConnection = null;
		try {
			log.info(String.format("post url [%s]", url));
			uri = new URL(url);
			urlConnection = (HttpURLConnection)uri.openConnection();
			urlConnection.setRequestMethod("POST");
			urlConnection.setConnectTimeout(1000 * connectionTimeout); // 连接超时时间
			urlConnection.setReadTimeout(1000 * readTimeout); // 响应超时时间
			urlConnection.setDoOutput(true);
			urlConnection.setDoInput(true);
			urlConnection.setUseCaches(false);
			
			if (null == headers){
				urlConnection.addRequestProperty("Content-Type", "application/json");
			} else {
				// 设置Http报文请求头
				for (String[] header : headers){
					urlConnection.addRequestProperty(header[0], header[1]);
				}
			}
			
			// 提交Http请求参数
			urlConnection.connect();
			if (null != body){
				urlConnection.getOutputStream().write(body.getBytes(charset));
				urlConnection.getOutputStream().flush();
				urlConnection.getOutputStream().close();
			}
			
			// 读取响应参数
			int responseCode = urlConnection.getResponseCode();
			if (HttpURLConnection.HTTP_OK == responseCode){
				InputStream is = urlConnection.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is, charset));
				StringBuffer response = new StringBuffer();
				String line = br.readLine();
				while (null != line){
					response.append(line);
					line = br.readLine();
				}
				br.close();
				is.close();
				return response.toString();
			} else {
				log.info("#doPost() 请求失败！"+responseCode);
			}
		} catch(Exception e){
			log.error("#doPost() 请求异常:"+e.toString(), e);
		} finally{
			if (null != urlConnection){
				urlConnection.disconnect();
			}
		}
		return null;
	}
	
	/**
	 * ********************************************
	 * method name   : doGet 
	 * description   : Http协议Get方式请求
	 * @return       : String
	 * @param        : @param url
	 * @param        : @param headers
	 * @param        : @param connectionTimeout
	 * @param        : @param readTimeout
	 * @param        : @param charset
	 * @param        : @return
	 * modified      : hejinyun@umpay.com ,  2016-11-7  下午3:28:18
	 * @see          : 
	 * *******************************************
	 */
	public static String doGet(String url, String[][] headers,
			int connectionTimeout, int readTimeout, String charset){
		URL uri = null;
		HttpURLConnection urlConnection = null;
		try {
			uri = new URL(url);
			urlConnection = (HttpURLConnection) uri.openConnection();
			urlConnection.setConnectTimeout(1000 * connectionTimeout);
			urlConnection.setReadTimeout(1000 * readTimeout);
			urlConnection.setDoInput(true);
			urlConnection.setDoOutput(true);
			urlConnection.setUseCaches(false);
//			for (String[] header : headers){
//				urlConnection.addRequestProperty(header[0], header[1]);
//			}
			urlConnection.connect();
			// 读取响应参数
			int responseCode = urlConnection.getResponseCode();
			if (HttpURLConnection.HTTP_OK == responseCode){
				InputStream is = urlConnection.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is, charset));
				StringBuffer response = new StringBuffer();
				String line = br.readLine();
				while (null != line){
					response.append(line);
					line = br.readLine();
				}
				br.close();
				is.close();
				return response.toString();
			} else {
				log.info("#doGet() 请求失败！"+responseCode);
			}
		} catch (Exception e){
			log.error("#doGet() 请求异常", e);
		} finally {
			if (null != urlConnection){
				urlConnection.disconnect();
			}
		}
		return null;
	}


	public static String doGet(String url){
		return doGet(url, null, 3, 10, "utf-8");
	}
}
