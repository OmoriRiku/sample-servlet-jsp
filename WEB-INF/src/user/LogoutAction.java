//  ログアウトを扱うアクション
//  ログインしているユーザーであるか、ログアウトしているか判定して各jspへforwardする。

package user;

import tool.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction extends Action {

  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    //  セッションの開始
    HttpSession session = request.getSession();

    //  現在ログインしているユーザーであるか判定する。
    if (session.getAttribute("user") != null) {
      session.removeAttribute("user");
      return "logout-out.jsp";
    }

    //  ログインしていない場合にはlogout-error.jspへ遷移する。
    return "logout-error.jsp";
  }
}