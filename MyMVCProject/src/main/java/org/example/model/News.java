package org.example.model;

import jakarta.persistence.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.*;
import org.example.utils.FileUtils;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
//    @Column(nullable = false)
    private String name;

//    @Column(nullable = false)
    private String title;
    private String url;
    private String type;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "newsBodyId")
    private NewsBody newsBody;


    public News(HttpServletRequest request) {
        this.name = request.getParameter("name");
        this.title = request.getParameter("tittle");
        this.type =request.getParameter("type");
        this.url= FileUtils.savePhoto(request);
    }

    public News(String name, String title, String type) {
        this.name = name;
        this.title = title;
        this.type = type;
    }
}
