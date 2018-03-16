package com.bizideal.mn.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : liulq
 * @date: 创建时间: 2018/3/7 9:59
 * @version: 1.0
 * @Description: spring cloud网关 zuul 权限拦截过滤器
 */
@Component
public class AccessFilter extends ZuulFilter {

    private static final Logger log = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        // pre表示前置过滤
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            log.warn("access token is empty");
            // 不进行路由
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("未知请求");
            return null;
        }
        log.info("access token ok");
        return null;
    }
}
