package net.passioncloud.hellomysql;

import javax.persistence.*;

@Entity // tell hibernate to make table out of this class
public class User {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@SequenceGenerator(name="user_generator", sequenceName = "book_seq", allocationSize = 50)
    private String id;
    private String name;
    private String email;

    public User() {}
    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
