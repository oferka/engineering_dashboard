package org.ok.ed.randomizer.meta.objective;

import org.junit.jupiter.api.Test;
import org.ok.ed.model.meta.Objective;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.ok.ed.randomizer.RandomizerUtils.*;

public class RandomObjectiveGeneratorTests {

    @Test
    void testGenerate() {
        Objective objective = generateObjective();
        assertNotNull(objective);
    }

    @Test
    void testGenerateMultipleObjectives() {
        List<Objective> objectives = generateMultipleObjectives();
        assertNotNull(objectives);
    }

    @Test
    void testGenerateMultipleObjectivesForMultipleGoals() {
        List<Objective> objectives = generateMultipleObjectivesForMultipleGoals();
        assertNotNull(objectives);
    }
}
