package ru.job4j.srp;

import java.util.List;

public class ReportForITJText implements Report {
    @Override
    public String row(List<Employer> em) {
        StringBuilder text = new StringBuilder();
        for (Employer employer : em) {
            text.append("Name; Hired; Fired; Salary;")
                    .append(System.lineSeparator())
                    .append(employer.getName()).append(";")
                    .append(employer.getHired().getTime()).append(";")
                    .append(employer.getFired().getTime()).append(";")
                    .append(employer.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
