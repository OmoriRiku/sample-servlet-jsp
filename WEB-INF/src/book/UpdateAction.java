//  更新用アクション
//  各アクションはtool.Actionクラスを継承する。
package book;

import tool.Action;
import bean.Book;
import dao.BookDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateAction extends Action {

  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    //  id情報の取得に失敗した場合、error.jspへforwardする。
    if (request.getParameter("id") == null) return "error.jsp";
    
    //  リクエストパラメータの取得
    int id = Integer.parseInt(request.getParameter("id"));
    String title = request.getParameter("title");
    String description = request.getParameter("description");

    //  Bookオブジェクトを生成と取得したリクエストパラメータの値を入れ込む。
    Book book = new Book();
    book.setId(id);
    book.setTitle(title);
    book.setDescription(description);

    //  入力した文字の空文字チェック
    if (book.getTitle().isEmpty() || book.getDescription().isEmpty()) {
      return "update-error.jsp";
    }

    //  BookDaoクラスのupdate実行
    BookDao dao = new BookDao();
    int line = dao.update(book);

    //  成功時にupdate-out.jspへforwardする。
    if (line > 0) {
      return "update-out.jsp";
    }

    //  失敗時にupdate-error.jspへforwardする。
    return "update-error.jsp";
  }
}