//  全ページ共通のFilter
//  文字のエンコーディングの指定とMIMEタイプの指定を行う

package tool;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns={"/*"})

public class EncodingFilter implements Filter {

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
    //  リクエストパラメータの文字エンコーディングの指定
    request.setCharacterEncoding("UTF-8");

    //  サーブレットで出力する時のMIMEタイプ。文字エンコーディングの指定
    response.setContentType("text/html; charset=UTF-8");

    chain.doFilter(request, response);
  }

  //  サーブレット実行時の呼び出し
  public void init(FilterConfig config) {}

  //  サーブレット終了時の呼び出し
  public void destroy() {}

}