package ua.rakhmail.hw34.servlet;

import ua.rakhmail.hw34.servlet.utils.ListInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class MainServlet extends HttpServlet {
    ListInfo userInfo = new ListInfo();

    @Override
    public void init() throws ServletException {
        userInfo.getUserInfo().put("127.0.0.1", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:71.0) Firefox/71.0");
        userInfo.getUserInfo().put("127.0.0.3", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:71.0) Firefox/71.0");
        userInfo.getUserInfo().put("127.0.0.6", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:71.0) Firefox/71.0");
        userInfo.getUserInfo().put("127.0.0.5", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:71.0) Firefox/71.0");
        userInfo.getUserInfo().put("127.0.0.4", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:71.0) Firefox/71.0");
        userInfo.getUserInfo().put("127.0.0.7", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:71.0) Firefox/71.0");
        userInfo.getUserInfo().put("127.0.0.8", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:71.0) Firefox/71.0");
        userInfo.getUserInfo().put("127.0.0.9", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:71.0) Firefox/71.0");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter responseBody = resp.getWriter();
        resp.setContentType("text/html");
        responseBody.println("<h1 align=\"center\">There is a list of users</h1>");

        userInfo.getUserInfo().put(req.getRemoteAddr(), req.getHeader("user-agent"));
        long skip = 0;
        if (userInfo.getUserInfo().size() > 5) {
            skip = userInfo.getUserInfo().size() - 5;
        }

        userInfo.getUserInfo().entrySet().stream()
                .skip(skip)
                .forEach(x -> {
                    String key = x.getKey();
                    String value = x.getValue();
                    if (value.equals(req.getHeader("user-agent")) && key.equals(req.getRemoteAddr())) {
                        responseBody.println("<main align=\"center\"><b>Request from: " + "IP: " + key + ", Browser: " + value + "</b></main>");
                    } else {
                        responseBody.println("<main align=\"center\">Request from: " + "IP: " + key + ", Browser: " + value + "</main>");
                    }
                });

        String client = req.getParameter("client");
        if (client == null) {
            client = "Anonymous";
        }
        responseBody.println("<h3 align=\"center\">Hello, " + client + " </h3>");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        super.doPost(req, resp);
    }
    @Override
    public void destroy() {
        System.out.println(getServletName() + " destroyed");
    }

}