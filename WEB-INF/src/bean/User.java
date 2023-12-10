package bean;

public class User implements java.io.Serializable {

  private int id;
  private String name;
  private String password;

  public int getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getPassword() {
    return this.password;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}