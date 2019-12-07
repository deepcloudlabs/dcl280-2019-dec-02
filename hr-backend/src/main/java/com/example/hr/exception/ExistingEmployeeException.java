package com.example.hr.exception;

public class ExistingEmployeeException extends BaseException {
    public ExistingEmployeeException(String reason,
                            String i18nId,
                            String debugId) {
        super(reason,i18nId,debugId);
    }
}
