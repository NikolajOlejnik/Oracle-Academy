package ua.oracleacademy.fp.domain.users;

public class Admin extends User {

    private long id;
    private String name;
    private String login;
    private String password;
    private boolean enabled;
    private String about;

    public Admin() {
    }

    public Admin(long user_id, String name, String login, String password, boolean enabled, String about) {
    }

    public Admin(long user_id, String name, String login, String password, boolean enabled) {
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String getAbout() {
        return about;
    }

    @Override
    public String toString() {
        return "Admin["
                + " id: " + this.id
                + ", login: " + this.login
                + ", name: " + this.name
                + ", password: " + this.password
                + ", enabled: " + this.enabled
                + " ]";
    }


}
