package tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

/**
 * Created by raychen on 2017/1/3.
 */
public class checkLogin extends BodyTagSupport {

    @Override
    public int doEndTag() throws JspException {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
        HttpSession session = pageContext.getSession();
        if (session == null || (session.getAttribute("user_id") == null)){
            try {
                if (request.getRequestURI().equals("/jsp/Home.jsp") && session.getAttribute("visitor") == null){
                    response.sendRedirect("/login");
                    return SKIP_PAGE;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                if (request.getRequestURI().equals("/jsp/Login.jsp")){
                    response.sendRedirect("/home");
                    return SKIP_PAGE;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.doEndTag();
    }
}
