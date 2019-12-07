package com.example.hr.exception;

public class BaseException extends RuntimeException {
    private final String debugId;
    private final String i18nId;

    public BaseException(String reason, String i18nId, String debugId) {
        super(reason);
        this.debugId = debugId;
        this.i18nId = i18nId;
    }

    public String getDebugId() {
        return debugId;
    }

    public String getI18nId() {
        return i18nId;
    }
}
