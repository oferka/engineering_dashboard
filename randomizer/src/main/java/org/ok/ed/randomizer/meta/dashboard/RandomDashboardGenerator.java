package org.ok.ed.randomizer.meta.dashboard;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ok.ed.model.meta.Account;
import org.ok.ed.model.meta.Dashboard;
import org.ok.ed.model.meta.Department;
import org.ok.ed.model.meta.Organization;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class RandomDashboardGenerator {

    private RandomDashboardGeneratorSettings settings;

    public Dashboard generate(String name) {
        return new Dashboard(name, name + settings.getDescriptionSuffix(), generateAccount(name));
    }

    public List<Dashboard> generateMultipleDashboards(int numberOfDashboards, String namePrefix) {
        List<Dashboard> result = new ArrayList<>();
        for(int i=1; i<=numberOfDashboards; i++) {
            result.add(generate(namePrefix + "_" + i));
        }
        return result;
    }

    private Account generateAccount(String dashboardName) {
        return new Account(generateOrganization(dashboardName), generateDepartment(dashboardName));
    }

    private Organization generateOrganization(String dashboardName) {
        return new Organization(dashboardName + settings.getOrganizationNameSuffix(), dashboardName + settings.getOrganizationDescriptionSuffix());
    }

    private Department generateDepartment(String dashboardName) {
        return new Department(dashboardName + settings.getDepartmentNameSuffix(), dashboardName + settings.getOrganizationDescriptionSuffix());
    }
}
