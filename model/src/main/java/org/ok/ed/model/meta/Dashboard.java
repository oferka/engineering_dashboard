package org.ok.ed.model.meta;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dashboard {

    private String name;

    private String description;

    private Account account;
}
