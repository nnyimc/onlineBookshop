package fr.nnyimc.onlinebookshop.persistence.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Product implements IProduct, Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String designation;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private int quantity;
}
