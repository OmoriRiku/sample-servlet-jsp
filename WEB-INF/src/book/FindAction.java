//  特定のIDの情報を取得するFindアクション
//  各アクションはtool.Actionクラスを継承する。
package book;

import tool.Action;
import bean.Book;
import bean.User;
import dao.BookDao;
import dao.UserDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindAction extends Action {

  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    //  Bookのid情報の取得に失敗した場合、error.jspへforwardする。
    if (request.getParameter("id") == null) return "error.jsp";

    //  リクエストパラメータの取得
    int id = Integer.parseInt(request.getParameter("id"));

    //  BookDaoクラスのインスタンスの生成
    BookDao bookDao = new BookDao();
    //  取得したbookのidからbookテーブルの情報を取得するfindメソッド
    Book book = bookDao.findBook(id);
    //  Bookの情報をリクエスト属性でビューへ受け渡す(名前はbook)
    request.setAttribute("book", book);

    //  UserDaoクラスのインスタンスの生成
    UserDao userDao = new UserDao();
    //  bookテーブルのuser_idから特定のユーザーの情報を取得するfindUserメソッド
    User user = userDao.findBookUser(book.getUserId());
    //  Userの情報をリクエスト属性でビューへ受け渡す(名前はuser)
    request.setAttribute("user", user);

    //  find-out.jspへforwardする。
    return "find-out.jsp";
  }
}