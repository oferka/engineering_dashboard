package org.ok.ed.randomizer.data.kpi;

import org.junit.jupiter.api.Test;
import org.ok.ed.model.data.Kpi;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.ok.ed.randomizer.RandomizerUtils.*;

public class RandomKpiGeneratorTests {

    @Test
    void testGenerate() {
        Kpi kpi = generateKpi();
        assertNotNull(kpi);
    }

    @Test
    void testGenerateMultipleKpisFromSingleKpiDefinitionAndMultipleTimePeriods() {
        List<Kpi> kpis = generateMultipleKpisFromSingleKpiDefinitionAndMultipleTimePeriods();
        assertNotNull(kpis);
    }

    @Test
    void testGenerateMultipleKpisFromMultipleKpiDefinitionsAndSingleTimePeriod() {
        List<Kpi> kpis = generateMultipleKpisFromMultipleKpiDefinitionsAndSingleTimePeriod();
        assertNotNull(kpis);
    }

    @Test
    void testGenerateMultipleKpisFromMultipleKpiDefinitionsAndMultipleTimePeriods() {
        List<Kpi> kpis = generateMultipleKpisFromMultipleKpiDefinitionsAndMultipleTimePeriods();
        assertNotNull(kpis);
    }

    @Test
    void testGenerateMultipleKpisFromFullTreeOfKpiDefinitionsForSingleTimePeriod() {
        List<Kpi> kpis = generateMultipleKpisFromFullTreeOfKpiDefinitionsForSingleTimePeriod();
        assertNotNull(kpis);
    }

    @Test
    void testGenerateMultipleKpisFromFullTreeOfKpiDefinitionsForMultipleTimePeriods() {
        List<Kpi> kpis = generateMultipleKpisFromFullTreeOfKpiDefinitionsForMultipleTimePeriods();
        assertNotNull(kpis);
    }
}
