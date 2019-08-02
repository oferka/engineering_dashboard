package org.ok.ed.randomizer.meta.goal;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ok.ed.model.meta.Goal;
import org.ok.ed.model.meta.Theme;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class RandomGoalGenerator {

    private RandomGoalGeneratorSettings settings;

    public Goal generate(String name, Theme theme) {
        return new Goal(name, name + settings.getDescriptionSuffix(), theme);
    }

    public List<Goal> generateMultipleGoals(int numberOfGoals, String namePrefix, Theme theme) {
        List<Goal> result = new ArrayList<>();
        for(int i=1; i<=numberOfGoals; i++) {
            result.add(generate(namePrefix + "_" + i, theme));
        }
        return result;
    }

    public List<Goal> generateMultipleGoalsForMultipleThemes(int numberOfGoalsPerTheme, String namePrefix, List<Theme> themes) {
        List<Goal> result = new ArrayList<>();
        for(Theme theme : themes) {
            result.addAll(generateMultipleGoals(numberOfGoalsPerTheme, namePrefix, theme));
        }
        return result;
    }
}
