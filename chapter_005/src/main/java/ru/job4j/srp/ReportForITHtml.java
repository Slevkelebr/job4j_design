package ru.job4j.srp;

import java.util.List;

public class ReportForITHtml implements Report {
    @Override
    public String row(List<Employer> em) {
        StringBuilder text = new StringBuilder();
        for (Employer employer : em) {
            text.append("{TITTLE} ").append("Name; Hired; Fired; Salary;").append(" {/TITTLE}")
                    .append(System.lineSeparator())
                    .append("{TEXT} ").append(employer.getName()).append(";")
                    .append(employer.getHired().getTime()).append(";")
                    .append(employer.getFired().getTime()).append(";")
                    .append(employer.getSalary()).append(";").append(" {/TEXT}")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
