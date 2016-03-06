//package ua.oracleacademy.fp.domain;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "USER")
//public abstract class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "USER_ID")
//    private Long id;
//
//    @Column(name = "LOGIN")
//    private String login;
//    @Column(name = "PASS")
//    private String password;
//    @Column(name = "MAIL")
//    private String email;
//    @Column(name = "USER_NAME")
//    private String name;
//
//    public User() {
//    };
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
