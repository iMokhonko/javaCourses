package com.imokhonko.controller;


import com.imokhonko.exceptions.NoSuchLanguageException;

public class LanguageController {

    public static void changeLanguage(Languages language) throws NoSuchLanguageException {
        switch(language) {
            case ENGLISH: {

            } break;
            case RUSSIAN: {

            } break;
            case UKRAINIAN: {

            } break;
            default: {
                throw new NoSuchLanguageException("No such language exception");
            }
        }

    }

    public enum Languages {
        ENGLISH,
        RUSSIAN,
        UKRAINIAN;
    }

}
