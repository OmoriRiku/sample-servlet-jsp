//  beanクラスのBook。
//  各テーブルの列のセッターとゲッターを準備する。
package bean;

public class Book implements java.io.Serializable {
  private int id;
  private String title;
  private String description;
  private int userId;

  public int getId() {
    return this.id;
  }

  public String getTitle() {
    return this.title;
  }

  public String getDescription() {
    return this.description;
  }

  public int getUserId() {
    return this.userId;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }
}