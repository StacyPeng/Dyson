package team11.Dyson.domain;

/**
 * @Author: Chengyu Peng
 * @Date: 2024/5/6 下午2:33
 * @student ID:230045675
 */
public class UserResult {
    private Object data;
    private Integer code;
    private String message;
    private String identity;


    public UserResult() {
    }

    public UserResult(Integer code,Object data) {
        this.data = data;
        this.code = code;
    }

    public UserResult(Integer code, Object data, String message, String identity) {
        this.data = data;
        this.code = code;
        this.message = message;
        this.identity = identity;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String toString() {
        return "UserResult{data = " + data + ", code = " + code + ", message = " + message + ", identity = " + identity + "}";
    }
}
