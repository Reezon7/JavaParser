package com.simbirsoftapp.javaparser;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ServiceApp {

    @Autowired
    public WordsRepository wordsRepository;

    public void analyzeUrl(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        String title = doc.title();
        System.out.println(title);
    }
}
