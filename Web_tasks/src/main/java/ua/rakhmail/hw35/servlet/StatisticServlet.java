package ua.rakhmail.hw35.servlet;

import com.google.gson.Gson;
import ua.rakhmail.hw35.services.VisitService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class StatisticServlet extends HttpServlet {
    private final static VisitService visitService = VisitService.getSingleton();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        String json = new Gson().toJson(visitService.getStats());
        writer.println(json);
    }
}
