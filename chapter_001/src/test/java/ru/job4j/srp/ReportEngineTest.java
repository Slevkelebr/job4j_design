package ru.job4j.srp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;


public class ReportEngineTest {

    @Test
    public void whenDisplayEmployeesDescOrderSalaryAndRemoveFieldsHiredAndFired() {
        Store store = null;
        ReportEngine report = new ReportEngine(null);

        String result =  report.generate(employer -> true);

        String expected = "Name; Salary;\nSergey; 100000.0;\nName; Salary;\n Ivan; 80000.0;";

        Assert.assertThat(result, is(expected));
        }

    @Test
    public void whenDisplayEmployeesChangeViewSalary() {
        Store store = null;
        ReportEngine report = new ReportEngine(null);

        String result =  report.generate(employer -> true);

        String expected = "Name; Hired; Fired; Salary;\nSergey; 20.02.2017; 20.02.2020; 100 тыс;";

        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenDisplayEmployeesForProgrammers() {
        Store store = null;
        ReportEngine report = new ReportEngine(null);

        String result =  report.generate(employer -> true);

        String[][] expected = new String[][]{
                {"Name; Hired; Fired; Salary;"},
                {"Sergey;", "20.02.2017", " 20.02.2020", "100000.0;"}
        };

        Assert.assertThat(result, is(expected));
    }
}


