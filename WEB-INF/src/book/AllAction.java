//  一覧用アクション
//  各アクションはtool.Actionクラスを継承する。
package book;

import tool.Action;
import dao.BookDao;
import bean.Book;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AllAction extends Action {

  public String execute (HttpServletRequest request, HttpServletResponse response) throws Exception {
    //  セッションを開始する。
    HttpSession session = request.getSession();

    //  ログインしていなければ、ログインページを表示する。
    if (session.getAttribute("user") == null) {
      return "../user/login-in.jsp";
    }

    // BookDaoクラスのインスタンスの生成と全情報の取得をList<Book>型へ変換
    BookDao dao = new BookDao();
    List<Book> list = dao.all();

    //  リクエスト属性の名前をlistに指定して受け渡す。
    request.setAttribute("list", list);

    //  all-out.jspへforwardする。
    return "all-out.jsp";
  }
}