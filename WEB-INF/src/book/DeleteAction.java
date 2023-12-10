//  削除用アクション
//  各アクションはtool.Actionクラスを継承する。
package book;

import tool.Action;
import bean.Book;
import dao.BookDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteAction extends Action {

  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    //  id情報の取得に失敗した場合、error.jspへforwardする。
    if (request.getParameter("id") == null) return "error.jsp";
    
    //  リクエストパラメータの取得
    int id = Integer.parseInt(request.getParameter("id"));

    //  BookDaoクラスのdeleteメソッドを使用するためインスタンスの生成とdeleteメソッドの実行。
    //  発行したSQL文により変更された行をline変数へ格納。変更されない場合0が返る。
    BookDao dao = new BookDao();
    int line = dao.delete(id);

    //  変更された場合のforward処理
    if (line > 0) {
      return "delete-out.jsp";
    }

    //  変更されなかった場合のforward処理
    return "delete-error.jsp";
  }
}