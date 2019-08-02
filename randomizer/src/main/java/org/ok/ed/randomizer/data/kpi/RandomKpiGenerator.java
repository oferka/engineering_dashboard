package org.ok.ed.randomizer.data.kpi;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.RandomUtils;
import org.jetbrains.annotations.NotNull;
import org.ok.ed.model.data.Kpi;
import org.ok.ed.model.meta.KpiDefinition;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class RandomKpiGenerator {

    private RandomKpiGeneratorSettings settings;

    public Kpi generate(KpiDefinition kpiDefinition, String timePeriod) {
        return new Kpi(kpiDefinition, timePeriod, generateValue(kpiDefinition));
    }

    public List<Kpi> generateMultipleKpis(KpiDefinition kpiDefinition, List<String> timePeriods) {
        List<Kpi> result = new ArrayList<>();
        for(String timePeriod : timePeriods) {
            result.add(generate(kpiDefinition, timePeriod));
        }
        return result;
    }

    public List<Kpi> generateMultipleKpis(List<KpiDefinition> kpiDefinitions, String timePeriod) {
        List<Kpi> result = new ArrayList<>();
        for(KpiDefinition kpiDefinition : kpiDefinitions) {
            result.add(generate(kpiDefinition, timePeriod));
        }
        return result;
    }

    public List<Kpi> generateMultipleKpis(List<KpiDefinition> kpiDefinitions, List<String> timePeriods) {
        List<Kpi> result = new ArrayList<>();
        for(KpiDefinition kpiDefinition : kpiDefinitions) {
            for(String timePeriod : timePeriods) {
                result.add(generate(kpiDefinition, timePeriod));
            }
        }
        return result;
    }

    private Integer generateValue(@NotNull KpiDefinition kpiDefinition) {
        return RandomUtils.nextInt(
                kpiDefinition.getValueRange().getMinimum(),
                kpiDefinition.getValueRange().getMaximum() + 1
        );
    }
}
