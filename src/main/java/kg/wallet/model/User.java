package kg.wallet.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name="user")

public class User {
    private int id;
    private String name;
    private String password;
    private Date createdDate;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User(int id, String name, String password, Date createdDate) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.createdDate = createdDate;
    }
}
