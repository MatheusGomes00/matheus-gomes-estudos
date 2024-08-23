package comparable.entities;

public class Employee implements Comparable<Employee>{

    private String name;
    private Double salary;

    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee otherObj) {
        // no retorno desta função está sendo comparado em ordem crescente
        // se colocarmos um - na frente, fica em ordem decrescente
        // podemos chamar também o salary.compareTo(otherObj.getSalary()
        return name.compareTo(otherObj.getName());
    }
}
