package edu.miu.lab5.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    private String  password;

    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL)
    @JsonIgnore
    private List <Post> posts;

    @ManyToMany
     private  List<Role> roles;
}
