import java.util.List;

public class Employee {
  private String name;
  private short age;
  private List<Project> projects;
  private int salary;

  public String getName() {
    return name;
  }

  public void setName(){
    this.name = name;
  }

  public short getAge(){
    return age;
  }

  public int getSalary(){
    return salary;
  }

  public List<Project> getProjects() {
    return projects;
  }

  Employee(String name, short age, List<Project> projects, int salary) {
    this.name = name;
    this.age = age;
    this.projects = projects;
    this.salary = salary;
  }

  @Override
  public String toString() {
    return name + ", " + age + " y.o., salary: " + salary;
  }
}
