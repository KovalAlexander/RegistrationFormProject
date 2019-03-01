package factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import libs.Config;

import java.io.File;

public class ConfigFactory {

    private static Config config;

    public static Config getConfig() {
        if (config == null) {
            config = new Config();
            File configFile = new File("src/main/resources/Config.json");
            configFile = configFile.getAbsoluteFile();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                config = objectMapper.readValue(configFile, Config.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return config;
    }
}
