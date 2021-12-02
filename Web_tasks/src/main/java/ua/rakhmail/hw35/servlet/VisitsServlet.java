package ua.rakhmail.hw35.servlet;

import com.google.gson.Gson;
import ua.rakhmail.hw35.objects.Visit;
import ua.rakhmail.hw35.services.VisitService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class VisitsServlet extends HttpServlet {
    private final static VisitService visitService = VisitService.getSingleton();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        String json = new Gson().toJson(visitService.getVisits());
        writer.println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        PrintWriter responseBody = resp.getWriter();
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String date = req.getParameter("date");
        String city = req.getParameter("city");
        Visit visit = new Visit(name, date, city);
        visitService.addVisit(visit);
    }

}
