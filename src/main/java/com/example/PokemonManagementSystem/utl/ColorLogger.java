package com.example.PokemonManagementSystem.utl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ColorLogger {

    private static final Logger logger = LoggerFactory.getLogger(ColorLogger.class);

    // ANSI escape codes for colors
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_BLUE = "\u001B[34m";

    public static void logInfo(String message) {
        logger.info(ANSI_GREEN + message + ANSI_RESET);
    }

    public static void logWarning(String message) {
        logger.warn(ANSI_YELLOW + message + ANSI_RESET);
    }

    public static void logError(String message) {
        logger.error(ANSI_RED + message + ANSI_RESET);
    }

    public static void logDebug(String message) {
        logger.debug(ANSI_BLUE + message + ANSI_RESET);
    }
}