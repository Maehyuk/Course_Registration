package valueObject;

public class VLogin {

    private String name;
    private String userId;
    private String password;
    private String number;


    public VLogin(String userId, String password) {
        this.userId = userId;
        this.password = password;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }
}
