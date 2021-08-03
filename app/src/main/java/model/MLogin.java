package model;

import valueObject.VLogin;

public class MLogin {

    private String userId;
    private String password;

    public MLogin(VLogin vLogin) {

        this.userId = vLogin.getUserId();
        this.password = vLogin.getPassword();
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

}
