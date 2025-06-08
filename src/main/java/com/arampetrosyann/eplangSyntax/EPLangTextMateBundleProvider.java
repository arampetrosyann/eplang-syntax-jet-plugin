package com.arampetrosyann.eplangSyntax;

import com.intellij.openapi.application.PathManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.plugins.textmate.api.TextMateBundleProvider;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.*;
import java.util.*;

public class EPLangTextMateBundleProvider implements TextMateBundleProvider {
    @Override
    public @NotNull List<PluginBundle> getBundles() {
        try {
            Path tmp = Files.createTempDirectory(
                    Paths.get(PathManager.getTempPath()), "textmate"
            );

            List<String> filesToCopy = Arrays.asList(
                    "package.json",
                    "language-configuration.json",
                    "syntaxes/eplang.tmLanguage.json",
                    "images/epl_logo.png"
            );

            ClassLoader classLoader = EPLangTextMateBundleProvider.class.getClassLoader();

            for (String fileToCopy : filesToCopy) {
                URL resource = classLoader.getResource("tm/" + fileToCopy);
                if (resource == null) {
                    throw new IOException("Resource not found: " + fileToCopy);
                }

                try (InputStream resourceStream = resource.openStream()) {
                    Path target = tmp.resolve(fileToCopy);
                    Files.createDirectories(target.getParent());
                    Files.copy(resourceStream, target, StandardCopyOption.REPLACE_EXISTING);
                }
            }

            PluginBundle bundle = new PluginBundle("EPLang", Objects.requireNonNull(tmp));
            return Collections.singletonList(bundle);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load TextMate bundle", e);
        }
    }
}
