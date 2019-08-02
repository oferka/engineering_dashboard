package org.ok.ed.randomizer.meta.objective;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ok.ed.model.meta.Goal;
import org.ok.ed.model.meta.Objective;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class RandomObjectiveGenerator {

    private RandomObjectiveGeneratorSettings settings;

    public Objective generate(String name, Goal goal) {
        return new Objective(name, name + settings.getDescriptionSuffix(), goal);
    }

    public List<Objective> generateMultipleObjectives(int numberOfObjectives, String namePrefix, Goal goal) {
        List<Objective> result = new ArrayList<>();
        for(int i=1; i<=numberOfObjectives; i++) {
            result.add(generate(namePrefix + "_" + i, goal));
        }
        return result;
    }

    public List<Objective> generateMultipleObjectivesForMultipleGoals(int numberOfObjectivesPerGoal, String namePrefix, List<Goal> goals) {
        List<Objective> result = new ArrayList<>();
        for(Goal goal : goals) {
            result.addAll(generateMultipleObjectives(numberOfObjectivesPerGoal, namePrefix, goal));
        }
        return result;
    }
}
