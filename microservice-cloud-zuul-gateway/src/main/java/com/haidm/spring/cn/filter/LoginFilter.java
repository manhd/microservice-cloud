package com.haidm.spring.cn.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName LoginFilter
 * @Description TODO
 * @Author sh-manhd
 * @Date 2019/6/3 15:52
 * @Version 1.0
 **/
@Component  //将过滤器加载到容器中
public class LoginFilter extends ZuulFilter {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     *@Author manhd
     *@Description pre:在请求路由之前执行
     * route:在请求路由时调用
     * post : 请求路由之后调用，在route  和 error 过滤器之后调用
     * error : 在处理请求错误时调用
     *@Date 2019/6/3 15:55
     *@Param
     *@Return
    **/
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1; //此方法返回整数型数值，通过此数值来定义过滤器的执行顺序，数字越小优先级越高
    }

    @Override
    public boolean shouldFilter() {
        return true;  //当前过滤器是否执行， true 执行，false 不执行
    }

    @Override
    public Object run() throws ZuulException {

        //获取请求上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        //获取请求参数
        String token = request.getParameter("token");
        //如果请求带了token 值，则表示登录过
        if(StringUtils.isBlank(token)){
            logger.warn("此操作需要先登录系统");
            //没有登录过，则不进行路由转发
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(200); //相应状态码
            try {
                currentContext.getResponse().getWriter().write("token is empty...");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        logger.info("登录验证通过");
        //通过会进行路由转发
        return null;
    }
}
