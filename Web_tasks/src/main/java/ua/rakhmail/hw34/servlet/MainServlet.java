package ua.rakhmail.hw34.servlet;

import ua.rakhmail.hw34.servlet.utils.ListInfo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MainServlet extends HttpServlet {
    ListInfo userInfo = new ListInfo();

    @Override
    public void init() {
        userInfo.addUsers("127.0.0.1", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:71.0) Firefox/71.0");
        userInfo.addUsers("127.0.0.3", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:71.0) Firefox/71.0");
        userInfo.addUsers("127.0.0.6", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:71.0) Firefox/71.0");
        userInfo.addUsers("127.0.0.5", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:71.0) Firefox/71.0");
        userInfo.addUsers("127.0.0.4", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:71.0) Firefox/71.0");
        userInfo.addUsers("127.0.0.7", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:71.0) Firefox/71.0");
        userInfo.addUsers("127.0.0.8", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:71.0) Firefox/71.0");
        userInfo.addUsers("127.0.0.9", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:71.0) Firefox/71.0");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter responseBody = resp.getWriter();
        resp.setContentType("text/html");
        responseBody.println("<h1 align=\"center\">There is a list of users</h1>");

        userInfo.addUsers(req.getRemoteAddr(), req.getHeader("user-agent"));

        userInfo.getUserInfo().forEach((key, value) -> {
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
        responseBody.println("<h3 align=\"center\"><a href=\"http://localhost:8080\"><-- you can tap here for BACK</a></h3>");
    }
}
