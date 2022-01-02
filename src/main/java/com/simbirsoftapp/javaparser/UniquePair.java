package com.simbirsoftapp.javaparser;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "uniquePairs")
@ToString
public class UniquePair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    @Setter
    @NonNull
    private Integer id;

    @Getter
    @Setter
    @NonNull
    @Column(name = "word")
    private String word;

    @Getter
    @Setter
    @NonNull
    @Column(name = "count")
    private int count;

}
