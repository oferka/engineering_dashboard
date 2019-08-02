package org.ok.ed.model.meta;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {

    private Organization organization;

    private Department department;
}
