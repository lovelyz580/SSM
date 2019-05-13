/*
 * TOP SECRET Copyright 2006-2015 Transsion.com All right reserved. This software is the confidential and proprietary
 * information of Transsion.com ("Confidential Information"). You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement you entered into with Transsion.com.
 */
package com.code.vo;

import com.alibaba.fastjson.JSON;

/**
 * ClassName:Result <br/>
 * Date: 2018年10月21日 下午12:55:29 <br/>
 * 
 * @author fenglibin1982@163.com
 * @Blog http://blog.csdn.net/fenglibing
 * @version
 * @see
 */
public class Result<T> {

    private int    code;
    private String desc;
    private T      data;

    public static <T> Result<T> success(T data) {
        Result<T> rtn = new Result<T>();
        rtn.setCode(200);
        rtn.setData(data);
        return rtn;
    }

    public static <T> Result<T> fail(String desc) {
        return fail(desc, null);
    }

    public static <T> Result<T> fail(String desc, T data) {
        Result<T> rtn = new Result<T>();
        rtn.setCode(500);
        rtn.setDesc(desc);
        rtn.setData(data);
        return rtn;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return JSON.toJSONString(this);
    }

}
