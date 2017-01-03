package tag;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
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
        ServletContext context = pageContext.getServletContext();
        HttpSession session = pageContext.getSession();
        if (session == null || (session.getAttribute("user_id") == null && session.getAttribute("visitor") == null)){
            try {
                context.getRequestDispatcher("/jsp/Login.jsp").forward(pageContext.getRequest(), pageContext.getResponse());
                return SKIP_PAGE;
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.doEndTag();
    }
}
