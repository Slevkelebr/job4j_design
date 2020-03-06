package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportForIT extends ReportEngine {
    public ReportForIT(Store store) {
        super(store);
    }

    @Override
    public String reportForProgrammers(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        for (Employer employer : store.findBy(filter)) {
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
