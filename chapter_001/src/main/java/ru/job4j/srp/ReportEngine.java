package ru.job4j.srp;

import java.util.List;
import java.util.function.Predicate;

public class ReportEngine {
    protected Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employer employer : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(employer.getName()).append(";")
                    .append(employer.getHired().getTime()).append(";")
                    .append(employer.getFired().getTime()).append(";")
                    .append(employer.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    public String reportForHR(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        List<Employer> em = store.findBy(filter);
        em.sort(new SortDescSalary());
        for (Employer employer : em) {
            text.append("Name; Salary;")
                    .append(System.lineSeparator())
                    .append(employer.getName()).append(";")
                    .append(employer.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    public String reportForProgrammers(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        for (Employer employer : store.findBy(filter)) {
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

    public String reportForAccounting(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employer employer : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(employer.getName()).append(";")
                    .append(employer.getHired().getTime()).append(";")
                    .append(employer.getFired().getTime()).append(";")
                    .append(employer.getSalary()).append(" тыс").append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();

    }
}
