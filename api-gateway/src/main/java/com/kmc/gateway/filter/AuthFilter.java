package com.kmc.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 武海升
 * @date 2018/10/31 15:34
 */
@Slf4j
public class AuthFilter extends ZuulFilter {

    final String AUTH_AUTHORIZE = "auth/authorize/getAccessToken";
    final String AUTH_PATH = "auth";

    @Override
    public String filterType() {
        // 可以在请求被路由之前调用
        return "pre";
    }

    @Override
    public int filterOrder() {
        // filter执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 是否执行该过滤器，此处为true，说明需要过滤
        return true;
    }

    @Override
    public Object run(){
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String requestMethodName = request.getRequestURI();
        if(requestMethodName.contains(AUTH_AUTHORIZE)){
            return successZuul(ctx);
        }else if(requestMethodName.contains(AUTH_PATH)){
            String token = request.getParameter("token");
            String sign = request.getParameter("sign");
            if (StringUtils.isNotBlank(token)  && StringUtils.isNotBlank(sign)) {
                return successZuul(ctx);
            }else {
                return errorZuul(ctx,"token or sign is empty");
            }
        }else {
            return successZuul(ctx);
        }

    }

    private String successZuul(RequestContext ctx){
        ctx.setSendZuulResponse(true);
        ctx.setResponseStatusCode(200);
        ctx.set("isSuccess", true);
        return null;
    }
    private String errorZuul(RequestContext ctx,String desc){
        ctx.setSendZuulResponse(false);
        ctx.setResponseStatusCode(400);
        ctx.setResponseBody(desc);
        ctx.set("isSuccess", false);
        return null;
    }

}
