package websiteBase;

public class TestData {
    private static UserDTO user;

    public static void setUser(UserDTO user) {
        TestData.user = user;
    }

    public static UserDTO getUser() {
        return user;
    }
}
