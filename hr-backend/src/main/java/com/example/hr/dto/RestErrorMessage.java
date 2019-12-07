package com.example.hr.dto;

public class RestErrorMessage {
    private String msg;
    private String debug;
    private String msgid;

    public RestErrorMessage(String msg, String debug, String msgid) {
        this.msg = msg;
        this.debug = debug;
        this.msgid = msgid;
    }

    public String getMsg() {
        return msg;
    }

    public String getDebug() {
        return debug;
    }

    public String getMsgid() {
        return msgid;
    }
}
