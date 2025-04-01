package web.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Изменил int на Long для лучшей совместимости

    @Column(name = "name", nullable = false, length = 35)
    @NotBlank(message = "Name should not be empty")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name should contain only letters")
    @Size(min = 2, max = 35, message = "Name should be between 2 and 35 characters")
    private String name;

    @Column(name = "surname", nullable = false, length = 35)
    @NotBlank(message = "Surname should not be empty")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Surname should contain only letters")
    @Size(min = 2, max = 35, message = "Surname should be between 2 and 35 characters")
    private String surname;

    @Column(name = "age", nullable = false)
    @Min(value = 1, message = "Age should be greater than 0")
    @Max(value = 120, message = "Age should be realistic")
    private Integer age;  // Используем Integer вместо int для возможности null

    @Column(name = "email", nullable = false, unique = true, length = 100)
    @NotBlank(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    public User() {
    }

    public User(String name, String surname, Integer age, String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
