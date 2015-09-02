package com.future.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author shuaiqi.xsq, 15/9/1
 */
public class LoginAction extends BaseAction {
    private static final Logger logger = LoggerFactory.getLogger(LoginAction.class);

    public String execute(){
        try {
            request.setCharacterEncoding("utf-8");
            String userName = request.getParameter("name");
            String password = request.getParameter("password");

            String loginResult = this.sendPost("http://bbs.byws.org/login/checkLoginInfo.php", "name=" + userName + "&password=" + password);
            logger.info("login result:" + loginResult);

            if (loginResult.contains("wrong")){
                return ERROR;
            } else {
                // create the seesion
                request.getSession().setAttribute("userName", userName);
                return SUCCESS;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return ERROR;
    }

    private String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
}
