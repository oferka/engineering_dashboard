package org.ok.ed.es.loader;

import java.io.File;
import java.io.IOException;

public class MyLoader {

    public static void main(String[] args) throws IOException {
        IndexedKpiElasticsearchLoaderSettings settings = new IndexedKpiElasticsearchLoaderSettings();
        IndexedKpiElasticsearchLoader indexedKpiElasticsearchLoader = new IndexedKpiElasticsearchLoader(settings);
        indexedKpiElasticsearchLoader.loadFromCsvFile(new File("walkme-eng.csv"));
    }
}