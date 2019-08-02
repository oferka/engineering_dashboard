package org.ok.ed.randomizer.meta.dashboard;

import lombok.Data;

@Data
public class RandomDashboardGeneratorSettings {

    private String descriptionSuffix = "_description";
    private String organizationNameSuffix = "_organization_name";
    private String organizationDescriptionSuffix = "_organization_description";
    private String departmentNameSuffix = "_department_name";
    private String departmentDescriptionSuffix = "_department_description";
}
