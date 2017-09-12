package com.yazuo.xiaoya.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * Token检查过滤器
 * Created by scvzerng on 2017/9/5.
 */
@Component
public class TokenFilter extends ZuulFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(TokenFilter.class);
    @Override
    public String filterType() {

        return PRE_TYPE;
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
        LOGGER.info(String.format("请求方法:%s,请求url:%s",request.getMethod(),request.getRequestURL().toString()));
        String token = request.getParameter("token");
        if(StringUtils.isEmpty(token)){
            LOGGER.warn("没有发现携带token");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.getResponse().setCharacterEncoding("utf-8");
            ctx.setResponseBody("没有发现token");
        }
        return null;
    }
}
