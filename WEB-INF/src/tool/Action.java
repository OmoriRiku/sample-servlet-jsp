//  処理の振り分けを行うActionクラス。

package tool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {

  public abstract String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;

}