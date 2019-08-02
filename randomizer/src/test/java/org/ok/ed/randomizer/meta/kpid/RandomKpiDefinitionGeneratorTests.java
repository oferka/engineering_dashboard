package org.ok.ed.randomizer.meta.kpid;

import org.junit.jupiter.api.Test;
import org.ok.ed.model.meta.KpiDefinition;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.ok.ed.randomizer.RandomizerUtils.*;

public class RandomKpiDefinitionGeneratorTests {

    @Test
    void testGenerate() {
        KpiDefinition kpiDefinition = generateKpiDefinition();
        assertNotNull(kpiDefinition);
    }

    @Test
    void testGenerateMultipleKpiDefinitions() {
        List<KpiDefinition> kpiDefinitions = generateMultipleKpiDefinitions();
        assertNotNull(kpiDefinitions);
    }

    @Test
    void testGenerateMultipleKpiDefinitionsForMultipleObjectives() {
        List<KpiDefinition> kpiDefinitions = generateMultipleKpiDefinitionsForMultipleObjectives();
        assertNotNull(kpiDefinitions);
    }

    @Test
    void testGenerateMultipleKpiDefinitionsRecursive() {
        List<KpiDefinition> kpiDefinitions = generateKpiDefinitionsFullTree();
        assertNotNull(kpiDefinitions);
    }
}
