package hello2.servlet.web.servlet;

import hello2.servlet.domain.member.Member;
import hello2.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final Enumeration<String> e = request.getParameterNames();
        while (e.hasMoreElements()) {   // 가져온 파라미터 이름들을 루프를 돌려서 전부 뽑아낸다.
            final String paramName = e.nextElement();   // 파라미터 이름들을 하나씩 담는다.
            System.out.println("name = " + paramName);  // 파라미터 이름이 출력된다.
            final String parameter = request.getParameter(paramName);   // 파라미터에 루프를 돌린 이름들을 넣고 value를 가져온다.
            System.out.println("parameter = " + parameter);     // 요청 파라미터의 이름이 아닌 값들이 출력된다.
        }

        final String[] parameterValues = request.getParameterValues("username");    // username으로 된 파라미터들의 value들을 전부 가져온다.
        for (String parameterValue : parameterValues) {
            System.out.println("parameterValue = " + parameterValue);
        }
        final List<Member> members = memberRepository.findAll();

    }
}
