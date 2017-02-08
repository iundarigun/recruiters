package br.com.devcave.recruiters.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;
import java.util.ResourceBundle;

public abstract class BaseController {
    protected final static String ERROR_MESSAGES = "ERROR_MESSAGES";
    protected final static String SUCCESS_MESSAGE = "SUCCESS_MESSAGE";

    @Autowired
    protected MessageSource messages;

    protected String getMessage(String code, Object... arguments){
        Locale locale = LocaleContextHolder.getLocale();
        return messages.getMessage(code, arguments, locale);
    }

}
