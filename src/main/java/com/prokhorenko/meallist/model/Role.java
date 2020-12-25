package com.prokhorenko.meallist.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role /*implements GrantedAuthority*/{

    @Id
    private int id;

    private String name;
    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role(int id) {
        this.id = id;
    }

    /*@Override
    public String getAuthority() {
        return getName();
    }*/

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
