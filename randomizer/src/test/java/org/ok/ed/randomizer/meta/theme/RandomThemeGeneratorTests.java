package org.ok.ed.randomizer.meta.theme;

import org.junit.jupiter.api.Test;
import org.ok.ed.model.meta.Theme;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.ok.ed.randomizer.RandomizerUtils.*;

public class RandomThemeGeneratorTests {

    @Test
    void testGenerate() {
        Theme theme = generateTheme();
        assertNotNull(theme);
    }

    @Test
    void testGenerateMultipleThemes() {
        List<Theme> themes = generateMultipleThemes();
        assertNotNull(themes);
    }

    @Test
    void testGenerateMultipleThemesForMultipleDashboards() {
        List<Theme> themes = generateMultipleThemesForMultipleDashboards();
        assertNotNull(themes);
    }
}
