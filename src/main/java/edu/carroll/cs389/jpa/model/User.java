package edu.carroll.cs389.jpa.model;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

/**
 * The Login class is a JPA model that interacts with our database. Rather than creating the
 * tables and rows ourselves, this class takes care of that and represents the table.
 * This table stores the user's UID and username.
 */

//Entity simply represents a table stored in our database.
@Entity
@Table(name = "app_user")
public class User {
    private static final long serialVersionUID = 1L;

    //GeneratedValue auto generates the id for us.
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    //Link to the stock table. Linking through "user".
    @OneToMany(mappedBy = "user")
    private Set<Stock> stocks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
