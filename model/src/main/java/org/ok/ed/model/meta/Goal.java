package org.ok.ed.model.meta;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Goal {

    private String name;

    private String description;

    private Theme theme;
}
