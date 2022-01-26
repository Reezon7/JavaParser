package com.simbirsoftapp.javaparser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ServiceAppImplTest {

    @MockBean
    private StatisticRepository statisticRepository;

    @Test
    void analyzeUrl() {
        String url = "https://www.simbirsoft.com/";
        String word = "РАЗРАБОТКА";
        Statistic statistic = new Statistic(url, word, 1);
        statisticRepository.save(statistic);

        Mockito.verify(statisticRepository, Mockito.times(1)).save(statistic);
        assertNotNull(statisticRepository.findByUrl(url));
    }
}