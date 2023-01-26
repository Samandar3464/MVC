package org.example.model;

import jakarta.persistence.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.utils.FileUtils;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
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

}
