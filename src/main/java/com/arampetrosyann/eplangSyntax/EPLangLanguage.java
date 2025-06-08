package com.arampetrosyann.eplangSyntax;

import com.intellij.lang.Language;

public class EPLangLanguage extends Language {
    public static final EPLangLanguage INSTANCE = new EPLangLanguage();

    private EPLangLanguage() {
        super("EPLang");
    }
}
