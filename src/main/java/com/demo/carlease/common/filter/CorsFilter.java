package com.demo.carlease.common.filter;

import org.springframework.http.HttpHeaders;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * 跨域请求过滤器
 *
 * @author 李嘉明
 * create time 2021/12/22
 */
public class CorsFilter extends OncePerRequestFilter {

    private static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
    private static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
    private static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";

    private String[] accessControlAllowHeaders;
    private String[] accessControlAllowMethods;
    private String[] accessControlAllowOrigins;

    public CorsFilter(String[] accessControlAllowHeaders, String[] accessControlAllowMethods, String[] accessControlAllowOrigins) {
        this.accessControlAllowHeaders = accessControlAllowHeaders.clone();
        this.accessControlAllowMethods = accessControlAllowMethods.clone();
        this.accessControlAllowOrigins = accessControlAllowOrigins.clone();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        String originHeader = request.getHeader(HttpHeaders.ORIGIN);

        if (originHeader != null && !"".equals(originHeader)) {
            if (Arrays.asList(accessControlAllowOrigins).contains(originHeader)) {
                response.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, originHeader);
            } else {
                for (String accessControlAllowOrigin : accessControlAllowOrigins) {
                    response.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, accessControlAllowOrigin);
                }
            }
        }

        for (String accessControlAllowHeader : accessControlAllowHeaders) {
            response.setHeader(ACCESS_CONTROL_ALLOW_HEADERS, accessControlAllowHeader);
        }

        for (String accessControlAllowMethod : accessControlAllowMethods) {
            response.setHeader(ACCESS_CONTROL_ALLOW_METHODS, accessControlAllowMethod);
        }

        filterChain.doFilter(request, response);
    }
}
