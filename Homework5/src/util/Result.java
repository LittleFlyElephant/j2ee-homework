package util;

import java.io.Serializable;

/**
 * Created by raychen on 2016/12/20.
 */
public class Result implements Serializable{
    private String message;
    private MessageState state;
    private Object value;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setState(MessageState state) {
        this.state = state;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public MessageState getState() {
        return state;
    }

    public Object getValue() {
        return value;
    }
}
