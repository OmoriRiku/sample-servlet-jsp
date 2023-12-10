package dao;

import bean.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao extends Dao {

  //  ログイン時のuser情報の取得を行うsearchメソッド
  public User search(String name, String password) throws Exception {
    User user = null;

    Connection con = getConnection();

    PreparedStatement st;
    st = con.prepareStatement("select * from user where name = ? and password = ?");
    st.setString(1, name);
    st.setString(2, password);
    ResultSet rs = st.executeQuery();

    while (rs.next()) {
      user = new User();
      user.setId(rs.getInt("id"));
      user.setName(rs.getString("name"));
      user.setPassword(rs.getString("password"));
    }

    st.close();
    con.close();

    return user;
  }

  // bookテーブルから渡されたuser_idで特定のユーザーを見つけるfindBookUserメソッド
  public User findBookUser(int userId) throws Exception {
    User user = null;
    Connection con = getConnection();

    PreparedStatement st;
    st = con.prepareStatement(
      "select user.id, user.name, user.password from user inner join book on book.user_id = user.id where user.id = ?");
    st.setInt(1, userId);
    ResultSet rs = st.executeQuery();
    
    while (rs.next()) {
      user = new User();
      user.setId(rs.getInt("id"));
      user.setName(rs.getString("name"));
      user.setPassword(rs.getString("password"));
    }

    st.close();
    con.close();

    return user;
  }

  //  userの新規登録を行うinsertメソッド
  public int insert(User user) throws Exception {
    Connection con = getConnection();

    PreparedStatement st;
    st = con.prepareStatement("insert into user (name, password) values (?, ?)");
    st.setString(1, user.getName());
    st.setString(2, user.getPassword());
    int line = st.executeUpdate();

    st.close();
    con.close();

    return line;
  }
}