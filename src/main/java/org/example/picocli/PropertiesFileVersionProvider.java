package org.example.picocli;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import picocli.CommandLine;

public class PropertiesFileVersionProvider implements CommandLine.IVersionProvider {
    private static final String PROPERTIES_FILE = "app.properties";
    private static final String VERSION_PROPERTY = "app.version";

    @Override public String[] getVersion() throws Exception {
        URL url = getClass().getResource("/" + PROPERTIES_FILE);
        if (url == null) {
            return new String[] { "No %s file found in the classpath".formatted(PROPERTIES_FILE) };
        }
        Properties properties = new Properties();
        try (InputStream is = url.openStream()) {
            properties.load(is);
            return new String[] { properties.getProperty(VERSION_PROPERTY) };
        }
    }
}
