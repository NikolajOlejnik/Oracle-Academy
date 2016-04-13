package main.oracle.academy.fp.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Long id;

	@Column(name = "LOGIN", unique=true)
	@NotNull(message = "Введите логин!")
	@Size(min=1, max=10, message = "Длина логина должна быть от 1 до 10 символов!")
	private String login;

	@Column(name = "PASSWORD")
	@NotNull(message = "Введите пароль!")
	@Size(min=1, max=10, message = "Длина пароля должна быть от 1 до 10 символов!")
	private String password;

	@Column(name = "EMAIL")
	@NotNull(message = "Введите ваш e-mail!")
	@Email(message = "Введите корректный e-mail!")
	private String email;

	@Column(name = "NAME")
	@NotNull
	@Size(min=2, max=40, message = "Длина имени должна быть от 2 до 40 символов!")
	private String name;

	@Column(name = "ABOUT")
	private String about;

	@Column(name = "ENABLED")
	private boolean enabled;

	@Column(name="USER_ROLE")
	@Enumerated(EnumType.STRING)
	private Role role;

	@OneToMany(mappedBy = "user")
	private List <Task> tasks;

	@OneToMany(mappedBy = "user")
	private List <Request> requests;

	public User() {
		this.setEnabled(true);
		this.setRole(Role.ROLE_USER);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List <Task> getTasks() {
		return tasks;
	}

	public void setTasks(List <Task> tasks) {
		this.tasks = tasks;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", email='").append(email).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", login='").append(login).append('\'');
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }
}
