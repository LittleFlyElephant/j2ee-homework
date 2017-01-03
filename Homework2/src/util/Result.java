package util;

/**
 * Created by raychen on 2016/12/20.
 */
public class Result {
    public String message;
    public MessageState state;
    public Object value;

    public Result(String msg, MessageState state, Object value){
        this.message = msg;
        this.state = state;
        this.value = value;
    }
}
