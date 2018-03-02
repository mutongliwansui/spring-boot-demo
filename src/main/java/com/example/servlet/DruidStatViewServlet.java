package com.example.servlet;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * 本类配置等价于在web.xml如下配置
 * <servlet>
 *      <servlet-name>DruidStatView</servlet-name>
 *      <servlet-class>com.alibaba.druid.support.http.StatViewServlet</servlet-class>
 *      <init-param>
 *          <param-name>allow</param-name>
 *          <param-value>127.0.0.1</param-value>
 *      </init-param>
 *      <init-param>
 *          <param-name>deny</param-name>
 *          <param-value>192.168.3.213</param-value>
 *      </init-param>
 *      <init-param>
 *          <param-name>loginUsername</param-name>
 *          <param-value>admin</param-value>
 *      </init-param>
 *      <init-param>
 *          <param-name>loginPassword</param-name>
 *          <param-value>ly520101</param-value>
 *      </init-param>
 *      <init-param>
 *          <param-name>resetEnable</param-name>
 *          <param-value>false</param-value>
 *      </init-param>
 * </servlet>
 * <servlet-mapping>
 *      <servlet-name>DruidStatView</servlet-name>
 *      <url-pattern>/druid/*</url-pattern>
 * </servlet-mapping>
 */
@WebServlet(urlPatterns = "/druid/*",
        initParams = {
            @WebInitParam(name = "allow",value = "127.0.0.1"), // IP白名单(没有配置或者为空，则允许所有访问)
            @WebInitParam(name = "deny",value = "192.168.3.213"), // IP黑名单 (存在共同时，deny优先于allow)
            @WebInitParam(name = "loginUsername",value = "admin"), // 用户名
            @WebInitParam(name = "loginPassword",value = "ly520101"), // 密码
            @WebInitParam(name = "resetEnable",value = "false") // 禁用HTML页面上的“Reset All”功能
        }
)
public class DruidStatViewServlet extends StatViewServlet {

}
