package co.com.lulobank.certificacion.models;

import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class Employe {

    private String name;
    private String salary;
    private String age;


    public String getName() {
        return name;
    }

    public String getSalary() {
        return salary;
    }

    public String getAge() {
        return age;
    }

    public Employe(DataTable dataTable) {
        List<Map<String, String>> mapList = dataTable.asMaps(String.class, String.class);
        this.name = mapList.get(0).get("name");
        this.salary = mapList.get(0).get("salary");
        this.age = mapList.get(0).get("age");
    }

}
