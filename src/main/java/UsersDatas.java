public class UsersDatas {


    private int id;
    private String login;
    private String password;

    public UsersDatas setId(int val) {
        id = val;
        return this;
    }

    public UsersDatas setLogin(String val) {
        login = val;
        return this;
    }

    public UsersDatas setPassword(String val) {
        password = val;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
