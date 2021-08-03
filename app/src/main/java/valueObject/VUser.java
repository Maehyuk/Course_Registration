package valueObject;

public class VUser {
    private String name;
    private String userId;
    private String password;
    private String number;


    public VUser(String name, String userId, String password, String number) {
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.number = number;
    }


    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getNumber() {
        return number;
    }
}
