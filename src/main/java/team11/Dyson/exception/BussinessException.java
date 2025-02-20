package team11.Dyson.exception;


/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
public class BussinessException extends RuntimeException{

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
    public BussinessException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public BussinessException(Integer code,String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
