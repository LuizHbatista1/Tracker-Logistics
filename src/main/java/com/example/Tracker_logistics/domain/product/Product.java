package com.example.Tracker_logistics.domain.product;

import com.example.Tracker_logistics.DTOS.ProductDTO;
import com.example.Tracker_logistics.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "products")
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String title;
    private TrackerBase origin;
    private StatusType status;
    @JoinColumn(name = "receiver_id")
    @ManyToOne
    private User receiver;


}
