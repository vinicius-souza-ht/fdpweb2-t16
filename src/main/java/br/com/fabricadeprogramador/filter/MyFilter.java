package br.com.fabricadeprogramador.filter;

import br.com.fabricadeprogramador.utils.TokenUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(dispatcherTypes = DispatcherType.REQUEST, urlPatterns = {"/protected/*" },asyncSupported = true)
public class MyFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Expose-Headers", "Authentication");

        if (request.getMethod().equals("OPTIONS")) {
            filterChain.doFilter(request, response);
        } else {
            String jwt = request.getHeader("Authentication");

            if (TokenUtils.validarToken(jwt)){
                filterChain.doFilter(request, response);
            } else {
                response.setStatus(401);
            }
        }



    }

    @Override
    public void destroy() {

    }
}
