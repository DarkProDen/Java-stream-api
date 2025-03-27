import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


public class Main {
  public static void main(String[] args) {
    Random rand = new Random();

    ArrayList<Employee> employees = new ArrayList<Employee>();

    for (int i = 0; i < 50; i++) {
      List<Project> projects = List.of(
          new Project("project_name_" + i + "_01", rand.nextInt(12)),
          new Project("project_name_" + i + "_02", rand.nextInt(12))
      );

      Employee employee = new Employee("name_" + i,
          (short) rand.nextInt(100),
          projects,
          rand.nextInt(120000));
      System.out.println(employee);
      System.out.println(employee.getProjects());
      employees.add(employee);
    }

    System.out.println("======================================================================================================");
    System.out.println("Оставить только тех сотрудников, у которых возраст от 30 до 50 лет и зарплата выше 60,000");
    System.out.println("======================================================================================================");

    List<Employee> filteredList = employees
        .stream()
        .filter(employee ->
            employee.getAge() >= 30 &&
                employee.getAge() <= 50 &&
                employee.getSalary() > 60000)
        .toList();

    filteredList.forEach(employee -> {
      System.out.println(employee);
      System.out.println(employee.getProjects());
    });

    System.out.println("======================================================================================================");
    System.out.println("Извлечь все названия проектов из списка сотрудников в одном потоке.");
    System.out.println("======================================================================================================");

    List<String> projectsNames = employees.stream()
        .map(Employee::getProjects)
        .flatMap(List::stream)
        .map(Project::getName)
        .toList();

    System.out.println(projectsNames);

    System.out.println("======================================================================================================");
    System.out.println("Извлечь только те проекты, длительность которых больше 6 месяцев.");
    System.out.println("======================================================================================================");

    List<Project> filteredProjects = employees.stream()
        .map(Employee::getProjects)
        .flatMap(List::stream)
        .filter(project -> project.getDuration() > 6)
        .toList();

    filteredProjects.forEach(System.out::println);

    System.out.println("======================================================================================================");
    System.out.println("Преобразовать все названия проектов в верхний регистр.");
    System.out.println("======================================================================================================");

    employees.stream()
        .map(Employee::getProjects)
        .flatMap(List::stream)
        .forEach(project -> project.setName(project.getName().toUpperCase()));

    employees.forEach(employee -> {
      employee.getProjects().forEach(System.out::println);
    });

    System.out.println("======================================================================================================");
    System.out.println("Сортировать проекты по длительности (по убыванию).");
    System.out.println("======================================================================================================");

    List<Project> sortedProjects = employees.stream()
        .map(Employee::getProjects)
        .flatMap(List::stream)
        .sorted(Comparator.comparingInt(Project::getDuration))
        .toList();

    sortedProjects.forEach(System.out::println);

    System.out.println("==================================");
  }
}