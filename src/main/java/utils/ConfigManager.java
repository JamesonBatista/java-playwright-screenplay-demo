package utils;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class ConfigManager {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigManager.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Arquivo config.properties não encontrado!");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar o arquivo config.properties", e);
        }
    }

    public static <T> T getProperty(String key) {
        String value = System.getProperty(key);  // Verifica se a propriedade foi passada pelo terminal
        if (value == null) {
            value = properties.getProperty(key);  // Se não, lê do config.properties
        }
        if (value == null) {
            throw new IllegalArgumentException("Property " + key + " not found");
        }

        if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
            return (T) Boolean.valueOf(value);
        } else if (value.matches("-?\\d+")) {
            return (T) Integer.valueOf(value);
        } else if (value.matches("-?\\d*\\.\\d+")) {
            return (T) Double.valueOf(value);
        } else {
            return (T) value;
        }
    }


    public static String getCurrentDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy--HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        return now.format(formatter);
    }
}
