package org.ok.ed.model.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ok.ed.model.meta.KpiDefinition;

@Data
@AllArgsConstructor
public class Kpi {

    private KpiDefinition kpiDefinition;

    private String timePeriod;

    private Integer value;
}
