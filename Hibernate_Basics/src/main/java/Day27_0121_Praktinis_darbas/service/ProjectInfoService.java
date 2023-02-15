package Day27_0121_Praktinis_darbas.service;


import Day27_0121_Praktinis_darbas.entity.Project;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class ProjectInfoService {

    public List<Project> findWithMostEmployees(List<Project> projects) {
        OptionalInt biggestEmployeeCount = projects.stream()
                .mapToInt(project -> project.getEmployees().size()).max();
        return projects.stream()
                .filter(project -> project.getEmployees().size() == biggestEmployeeCount.getAsInt())
                .collect(Collectors.toList());
    }

    public List<Project> findWithMostIncome(List<Project> projects) {
        OptionalInt mostIncome = projects.stream()
                .mapToInt(Project::getProjectIncome).max();
        return projects.stream()
                .filter(project -> project.getProjectIncome() == mostIncome.getAsInt())
                .collect(Collectors.toList());
    }

    public List<Project> findWithMostCosts(List<Project> projects) {
        OptionalInt mostCost = projects.stream()
                .mapToInt(Project::getProjectCosts).max();
        return projects.stream()
                .filter(project -> project.getProjectCosts() == mostCost.getAsInt())
                .collect(Collectors.toList());
    }

    public List<Project> findWithBiggestGeneratedEmployeeValue(List<Project> projects) {
        OptionalInt biggestEmployeeAverage = projects.stream()
                .mapToInt(project -> project.getProjectIncome() / project.getEmployees().size()).max();
        return projects.stream()
                .filter(project -> project.getProjectIncome() / project.getEmployees().size() == biggestEmployeeAverage.getAsInt())
                .collect(Collectors.toList());

    }

    public List<Project> findWithMostProfit(List<Project> projects) {
        OptionalInt mostProfit = projects.stream()
                .mapToInt(project -> project.getProjectIncome() - project.getProjectCosts()).max();
        return projects.stream()
                .filter(project -> project.getProjectIncome() - project.getProjectCosts() == mostProfit.getAsInt())
                .collect(Collectors.toList());
    }

    public List<Project> findLongest(List<Project> projects) {
        OptionalInt longest = projects.stream()
                .mapToInt(project -> project.getDurationInWeeks()).max();
        return projects.stream()
                .filter(project -> project.getDurationInWeeks() == longest.getAsInt())
                .collect(Collectors.toList());
    }

    public List<Project> findShortest(List<Project> projects) {
        OptionalInt shortest = projects.stream()
                .mapToInt(project -> project.getDurationInWeeks()).min();
        return projects.stream()
                .filter(project -> project.getDurationInWeeks() == shortest.getAsInt())
                .collect(Collectors.toList());
    }
}
