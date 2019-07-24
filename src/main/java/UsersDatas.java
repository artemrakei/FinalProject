public class UsersDatas {
Builder builder =  new Builder();

        public static class Builder {
            private int id;
            private String login;
            private String password;

            public Builder setId (int val) {
                id=val;
                return this;
            }
            public Builder setLogin (String val) {
                login=val;
                return this;
            }
            public Builder setPassword (String val) {
                password=val;
                return this;
            }
            public int getId () {
                return id;
            }
            public String getLogin () {
                return login;
            }
            public String getPassword () {
                return password;
            }
        }

    @Override
    public String toString() {
        return "UsersDatas=" + builder.id + " Login=" + builder.login + " Password=" + builder.password;
    }

}
