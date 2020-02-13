package com.shiro.boot.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * ClassName: ResultMap
 * Description:
 * date: 2020/2/13 16:55
 *
 * @author xujin <br/>
 * @since JDK 1.8
 */
@Component
public class ResultMap extends HashMap<String, Object> {
    public ResultMap() {
    }

    public ResultMap success() {
        this.put("result", "success");
        return this;
    }

    public ResultMap fail() {
        this.put("result", "fail");
        return this;
    }

    public ResultMap message(Object message) {
        this.put("message", message);
        return this;
    }
}
