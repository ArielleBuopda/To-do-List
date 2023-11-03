package htwberlin.todolist.model;

import javax.persistence.*;


@Entity
@Table(name = "user_todo")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iduser;

    private String surname;

    private String name;

    private String email;

    private String password;

    private String token;
}
