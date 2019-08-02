package org.ok.ed.randomizer.meta.kpid;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.Range;
import org.ok.ed.model.meta.KpiDefinition;
import org.ok.ed.model.meta.Objective;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class RandomKpiDefinitionGenerator {

    private RandomKpiDefinitionGeneratorSettings settings;

    public KpiDefinition generate(String name, Objective objective) {
        return new KpiDefinition(
                name,
                name + settings.getDescriptionSuffix(),
                objective,
                Range.between(0, 100)
        );
    }

    public List<KpiDefinition> generateMultipleKpiDefinitions(int numberOfKpiDefinitions, String namePrefix, Objective objective) {
        List<KpiDefinition> result = new ArrayList<>();
        for(int i=1; i<=numberOfKpiDefinitions; i++) {
            result.add(generate(namePrefix + "_" + i, objective));
        }
        return result;
    }

    public List<KpiDefinition> generateMultipleKpiDefinitionsForMultipleObjectives(int numberOfKpiDefinitionsPerObjective, String namePrefix, List<Objective> objectives) {
        List<KpiDefinition> result = new ArrayList<>();
        for(Objective objective : objectives) {
            result.addAll(generateMultipleKpiDefinitions(numberOfKpiDefinitionsPerObjective, namePrefix, objective));
        }
        return result;
    }
}
