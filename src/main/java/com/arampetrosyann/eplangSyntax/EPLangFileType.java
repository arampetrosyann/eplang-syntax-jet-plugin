package com.arampetrosyann.eplangSyntax;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class EPLangFileType extends LanguageFileType {
    public static final EPLangFileType INSTANCE = new EPLangFileType();

    private EPLangFileType() {
        super(EPLangLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "EPLang";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "EPLang file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "eplang";
    }

    @Override
    public Icon getIcon() {
        return EPLangIcons.FILE;
    }
}