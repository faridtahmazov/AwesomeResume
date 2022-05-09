package filter;

import com.sun.net.httpserver.HttpExchange;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "JspFilter", urlPatterns = {"*.jsp"})
public class JspFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter is init!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res= (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        try {
            res.sendRedirect(req.getContextPath() + "/error");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void destroy() {
        System.out.println("Filter is init!");
    }
}

