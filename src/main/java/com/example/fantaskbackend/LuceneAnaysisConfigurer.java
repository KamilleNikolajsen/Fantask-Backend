package com.example.fantaskbackend;

import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurationContext;
import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurer;

public class LuceneAnaysisConfigurer implements LuceneAnalysisConfigurer {

    // https://docs.jboss.org/hibernate/stable/search/reference/en-US/html_single/#getting-started-analysis
    @Override
    public void configure(LuceneAnalysisConfigurationContext context) {

    }

}
