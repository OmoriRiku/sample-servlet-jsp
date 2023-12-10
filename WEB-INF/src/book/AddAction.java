//  新規追加用アクション

package book;

import tool.Action;
import bean.Book;
import bean.User;
import dao.BookDao;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AddAction extends Action {

  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    //  セッションの開始
    HttpSession session = request.getSession();

    //  リクエストパラメータの取得
    String title = request.getParameter("title");
    String description = request.getParameter("description");

    //  user_idの取得
    User user = (User)session.getAttribute("user");
    int user_id = user.getId();

    //  取得したリクエストパラメータでbeanクラス（Book)のオブジェクトを生成する。
    Book book = new Book();
    book.setTitle(title);
    book.setDescription(description);

    //  空文字チェック。titleもしくはdescriptionが入力されていなければadd-error.jspへforwardする。
    if (book.getTitle().isEmpty() || book.getDescription().isEmpty()) {
      return "add-error.jsp";
    } 

    //  BookDaoクラスのinsert文を実行する。追加に成功したらadd-out.jspへforwardする。
    BookDao dao = new BookDao();
    int line = dao.insert(book, user_id);
    if (line > 0) {
      return "add-out.jsp";
    }

    //  失敗時にadd-error.jspへforwardする。
    return "add-error.jsp";
  }
}