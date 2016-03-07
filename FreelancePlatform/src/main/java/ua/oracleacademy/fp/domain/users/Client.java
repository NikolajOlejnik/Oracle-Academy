package ua.oracleacademy.fp.domain.users;

import ua.oracleacademy.fp.domain.tasks.Request;
import ua.oracleacademy.fp.domain.tasks.Task;

import java.util.Set;

public class Client extends User {

    private long id;
    private String name;
    private String login;
    private String password;
    private boolean enabled;

    private String about;

    private Set<Task> tasks;
    private Set<Request> requests;

    public Client() {
    }

    public Client(long id, String name, String login, String password, boolean enabled, String about, Set<Task> tasks, Set<Request> requests) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.enabled = enabled;
        this.about = about;
        this.tasks = tasks;
        this.requests = requests;
    }

    public Client(long id, String name, String login, String password, boolean enabled) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.enabled = enabled;
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

    public Set<Request> getRequests() {
        return requests;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setRequests(Set<Request> requests) {
        this.requests = requests;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public void addVacancy(Task v) {
        this.tasks.add(v);
    }

    public void addJob(Request j) {
        this.requests.add(j);
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
        return "Client["
                + " id: " + this.id
                + ", login: " + this.login
                + ", name: " + this.name
                + ", password: " + this.password
                + ", enabled: " + this.enabled
                + " ]";
    }

}