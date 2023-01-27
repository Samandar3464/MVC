package org.example.model;


import jakarta.persistence.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class NewsBody {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "newsBodyId")
    private int id;

//    @Column(nullable = false)
    private String fullDescription;
    public NewsBody(HttpServletRequest request) {
        this.fullDescription = request.getParameter("full_info");
    }

}
