package com.healthcare.doctor_onboarding.service.Exception;

public class DoctorException extends RuntimeException{

    public DoctorException() {
    }

    public DoctorException(String message) {
        super(message);
    }

    public DoctorException(String message, Throwable cause) {
        super(message, cause);
    }

    public DoctorException(Throwable cause) {
        super(cause);
    }
}
