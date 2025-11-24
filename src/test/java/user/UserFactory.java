package user;

import utils.PropertyReader;

public class UserFactory {
    public static User withAdminPermission() {
        return new User(PropertyReader.getProperty("swaglabs.user"),
                PropertyReader.getProperty("swaglabs.password"));
    }

    public static User withLockedUserPermission() {
        return new User(PropertyReader.getProperty("swaglabs.locked.user"),
                PropertyReader.getProperty("swaglabs.password"));
    }

    public static User withInvalidPasswordUser() {
        return new User(PropertyReader.getProperty("swaglabs.user"),
                PropertyReader.getProperty("swaglabs.invalid.password"));
    }

    public static User withEmptyPasswordUser() {
        return new User(PropertyReader.getProperty("swaglabs.user"),
                PropertyReader.getProperty("swaglabs.empty.password"));
    }

    public static User withEmptyEmailUser() {
        return new User(PropertyReader.getProperty("swaglabs.empty.email"),
                PropertyReader.getProperty("swaglabs.password"));
    }

    public static User withEmptyFieldsUser() {
        return new User(PropertyReader.getProperty("swaglabs.empty.email"),
                PropertyReader.getProperty("swaglabs.empty.password"));
    }

    public static User withInvalidFieldsUser() {
        return new User(PropertyReader.getProperty("swaglabs.locked.user"),
                PropertyReader.getProperty("swaglabs.invalid.password"));
    }
}
