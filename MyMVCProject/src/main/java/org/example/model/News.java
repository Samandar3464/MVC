package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String title;
    private String url;
    private Enum type;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "newsBodyId")
    private NewsBody newsBody;

    public News(String name, String title, String url, Enum type, NewsBody newsBody) {
        this.name = name;
        this.title = title;
        this.url = url;
        this.type = type;
        this.newsBody = newsBody;
    }


}
