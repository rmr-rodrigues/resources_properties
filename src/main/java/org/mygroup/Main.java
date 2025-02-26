package org.mygroup;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        String env = System.getProperty("env", "dev");
        logger.info("Starting application in '{}' environment", env);

        ConfigLoader configLoader = new ConfigLoader(env);
        final String DEFAULTTRANSMISSION_GB_MODELCODE_AUTOMATIC = configLoader.getProperty("DEFAULTTRANSMISSION_GB_MODELCODE_AUTOMATIC");

        logger.info("Base URL: {}", configLoader.getProperty("baseurl"));
        logger.info("Database URL: {}", DEFAULTTRANSMISSION_GB_MODELCODE_AUTOMATIC);
    }
}