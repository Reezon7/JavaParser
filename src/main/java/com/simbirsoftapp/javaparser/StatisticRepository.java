package com.simbirsoftapp.javaparser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface StatisticRepository extends JpaRepository<Statistic, String> {

    List<Statistic> findByUrl(String url);
    List<Statistic> findTop5ByUrlOrderByCountDesc(String url);
    @Transactional
    void deleteByUrl(String url);

}
