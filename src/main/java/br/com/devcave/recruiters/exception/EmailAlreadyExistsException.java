package br.com.devcave.recruiters.exception;

public class EmailAlreadyExistsException extends RecruitersGenericException {

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
