package com.example.pixelbattle.entity;

import com.example.pixelbattle.entity.secutiry.Authority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private Date lastClickDate;

    private int active;
    @ElementCollection(targetClass = Authority.class,fetch=FetchType.EAGER)
    @CollectionTable(name = "user_authorities",joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Authority> authorities;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", lastClickDate=" + lastClickDate +
                ", active=" + active +
                ", authorities=" + authorities +
                '}';
    }
}