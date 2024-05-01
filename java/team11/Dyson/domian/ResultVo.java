package team11.Dyson.domian;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
* @author: Dechun Meng
*/
@Data //字段生成get和set方法
@AllArgsConstructor
public class ResultVo<T> {
    private String msg;
    private int code;
    private T data;
}
