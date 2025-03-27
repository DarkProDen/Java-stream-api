public class Project {
  private String name;
  private int duration;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getDuration(){
    return duration;
  }

  Project(String name, int duration) {
    this.name = name;
    this.duration = duration;
  }

  @Override
  public String toString() {
    return name + " duration: " + duration;
  }
}
