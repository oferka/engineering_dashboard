package org.ok.ed.randomizer.meta.goal;

import org.junit.jupiter.api.Test;
import org.ok.ed.model.meta.Goal;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.ok.ed.randomizer.RandomizerUtils.*;

public class RandomGoalGeneratorTests {

    @Test
    void testGenerate() {
        Goal goal = generateGoal();
        assertNotNull(goal);
    }

    @Test
    void testGenerateMultipleGoals() {
        List<Goal> goals = generateMultipleGoals();
        assertNotNull(goals);
    }

    @Test
    void testGenerateMultipleGoalsForMultipleThemes() {
        List<Goal> goals = generateMultipleGoalsForMultipleThemes();
        assertNotNull(goals);
    }
}
