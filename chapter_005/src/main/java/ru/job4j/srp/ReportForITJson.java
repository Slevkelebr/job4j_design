package ru.job4j.srp;

import java.util.List;

public class ReportForITJson implements Report {

    @Override
    public String row(List<Employer> em) {
        StringBuilder text = new StringBuilder();
        for (Employer employer : em) {
            text.append("{JSON_TITTLE} ").append("Name; Hired; Fired; Salary;").append(" {/JSON_TITTLE}")
                    .append(System.lineSeparator())
                    .append("{JSON_TEXT} ").append(employer.getName()).append(";")
                    .append(employer.getHired().getTime()).append(";")
                    .append(employer.getFired().getTime()).append(";")
                    .append(employer.getSalary()).append(";").append(" {/JSON_TEXT}")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
