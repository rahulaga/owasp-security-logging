package org.owasp.security.logging.mdc;

import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.MDC;

/**
 * This is an example MDC plugin that gets a username from the HTTP session and 
 * places it in the MDC context for access by the logging system. 
 * 
 * @author August Detlefsen <augustd@codemagi.com>
 */
public class UsernamePlugin implements IPlugin {

    public void init(FilterConfig config) {
    }
    
    public void execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        System.out.println("username: " + username);
            if (username != null) {
                MDC.put(MDCFilter.LOGIN_ID, username);
            }
    }
    
}