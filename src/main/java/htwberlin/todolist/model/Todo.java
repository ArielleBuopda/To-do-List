package htwberlin.todolist.model;



import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtodo;

    private String task;

    private String description;

    private Date date_todo;

    private int status;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;

    public Long getIdtodo() {
        return idtodo;
    }

    public void setIdtodo(Long idtodo) {
        this.idtodo = idtodo;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_todo() {
        return date_todo;
    }

    public void setDate_todo(Date date) {
        this.date_todo = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return status == todo.status && Objects.equals(idtodo, todo.idtodo) && Objects.equals(task, todo.task) && Objects.equals(description, todo.description) && Objects.equals(date_todo, todo.date_todo) && Objects.equals(user, todo.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idtodo, task, description, date_todo, status, user);
    }

    @Override
    public String toString() {
        return "Todo{" +
                "idtodo=" + idtodo +
                ", task='" + task + '\'' +
                ", description='" + description + '\'' +
                ", date_todo=" + date_todo +
                ", status=" + status +
                ", user=" + user +
                '}';
    }
}
