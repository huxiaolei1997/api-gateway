//package com.imooc.apigateway.filter;
//
//import com.imooc.apigateway.utils.CookieUtil;
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//
//import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
//import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
//
///**
// * 权限拦截
// */
//@Component
//public class AuthBuyerFilter extends ZuulFilter {
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//    @Override
//    public String filterType() {
//        return PRE_TYPE;
//    }
//
//    @Override
//    public int filterOrder() {
//        return PRE_DECORATION_FILTER_ORDER - 1;
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        RequestContext requestContext = RequestContext.getCurrentContext();
//
//        HttpServletRequest request = requestContext.getRequest();
//
//        // 是否应该开启过滤
//        if ("/order/order/create".equals(request.getRequestURI())) {
//            return true;
//        }
//
//        return false;
//    }
//
//    @Override
//    public Object run() {
//        RequestContext requestContext = RequestContext.getCurrentContext();
//
//        HttpServletRequest request = requestContext.getRequest();
//
//
//        /**
//         * /order/crete  只能买家访问
//         * /order/finish 只能卖家访问
//         * /product/list 都可访问
//         */
//        // 这里从url参数里获取，也可以从cookie，header里获取
////        String token = request.getParameter("token");
////        if (StringUtils.isEmpty(token)) {
////            requestContext.setSendZuulResponse(false);
////            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
////        }
//
//        Cookie cookie = CookieUtil.get(request, "openid");
//
//        if (null == cookie || StringUtils.isEmpty(cookie.getValue())) {
//            requestContext.setSendZuulResponse(false);
//            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
//        }
//
//        return null;
//    }
//}
