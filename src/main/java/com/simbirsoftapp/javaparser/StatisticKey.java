package com.simbirsoftapp.javaparser;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * The class is a composite key that we use for the entity Statistic
 */
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
