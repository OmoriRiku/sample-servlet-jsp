//  ユーザーのログイン用アクション
//  ログインに成功した場合、beanクラスUser型のuserでセッションを開始する。

package user;

import tool.Action;
import dao.UserDao;
import bean.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAction extends Action {

  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    //  セッションを開始する。
    HttpSession session = request.getSession();

    //  リクエストパラメータの取得
    String name = request.getParameter("name");
    String password = request.getParameter("password");

    //  UserDaoクラスのインスタンスの生成
    UserDao dao = new UserDao();
    //  searchメソッドの実行結果をUser型のuser変数に格納する。
    User user = dao.search(name, password);

    //  ユーザーが存在すれば、userセッションの開始
    if (user != null) {
      session.setAttribute("user", user);
      return "login-out.jsp";
    }

    //  存在しなければ、ログインエラーのページを表示する。
    return "login-error.jsp";
  }
}