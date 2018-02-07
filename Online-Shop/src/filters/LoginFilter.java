/**
 * 
 */
package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineshop.backingbeans.user.OnlineUser;

/**
 * @author Mahmoud
 *
 */
public class LoginFilter implements Filter{

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = (HttpSession)req.getSession(false);
		boolean isLoggedIn = false;
		
		if (session != null && session.getAttribute("onlineUser") != null && ((OnlineUser)session.getAttribute("onlineUser")).getUser()!= null){
			isLoggedIn = true;
		}
		

        if (req.getRequestURI().endsWith("/login.xhtml")) {
        	if (isLoggedIn){
        		HttpServletResponse res = (HttpServletResponse) response;
        		res.sendRedirect("index.xhtml");
        	} else {
        		chain.doFilter(request, response);
        	}
        } else {
        	if(isLoggedIn){
        		chain.doFilter(request, response);
        	}else{
        		HttpServletResponse res = (HttpServletResponse) response;
        		res.sendRedirect("login.xhtml");
            }
        }
		
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
