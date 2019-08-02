package org.ok.ed.serializer.csv;

import org.junit.jupiter.api.Test;
import org.ok.ed.model.data.IndexedKpi;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.ok.ed.randomizer.RandomizerUtils.generateMultipleIndexedKpisFromFullTreeOfKpiDefinitionsForMultipleTimePeriods;

public class IndexedKpiCsvSerializerTests {

    @Test
    void testSerializeFullTree() {
        IndexedKpiCsvSerializerSettings settings = new IndexedKpiCsvSerializerSettings();
        IndexedKpiCsvSerializer indexedKpiCsvSerializer = new IndexedKpiCsvSerializer(settings);
        indexedKpiCsvSerializer.exportToCsvFile(generateIndexedKpis(), getDestinationFile());
    }

    @Test
    void testDeSerializeFullTree() {
        IndexedKpiCsvSerializerSettings settings = new IndexedKpiCsvSerializerSettings();
        IndexedKpiCsvSerializer indexedKpiCsvSerializer = new IndexedKpiCsvSerializer(settings);
        indexedKpiCsvSerializer.exportToCsvFile(generateIndexedKpis(), getDestinationFile());
        List<IndexedKpi> indexedKpis = indexedKpiCsvSerializer.importFromCsvFile(getDestinationFile());
        assertNotNull(indexedKpis);
    }

    private List<IndexedKpi> generateIndexedKpis() {
        return generateMultipleIndexedKpisFromFullTreeOfKpiDefinitionsForMultipleTimePeriods();
    }

    private File getDestinationFile() {
        return new File("target/destination.csv");
    }
}
