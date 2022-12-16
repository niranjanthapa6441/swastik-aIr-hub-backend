package com.swastikairhub.SwastiKAirHubBackend.User;

import com.swastikairhub.SwastiKAirHubBackend.Role.Role;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "customer")
public class User {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "user_id")
    private String id;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Column(name = "username",nullable = false,unique = true)
    private String username;
    @Column(name = "phone_number",nullable = false,unique = true)
    private String phoneNumber;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "status",nullable = false)
    private String status;
    private Boolean locked=false;
    private Boolean enabled=false;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "et_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @Column(name = "role",nullable = false)
    private Set<Role> roles = new HashSet<>();
}
