package com.simbirsoftapp.javaparser;

import java.io.IOException;
import java.util.List;

public interface ServiceApp {
    List<Statistic> analyzeUrl(String url) throws IOException;
}
