package com.imokhonko.controller;

import com.imokhonko.model.exceptions.NoSuchLanguageException;
import org.apache.log4j.Logger;

import java.util.Locale;

import static com.imokhonko.model.util.ClassNameUtil.getCurrentClassName;

public class ChangeLanguage extends Controller {

    private static final Logger logger = Logger.getLogger(getCurrentClassName());

    private Language language;
    private Locale currentLocale = Locale.getDefault();

    public ChangeLanguage(Language language) {
        this.language = language;
    }

    @Override
    public void processRequest() {
        changeLocale(language);
        logger.trace("forwarding to settings menu");
        new SettingsMenu().processRequest();
    }

    private void changeLocale(Language language) {
        logger.trace("trying to change locale to " + language);
        switch(language) {
            case ENGLISH: {
                currentLocale = new Locale("en", "UK");
                Locale.setDefault(currentLocale);
            } break;
            case RUSSIAN: {
                currentLocale = new Locale("ru", "RU");
                Locale.setDefault(currentLocale);
            } break;
            case UKRAINIAN: {
                currentLocale = new Locale("ua", "UA");
                Locale.setDefault(currentLocale);
            } break;
            default: {
                try {
                    throw new NoSuchLanguageException("language is not exist");
                } catch(NoSuchLanguageException e) {
                    logger.warn("languge is not exist ", e);
                }
            }
        }
        logger.trace("locale changed successfully to " + language);
    }

    public enum Language {
        ENGLISH,
        RUSSIAN,
        UKRAINIAN;
    }

}
