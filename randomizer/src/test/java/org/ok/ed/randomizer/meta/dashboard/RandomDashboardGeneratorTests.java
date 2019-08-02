package org.ok.ed.randomizer.meta.dashboard;

import org.junit.jupiter.api.Test;
import org.ok.ed.model.meta.Dashboard;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.ok.ed.randomizer.RandomizerUtils.generateDashboard;
import static org.ok.ed.randomizer.RandomizerUtils.generateMultipleDashboards;

public class RandomDashboardGeneratorTests {

    @Test
    void testGenerate() {
        Dashboard dashboard = generateDashboard();
        assertNotNull(dashboard);
    }

    @Test
    void testGenerateMultipleDashboards() {
        List<Dashboard> dashboards = generateMultipleDashboards();
        assertNotNull(dashboards);
    }
}
