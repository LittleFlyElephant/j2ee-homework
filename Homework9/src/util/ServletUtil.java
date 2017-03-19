package util;

import javax.servlet.ServletContext;

/**
 * Created by raychen on 2016/12/22.
 */
public class ServletUtil {
    public static void addContext(ServletContext context, String attr){
        int count = Integer.parseInt((String)context.getAttribute(attr));
        count ++;
        context.setAttribute(attr, Integer.toString(count));
    }
    public static void decContext(ServletContext context, String attr){
        int count = Integer.parseInt((String)context.getAttribute(attr));
        count --;
        context.setAttribute(attr, Integer.toString(count));
    }
}
