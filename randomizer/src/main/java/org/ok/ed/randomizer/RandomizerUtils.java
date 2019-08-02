package org.ok.ed.randomizer;

import org.ok.ed.model.data.IndexedKpi;
import org.ok.ed.model.data.Kpi;
import org.ok.ed.model.meta.*;
import org.ok.ed.randomizer.data.kpi.RandomKpiGenerator;
import org.ok.ed.randomizer.data.kpi.RandomKpiGeneratorSettings;
import org.ok.ed.randomizer.meta.dashboard.RandomDashboardGenerator;
import org.ok.ed.randomizer.meta.dashboard.RandomDashboardGeneratorSettings;
import org.ok.ed.randomizer.meta.goal.RandomGoalGenerator;
import org.ok.ed.randomizer.meta.goal.RandomGoalGeneratorSettings;
import org.ok.ed.randomizer.meta.kpid.RandomKpiDefinitionGenerator;
import org.ok.ed.randomizer.meta.kpid.RandomKpiDefinitionGeneratorSettings;
import org.ok.ed.randomizer.meta.objective.RandomObjectiveGenerator;
import org.ok.ed.randomizer.meta.objective.RandomObjectiveGeneratorSettings;
import org.ok.ed.randomizer.meta.theme.RandomThemeGenerator;
import org.ok.ed.randomizer.meta.theme.RandomThemeGeneratorSettings;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class RandomizerUtils {

    public static Dashboard generateDashboard() {
        return getDashboardGenerator().generate("Dashboard");
    }

    public static List<Dashboard> generateMultipleDashboards() {
        return getDashboardGenerator().generateMultipleDashboards(5, "Dashboard");
    }

    public static RandomDashboardGenerator getDashboardGenerator() {
        RandomDashboardGeneratorSettings settings = new RandomDashboardGeneratorSettings();
        return new RandomDashboardGenerator(settings);
    }

    public static Theme generateTheme() {
        return getThemeGenerator().generate("Theme", generateDashboard());
    }

    public static List<Theme> generateMultipleThemes() {
        return getThemeGenerator().generateMultipleThemes(10, "Theme", generateDashboard());
    }

    public static List<Theme> generateMultipleThemesForMultipleDashboards() {
        return getThemeGenerator().generateMultipleThemesForMultipleDashboards(10, "Theme", generateMultipleDashboards());
    }

    public static RandomThemeGenerator getThemeGenerator() {
        RandomThemeGeneratorSettings settings = new RandomThemeGeneratorSettings();
        return new RandomThemeGenerator(settings);
    }

    public static Goal generateGoal() {
        return getGoalGenerator().generate("Goal", generateTheme());
    }

    public static List<Goal> generateMultipleGoals() {
        return getGoalGenerator().generateMultipleGoals(15, "Goal", generateTheme());
    }

    public static List<Goal> generateMultipleGoalsForMultipleThemes() {
        return getGoalGenerator().generateMultipleGoalsForMultipleThemes(15, "Goal", generateMultipleThemes());
    }

    public static RandomGoalGenerator getGoalGenerator() {
        RandomGoalGeneratorSettings settings = new RandomGoalGeneratorSettings();
        return new RandomGoalGenerator(settings);
    }

    public static Objective generateObjective() {
        return getObjectiveGenerator().generate("Objective", generateGoal());
    }

    public static List<Objective> generateMultipleObjectives() {
        return getObjectiveGenerator().generateMultipleObjectives(20, "Objective", generateGoal());
    }

    public static List<Objective> generateMultipleObjectivesForMultipleGoals() {
        return getObjectiveGenerator().generateMultipleObjectivesForMultipleGoals(20, "Objective", generateMultipleGoals());
    }

    public static RandomObjectiveGenerator getObjectiveGenerator() {
        RandomObjectiveGeneratorSettings settings = new RandomObjectiveGeneratorSettings();
        return new RandomObjectiveGenerator(settings);
    }

    public static KpiDefinition generateKpiDefinition() {
        return getKpiDefinitionGenerator().generate("KpiDefinition", generateObjective());
    }

    public static List<KpiDefinition> generateMultipleKpiDefinitions() {
        return getKpiDefinitionGenerator().generateMultipleKpiDefinitions(25, "KpiDefinition", generateObjective());
    }

    public static List<KpiDefinition> generateMultipleKpiDefinitionsForMultipleObjectives() {
        return getKpiDefinitionGenerator().generateMultipleKpiDefinitionsForMultipleObjectives(25, "KpiDefinition", generateMultipleObjectives());
    }

    public static RandomKpiDefinitionGenerator getKpiDefinitionGenerator() {
        RandomKpiDefinitionGeneratorSettings settings = new RandomKpiDefinitionGeneratorSettings();
        return new RandomKpiDefinitionGenerator(settings);
    }

    public static List<KpiDefinition> generateKpiDefinitionsFullTree() {
        return getKpiDefinitionGenerator()
                .generateMultipleKpiDefinitionsForMultipleObjectives(
                        5,
                        "KpiDefinition",
                        getObjectiveGenerator()
                                .generateMultipleObjectivesForMultipleGoals(
                                        5,
                                        "Objective",
                                        getGoalGenerator()
                                                .generateMultipleGoalsForMultipleThemes(
                                                        5,
                                                        "Goal",
                                                        getThemeGenerator()
                                                                .generateMultipleThemesForMultipleDashboards(
                                                                        4,
                                                                        "Theme",
                                                                        getDashboardGenerator()
                                                                                .generateMultipleDashboards(2, "Dashboard")
                                                                )
                                                )
                                )
                );
    }

    public static Kpi generateKpi() {
        return getKpiGenerator().generate(generateKpiDefinition(), "time_period_1");
    }

    public static List<Kpi> generateMultipleKpisFromSingleKpiDefinitionAndMultipleTimePeriods() {
        return getKpiGenerator().generateMultipleKpis(generateKpiDefinition(),
                asList(
                        "time_period_1",
                        "time_period_2",
                        "time_period_3",
                        "time_period_4",
                        "time_period_5",
                        "time_period_6"
                )
        );
    }

    public static List<Kpi> generateMultipleKpisFromMultipleKpiDefinitionsAndSingleTimePeriod() {
        return getKpiGenerator().generateMultipleKpis(generateMultipleKpiDefinitions(), "time_period_1");
    }

    public static List<Kpi> generateMultipleKpisFromMultipleKpiDefinitionsAndMultipleTimePeriods() {
        return getKpiGenerator().generateMultipleKpis(generateMultipleKpiDefinitions(),
                asList(
                        "time_period_1",
                        "time_period_2",
                        "time_period_3",
                        "time_period_4",
                        "time_period_5",
                        "time_period_6"
                )
        );
    }

    public static List<Kpi> generateMultipleKpisFromFullTreeOfKpiDefinitionsForSingleTimePeriod() {
        return getKpiGenerator().generateMultipleKpis(generateKpiDefinitionsFullTree(), "time_period_1");
    }

    public static List<Kpi> generateMultipleKpisFromFullTreeOfKpiDefinitionsForMultipleTimePeriods() {
        return getKpiGenerator().generateMultipleKpis(generateKpiDefinitionsFullTree(),
                asList(
                        "time_period_1",
                        "time_period_2",
                        "time_period_3",
                        "time_period_4",
                        "time_period_5",
                        "time_period_6"
                )
        );
    }

    public static List<IndexedKpi> generateMultipleIndexedKpisFromFullTreeOfKpiDefinitionsForMultipleTimePeriods() {
        List<Kpi> kpis = generateMultipleKpisFromFullTreeOfKpiDefinitionsForMultipleTimePeriods();
        List<IndexedKpi> result = new ArrayList<>();
        for(Kpi kpi : kpis) {
            result.add(new IndexedKpi(kpi));
        }
        return result;
    }

    public static RandomKpiGenerator getKpiGenerator() {
        RandomKpiGeneratorSettings settings = new RandomKpiGeneratorSettings();
        return new RandomKpiGenerator(settings);
    }
}
