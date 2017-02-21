package util;

import java.io.Serializable;

/**
 * Created by raychen on 2017/1/1.
 */
public class Statistic implements Serializable {
    private String login;
    private String visitor;

    public String getLogin() {
        return login;
    }

    public String getVisitor() {
        return visitor;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setVisitor(String visitor) {
        this.visitor = visitor;
    }
}
