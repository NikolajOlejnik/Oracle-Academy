package ua.oracleacademy.fp.domain.users;

import java.io.Serializable;

public abstract class User implements Serializable{

    private long    id;
    private String  name;
    private String  login;
    private String  password;
    private boolean enabled;
    private String  about;

    public User() {
    }

    public abstract long getId();

    public abstract void setId(long id);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract String getLogin();

    public abstract void setLogin(String login);

    public abstract String getPassword();

    public abstract void setPassword(String password);

    public abstract boolean isEnabled();

    public abstract void setEnabled(boolean enabled);

    public abstract String getAbout();

    public abstract void setAbout(String about);
}
