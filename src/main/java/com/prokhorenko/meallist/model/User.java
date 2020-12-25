package com.prokhorenko.meallist.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="user")
public class User /*implements UserDetails*/ {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;

    private String password;

    private boolean active;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    /*@Override
    public boolean isAccountNonExpired() {
        return true;
    }*/

    /*@Override
    public boolean isAccountNonLocked() {
        return true;
    }*/

    /*@Override
    public boolean isCredentialsNonExpired() {
        return true;
    }*/

    /*@Override
    public boolean isEnabled() {
        return true;
    }*/

    public void setUsername(String username) {
        this.username = username;
    }

    /*@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }*/

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
