package com.lzt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
public class ResponseVo {

    private String mesg = "success";

    private Object data;

    private String code = "000000";


    public String getMesg() {
        return mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String toString(){
        return JSON.toJSONString(this, SerializerFeature.WriteMapNullValue);
    }


}
