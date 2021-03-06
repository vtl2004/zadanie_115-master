package model;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users_role")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "age")
    private int age;

    @Column(name = "role")
    private String role;

    public User() {
    }

    public User(long id, String name, String password, int age, String role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.role = role;
    }

    public User(String name, String password, int age, String role) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.role = role;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }



    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", password = '" + password + '\'' +
                ", age = " + age +
                ", role = '" + role + '\'' +
                '}';
    }

    /* @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return id == user.id && Objects.equals(name, user.name) &&
                age == user.age;
    }*/
}
