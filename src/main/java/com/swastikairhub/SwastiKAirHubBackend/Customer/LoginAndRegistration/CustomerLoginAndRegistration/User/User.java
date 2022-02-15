package com.swastikairhub.SwastiKAirHubBackend.Customer.LoginAndRegistration.CustomerLoginAndRegistration.User;

import com.swastikairhub.SwastiKAirHubBackend.Customer.LoginAndRegistration.CustomerLoginAndRegistration.User.Role.UserRole;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @SequenceGenerator(
            name = "et_users_user_id_seq",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="user_sequence"
    )
    @Column(name = "user_id")
    private int userId;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "lastName",nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    private Boolean locked=false;
    private Boolean enabled=false;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "et_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<UserRole> roles = new HashSet<>();
    public User(String firstName,
                   String lastName,
                   String username,
                   String password,
                   String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username=username;
        this.email = email;
        this.password = password;
    }
    public void addRole(UserRole role){
        this.roles.add(role);
    }
}
