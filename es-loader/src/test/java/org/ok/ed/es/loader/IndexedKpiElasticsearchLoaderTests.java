package org.ok.ed.es.loader;

import org.junit.jupiter.api.Test;
import org.ok.ed.model.data.IndexedKpi;
import org.ok.ed.serializer.csv.IndexedKpiCsvSerializer;
import org.ok.ed.serializer.csv.IndexedKpiCsvSerializerSettings;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.ok.ed.randomizer.RandomizerUtils.generateMultipleIndexedKpisFromFullTreeOfKpiDefinitionsForMultipleTimePeriods;

class IndexedKpiElasticsearchLoaderTests {

    @Test
    void testLoadFullTree() throws IOException {
        IndexedKpiElasticsearchLoaderSettings settings = new IndexedKpiElasticsearchLoaderSettings();
        IndexedKpiElasticsearchLoader indexedKpiElasticsearchLoader = new IndexedKpiElasticsearchLoader(settings);
        indexedKpiElasticsearchLoader.load(generateIndexedKpis());
    }

    @Test
    void testLoadFromCsvFile() throws IOException {
        IndexedKpiElasticsearchLoaderSettings settings = new IndexedKpiElasticsearchLoaderSettings();
        IndexedKpiElasticsearchLoader indexedKpiElasticsearchLoader = new IndexedKpiElasticsearchLoader(settings);
        indexedKpiElasticsearchLoader.load(generateIndexedKpisFromCsvFile());
    }

    private List<IndexedKpi> generateIndexedKpis() {
        return generateMultipleIndexedKpisFromFullTreeOfKpiDefinitionsForMultipleTimePeriods();
    }

    private List<IndexedKpi> generateIndexedKpisFromCsvFile() {
        IndexedKpiCsvSerializerSettings settings = new IndexedKpiCsvSerializerSettings();
        IndexedKpiCsvSerializer indexedKpiCsvSerializer = new IndexedKpiCsvSerializer(settings);
        indexedKpiCsvSerializer.exportToCsvFile(generateIndexedKpis(), getDestinationFile());
        return indexedKpiCsvSerializer.importFromCsvFile(getDestinationFile());
    }

    private File getDestinationFile() {
//        return new File("walkme-eng.csv");
        return new File("target/destination.csv");
    }
}