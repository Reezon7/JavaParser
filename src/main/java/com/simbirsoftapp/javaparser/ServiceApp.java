package com.simbirsoftapp.javaparser;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;


@Service
public class ServiceApp {

    @Autowired
    public StatisticRepository statisticRepository;

    public List<Statistic> analyzeUrl(String url) throws IOException {
        //logger initialization
        Logger log = Logger.getLogger(ServiceApp.class);

        try {
            //search for the entered url in the database
            //and clear everything associated with it
            List<Statistic> statistics = statisticRepository.findByUrl(url);
            if (statistics != null) {
                statisticRepository.deleteByUrl(url);
            }
            //connect to url and get all text
            Document doc = Jsoup.connect(url).get();
            String content = doc.text().toUpperCase();
            //splitting text into words using a regular expression
            String regex2 = "([^a-zA-Zа-яА-Я']+)'*\\1*";
            String regex = "[^а-яА-Яa-zA-Z]+";
            String regex3 = "[,.!?\";:\\[\\]\\(\\)\\n\\r\\t ]+";
            String[] split = content.split(regex);
            Map<String, Integer> countOfWords = new HashMap<>();
            //counting words
            for (String s : split) {
                if (!countOfWords.containsKey(s)) countOfWords.put(s, 0);
                countOfWords.put(s, countOfWords.get(s) + 1);
            }
            //save to the database
            for (Map.Entry<String, Integer> entry : countOfWords.entrySet()) {
                statisticRepository.save(new Statistic(url, entry.getKey(), entry.getValue()));
            }
        }
        catch (Exception e){
            log.error(e.getMessage());
        }
        return statisticRepository.findTop5ByUrlOrderByCountDesc(url);
    }
}
