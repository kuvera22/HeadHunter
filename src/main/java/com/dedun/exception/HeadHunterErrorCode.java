package com.dedun.exception;

public enum  HeadHunterErrorCode {

    WORKER_EXIST("Worker already in data base"),
    WORKER_NOT_EXIST("Worker not exist"),
    EMPLOYER_EXIST("Employer already in DB"),
    EMPLOYER_NOT_EXIST("Employer not exist"),
    SUMMARY_NOT_EXIST("Summary not exist"),
    WORKER_EXIST_SUMMARY("Worker's summary exist");


    private String errorCode;

    HeadHunterErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
