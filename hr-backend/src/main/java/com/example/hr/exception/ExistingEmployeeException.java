package com.example.hr.exception;

@SuppressWarnings("serial")
public class ExistingEmployeeException extends BaseException {
    public ExistingEmployeeException(String reason,
                            String i18nId,
                            String debugId) {
        super(reason,i18nId,debugId);
    }
}
