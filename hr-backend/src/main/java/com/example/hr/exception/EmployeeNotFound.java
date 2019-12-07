package com.example.hr.exception;

@SuppressWarnings("serial")
public class EmployeeNotFound extends BaseException {
    public EmployeeNotFound(String reason,
                            String i18nId,
                            String debugId) {
        super(reason,i18nId,debugId);
    }
}
