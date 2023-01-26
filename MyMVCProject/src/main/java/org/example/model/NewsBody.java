package org.example.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class NewsBody {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "newsBodyId")
    private int id;

    @Column(nullable = false)
    private String fullDescription;

}
