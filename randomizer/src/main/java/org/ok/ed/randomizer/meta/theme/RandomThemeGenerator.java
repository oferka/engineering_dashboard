package org.ok.ed.randomizer.meta.theme;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ok.ed.model.meta.Dashboard;
import org.ok.ed.model.meta.Theme;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class RandomThemeGenerator {

    private RandomThemeGeneratorSettings settings;

    public Theme generate(String name, Dashboard dashboard) {
        return new Theme(name, name + settings.getDescriptionSuffix(), dashboard);
    }

    public List<Theme> generateMultipleThemes(int numberOfThemes, String namePrefix, Dashboard dashboard) {
        List<Theme> result = new ArrayList<>();
        for(int i=1; i<=numberOfThemes; i++) {
            result.add(generate(namePrefix + "_" + i, dashboard));
        }
        return result;
    }

    public List<Theme> generateMultipleThemesForMultipleDashboards(int numberOfThemesPerDashboard, String namePrefix, List<Dashboard> dashboards) {
        List<Theme> result = new ArrayList<>();
        for(Dashboard dashboard : dashboards) {
            result.addAll(generateMultipleThemes(numberOfThemesPerDashboard, namePrefix, dashboard));
        }
        return result;
    }
}
