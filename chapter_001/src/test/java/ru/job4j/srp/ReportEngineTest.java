package ru.job4j.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Calendar;


public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired().getTime()).append(";")
                .append(worker.getFired().getTime()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenDisplayEmployeesDescOrderSalaryAndRemoveFieldsHiredAndFired() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Puckan", now, now, 80);
        Employer worker1 = new Employer("Gorit", now, now, 100);
        store.add(worker);
        store.add(worker1);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator())
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.reportForHR(em -> true), is(expect.toString()));
    }

    @Test
    public void whenDisplayEmployeesChangeViewSalary() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired().getTime()).append(";")
                .append(worker.getFired().getTime()).append(";")
                .append(worker.getSalary()).append(" тыс").append(";")
                .append(System.lineSeparator());
        assertThat(engine.reportForAccounting(em -> true), is(expect.toString()));
    }

    @Test
    public void whenDisplayEmployeesForProgrammers() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Puckan", now, now, 80);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        Report report = new ReportForITHtml();
        StringBuilder expect = new StringBuilder()
                .append("{TITTLE} Name; Hired; Fired; Salary; {/TITTLE}")
                .append(System.lineSeparator())
                .append("{TEXT} ").append(worker.getName()).append(";")
                .append(worker.getHired().getTime()).append(";")
                .append(worker.getFired().getTime()).append(";")
                .append(worker.getSalary()).append(";").append(" {/TEXT}")
                .append(System.lineSeparator());
        assertThat(engine.reportForProgrammers(report, em -> true), is(expect.toString()));
    }

    @Test
    public void whenDisplayEmployeesForProgrammersJson() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Puckan", now, now, 80);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        Report report = new ReportForITJson();
        StringBuilder expect = new StringBuilder()
                .append("{JSON_TITTLE} Name; Hired; Fired; Salary; {/JSON_TITTLE}")
                .append(System.lineSeparator())
                .append("{JSON_TEXT} ").append(worker.getName()).append(";")
                .append(worker.getHired().getTime()).append(";")
                .append(worker.getFired().getTime()).append(";")
                .append(worker.getSalary()).append(";").append(" {/JSON_TEXT}")
                .append(System.lineSeparator());
        assertThat(engine.reportForProgrammers(report, em -> true), is(expect.toString()));
    }

}


