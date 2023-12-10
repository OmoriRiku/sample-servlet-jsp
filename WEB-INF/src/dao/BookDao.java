//  データベースの処理を行うBookDaoクラス
package dao;

import bean.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class BookDao extends Dao {

  //  登録されたすべてのデータを表示する
  public List<Book> all() throws Exception {
    //  検索結果を格納するlist変数の宣言
    List<Book> list = new ArrayList<>();

    //  データベースへの接続
    Connection con = getConnection();

    //  sql文の発行。
    PreparedStatement st = con.prepareStatement("select * from book");

    //  結果をResultSetオブジェクトに格納
    ResultSet rs = st.executeQuery();

    //  実行結果を一つ一つlistへ格納する
    while(rs.next()) {
      Book book = new Book();
      book.setId(rs.getInt("id"));
      book.setTitle(rs.getString("title"));
      book.setDescription(rs.getString("description"));
      book.setUserId(rs.getInt("user_id"));
      list.add(book);
    }

    //  リソースの解放
    st.close();
    con.close();

    return list;
  }

  //  リクエストパラメータで渡されたidで該当のList<Book>を返却するfindメソッド
  public Book findBook (int id) throws Exception {
    Book book = null;

    //  データベースへの接続
    Connection con = getConnection();

    //  sql文の発行
    PreparedStatement st = con.prepareStatement("select * from book where id = ?");
    st.setInt(1, id);

    //  結果をResultSetオブジェクトに格納
    ResultSet rs = st.executeQuery();

    //  カーソルを一つ進める。
    rs.next();

    //  Bookインスタンスの生成と、該当の列の値を取得する。
    //  取得した結果はlistへ変換。
    book = new Book();
    book.setId(rs.getInt("id"));
    book.setTitle(rs.getString("title"));
    book.setDescription(rs.getString("description"));
    book.setUserId(rs.getInt("user_id"));

    //  リソースの解放
    st.close();
    con.close();

    return book;
  }

  //  Bookテーブル追加のinsertメソッド
  public int insert(Book book, int user_id) throws Exception {
    //  データベース接続情報の取得
    Connection con = getConnection();

    //  sql文の発行。
    PreparedStatement st = con.prepareStatement("insert into book (title, description, user_id) values (?, ?, ?) ");
    st.setString(1, book.getTitle());
    st.setString(2, book.getDescription());
    st.setInt(3, user_id);

    // 発行したSQL文により変更された行をline変数へ格納。変更されない場合0が返る。
    int line = st.executeUpdate();

    //  リソースの解放
    st.close();
    con.close();

    return line;
  }

  //  Bookテーブルの削除のdeleteメソッド
  public int delete(int id) throws Exception {

    //  データベースへの接続情報をConnection型の変数conへ代入する。
    Connection con = getConnection();

    //  sql文の発行
    PreparedStatement st = con.prepareStatement("delete from book where id = ?");
    st.setInt(1, id);

    //  発行したSQL文により変更された行をline変数へ格納。変更されない場合0が返る。
    int line = st.executeUpdate();

    //  リソースの解放
    st.close();
    con.close();

    return line;
  }

  //  Bookテーブルの情報更新のupdateメソッド
  public int update(Book book) throws Exception {

    //  データベース接続情報を取得。
    Connection con = getConnection();

    //  sql文の発行。
    PreparedStatement st = con.prepareStatement("update book set title = ?, description = ? where id = ?");
    st.setString(1, book.getTitle());
    st.setString(2, book.getDescription());
    st.setInt(3, book.getId());

    //  発行したSQL文により変更された行をline変数へ格納。変更されない場合0が返る。
    int line = st.executeUpdate();

    //  リソースの解放
    st.close();
    con.close();

    return line;
  }
}