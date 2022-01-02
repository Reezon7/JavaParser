package com.simbirsoftapp.javaparser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WordsRepository extends JpaRepository<UniquePair, Integer> {
}
