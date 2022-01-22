package com.simbirsoftapp.javaparser;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "statistic")
@ToString
@NoArgsConstructor
@IdClass(StatisticKey.class)
public class Statistic {
    @Id
    @Getter
    @Setter
    @Column(name = "URL")
    private String url;

    @Id
    @Getter
    @Setter
    @Column(name = "WORD")
    private String word;

    @Getter
    @Setter
    @Column(name = "COUNT")
    private Integer count;



    public Statistic(@NonNull String url, @NonNull String word, @NonNull Integer count) {
        this.url = url;
        this.word = word;
        this.count = count;
    }
}
