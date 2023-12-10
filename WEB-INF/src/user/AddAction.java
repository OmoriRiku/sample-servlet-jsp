//  ユーザーの新規登録を行うAddActionメソッド
//  空文字、パスワードの正規表現でforward先を分ける。

package user;

import tool.Action;
import bean.User;
import dao.UserDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//  正規表現を扱うためのクラス
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddAction extends Action {

  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    //  リクエストパラメータの取得。
    String name = request.getParameter("name");
    String password = request.getParameter("password");

    //  取得したリクエストパラメータでUserオブジェクトを生成する。
    User user = new User();
    user.setName(name);
    user.setPassword(password);

    //  ユーザー名とパスワードの空文字チェック
    if (user.getName().isEmpty() || user.getPassword().isEmpty()) {
      return "adduser-error.jsp";
    }

    //  パスワードの正規表現。英小文字数字を含む4文字以上
    Pattern p = Pattern.compile("(?=.*[a-z])(?=.*[0-9])[a-zA-Z0-9]{4,}");
    Matcher m = p.matcher(user.getPassword());

    //  パスワードが正規表現に一致しているか判定する。一致していればtrueが返る。
    if (m.matches()) {

      //  UserDaoクラスのインスタンス生成。
      UserDao dao = new UserDao();

      //  insert分の実行。戻り値のline変数の宣言。
      int line = dao.insert(user);

      //  ユーザーの新規登録に成功したらadduser-out.jspへforward
      if (line > 0) {
        return "adduser-out.jsp";
      }
    }
    //  入力されたパスワードが正規表現に合わなければadduser-password-error.jspにforwardする。
    return "adduser-password-error.jsp";
  }
}