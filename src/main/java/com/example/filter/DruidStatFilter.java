package com.example.filter;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * 本类的配置等价于在web.xml里配置
 * <filter>
 *      <filter-name>druidWebStatFilter</filter-name>
 *      <filter-class>com.alibaba.druid.support.http.WebStatFilter</filter-class>
 *      <init-param>
 *          <param-name>exclusions</param-name>
 *          <param-value>*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*</param-value>
 *      </init-param>
 * </filter>
 * <filter-mapping>
 *      <filter-name>druidWebStatFilter</filter-name>
 *      <url-pattern>/*</url-pattern>
 * </filter-mapping>
 */
@WebFilter(filterName = "druidWebStatFilter",urlPatterns = "/*",
        initParams = {
            @WebInitParam(name = "exclusions",value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*") //忽略过滤资源
        }
)
public class DruidStatFilter extends WebStatFilter{

}
