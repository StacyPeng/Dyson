package team11.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import team11.domian.Result;
import team11.exception.BussinessException;
import team11.exception.SystemException;

/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException systemException){
        //record log
        //send message to operation and maintenance staff
        //send email to development staff
        return new Result(systemException.getCode(),null, systemException.getMessage());
    }

    @ExceptionHandler(BussinessException.class)
    public Result doBussinessException(BussinessException bussinessException){
        return new Result(bussinessException.getCode(),null, bussinessException.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result doException(Exception exception){
        //record log
        //send message to operation and maintenance staff
        //send email to development staff
        return new Result(Code.SYSTEM_UNKNOW_ERR,null,"System is busy,please try again later!");
    }
}
