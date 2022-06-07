package hello2.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start");

        /*final Enumeration<String> parameterNames = request.getParameterNames();
        if (parameterNames.hasMoreElements()) {
            final String parameterName = parameterNames.nextElement();
            System.out.println(parameterName + "=" + request.getParameter(parameterName));
        }*/

        request.getParameterNames().asIterator()
                .forEachRemaining(parameterName -> System.out.println(parameterName + "=" + request.getParameter(parameterName)));
        System.out.println("[전체 파리머터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        final String username = request.getParameter("username");
        System.out.println("request.getParameter(username) = " + username);

        final String age = request.getParameter("age");
        System.out.println("request.getParameter(age) = " + age);
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        System.out.println("request.getParameterValues(username)");
        final String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username=" + name);
        }

        response.getWriter().write("ok");
    }
}
