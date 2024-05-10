package team11.Dyson.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
* @author: Dechun Meng
*/
@Data //Field generation get and set methods
@AllArgsConstructor
public class ResultVo<T> {
    private String msg;
    private int code;
    private T data;
}
