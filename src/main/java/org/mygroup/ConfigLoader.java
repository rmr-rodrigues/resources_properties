package org.mygroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final Logger logger = LoggerFactory.getLogger(ConfigLoader.class);
    private final Properties properties = new Properties();

    public ConfigLoader(String environment) {
        String filename = "config-" + environment + ".properties";
        logger.info("Loading configuration from: {}", filename);

        try (InputStream input = getClass().getClassLoader().getResourceAsStream(filename)) {
            if (input == null) {
                logger.error("Configuration file not found: {}", filename);
                throw new RuntimeException("Configuration file not found: " + filename);
            }
            properties.load(input);
            logger.info("Configuration successfully loaded for environment: {}", environment);
        } catch (IOException e) {
            logger.error("Error loading configuration file: {}", filename, e);
            throw new RuntimeException("Error loading configuration file", e);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
