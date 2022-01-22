package com.simbirsoftapp.javaparser;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

@EqualsAndHashCode
@ToString
public class StatisticKey implements Serializable {
    @Getter
    @Setter
    @Column(name = "URL")
    private String url;

    @Getter
    @Setter
    @Column(name = "WORD")
    private String word;
}
