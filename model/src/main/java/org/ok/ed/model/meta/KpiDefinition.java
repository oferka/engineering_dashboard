package org.ok.ed.model.meta;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.Range;

@Data
@AllArgsConstructor
public class KpiDefinition {

    private String name;

    private String description;

    private Objective objective;

    private Range<Integer> valueRange;
}