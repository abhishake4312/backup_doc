package filter;


import jakarta.servlet.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.util.logging.Logger;

public class AuthoritiesLogAfterFilter implements Filter {

    private final Logger LOG = Logger.getLogger(AuthoritiesLogAfterFilter.class.getName());
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null){
            LOG.info("user:"+authentication.getName()+" has logged in with authorites"+authentication.getAuthorities().toString());
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
