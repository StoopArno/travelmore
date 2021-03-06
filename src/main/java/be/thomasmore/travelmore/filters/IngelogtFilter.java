package be.thomasmore.travelmore.filters;

import be.thomasmore.travelmore.controller.GebruikerController;
import be.thomasmore.travelmore.controller.ViewController;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "IngelogtFilter")
public class IngelogtFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;
        GebruikerController user =  (GebruikerController)request.getSession().getAttribute("GebruikerController");
        ViewController view =  (ViewController)request.getSession().getAttribute("ViewController");
        if(!user.getAangemeld()){ //If user is already authenticated
            response.sendRedirect("/travelmore/bezoeker/login.xhtml");
        }else{
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
