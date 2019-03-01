package factory;

import libs.Config;
import models.User;

public class ModelsFactory {

    private static Config config = ConfigFactory.getConfig();
    private static User user;

    public static User getUser() {
        if (user == null) {
            user = new User(config.validEmail, config.userName, config.userGender);
        }
        return user;
    }
}
