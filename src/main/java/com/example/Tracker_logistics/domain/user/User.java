package com.example.Tracker_logistics.domain.user;


import com.example.Tracker_logistics.DTOS.UserDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "users")
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String username;
    private String email;
    private String phone;

    public User (UserDTO data){

        this.username = data.username();
        this.email = data.email();
        this.phone = data.phone();



    }


}
