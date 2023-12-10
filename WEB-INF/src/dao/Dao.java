//  データベース接続用のプログラム
package dao;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

public class Dao {

  //  データソースを保存する変数dsを宣言
  //  一つのフィールドでデータソースを管理する
  static DataSource ds;

  //  データソースへの接続(Connectionオブジェクト)を取得するためのgetConnectionメソッド
  //  DAOクラスのサブクラスで使用する
  public Connection getConnection() throws Exception {

    //  データソースの初期化
    //  DataSourceは参照型フィールドのため、初期値はnull
    if (ds == null) {
      InitialContext ic = new InitialContext();
      ds = (DataSource)ic.lookup("java:/comp/env/jdbc/sample");
    }

    return ds.getConnection();
  }
}
