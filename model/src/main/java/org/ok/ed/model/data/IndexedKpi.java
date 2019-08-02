package org.ok.ed.model.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ok.ed.model.meta.*;

@Data
@AllArgsConstructor
public class IndexedKpi {

    private String kpiName;

    private String kpiDescription;

    private String objectiveName;

    private String objectiveDescription;

    private String goalName;

    private String goalDescription;

    private String themeName;

    private String themeDescription;

    private String dashboardName;

    private String dashboardDescription;

    private String organizationName;

    private String organizationDescription;

    private String departmentName;

    private String departmentDescription;

    private String timePeriod;

    private Integer value;

    public IndexedKpi(Kpi kpi) {
        KpiDefinition kpiDefinition = kpi.getKpiDefinition();
        this.kpiName = kpiDefinition.getName();
        this.kpiDescription = kpiDefinition.getDescription();
        Objective objective = kpiDefinition.getObjective();
        this.objectiveName = objective.getName();
        this.objectiveDescription = objective.getDescription();
        Goal goal = objective.getGoal();
        this.goalName = goal.getName();
        this.goalDescription = goal.getDescription();
        Theme theme = goal.getTheme();
        this.themeName = theme.getName();
        this.themeDescription = theme.getDescription();
        Dashboard dashboard = theme.getDashboard();
        this.dashboardName = dashboard.getName();
        this.dashboardDescription = dashboard.getDescription();
        Account account = dashboard.getAccount();
        Organization organization = account.getOrganization();
        this.organizationName = organization.getName();
        this.organizationDescription = organization.getDescription();
        Department department = account.getDepartment();
        this.departmentName = department.getName();
        this.departmentDescription = department.getDescription();
        this.timePeriod = kpi.getTimePeriod();
        this.value = kpi.getValue();
    }

    public Kpi toKpi() {
        return new Kpi(
                new KpiDefinition(
                        kpiName,
                        kpiDescription,
                        new Objective(
                                objectiveName,
                                objectiveDescription,
                                new Goal(
                                        goalName,
                                        goalDescription,
                                        new Theme(
                                                themeName,
                                                themeDescription,
                                                new Dashboard(
                                                        dashboardName,
                                                        dashboardDescription,
                                                        new Account(
                                                                new Organization(
                                                                        organizationName,
                                                                        organizationDescription
                                                                ),
                                                                new Department(
                                                                        departmentName,
                                                                        departmentDescription
                                                                )
                                                        )
                                                )
                                        )
                                )
                        ),
                        null
                ),
                timePeriod,
                value
        );
    }
}
