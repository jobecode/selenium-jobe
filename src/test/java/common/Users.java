package common;

public enum Users {

    LEEROY_JENKINS("Leeroy Jenkins", "VIZ10AWT8VL");

    private final String userName;
    private final String password;

    Users(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }



}
