package com.imokhonko.controller;

import com.imokhonko.model.exceptions.NoSuchLanguageException;

import java.util.Locale;

public class ChangeLanguage extends Controller {

    private Language language;
    private Locale currentLocale = Locale.getDefault();

    public ChangeLanguage(Language language) {
        this.language = language;
    }

    @Override
    public void processRequest() {
        changeLocale(language);
        new SettingsMenu().processRequest();
    }

    private void changeLocale(Language language) {
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
                    // logger
                }
            }
        }
    }

    public enum Language {
        ENGLISH,
        RUSSIAN,
        UKRAINIAN;
    }

}
