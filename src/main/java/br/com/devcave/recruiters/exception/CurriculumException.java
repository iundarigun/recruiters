package br.com.devcave.recruiters.exception;

public class CurriculumException extends RecruitersGenericException {

    public CurriculumException() {
        super("Acontece um erro recuperando o arquivo importado");
    }
}
