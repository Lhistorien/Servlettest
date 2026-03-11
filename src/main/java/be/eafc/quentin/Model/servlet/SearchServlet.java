package be.eafc.quentin.Model.servlet;

import be.eafc.quentin.Model.facade.UserFacade;
import be.eafc.quentin.dto.SearchResponse;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SearchServlet extends HttpServlet {

    private Gson gson = new Gson();
    private UserFacade userFacade;

    @Override
    public void init() throws ServletException {
        super.init();
        this.userFacade = new UserFacade();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=UTF-8");

        String name =  request.getParameter("name");

        if (name == null || name.trim().isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            SearchResponse errorResp = new SearchResponse("Enter name (first name lastname");
            response.getWriter().write(gson.toJson(errorResp));
            return;
        }

        String[] parts = name.split(" ");

        if (parts.length < 2) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            SearchResponse errorResp = new SearchResponse("Enter name (first name lastname");
            response.getWriter().write(gson.toJson(errorResp));
            return;
        }

        boolean exists = userFacade.userExists(parts[0], parts[1]);

        SearchResponse resp = new SearchResponse(name, exists);
        response.getWriter().write(gson.toJson(resp));
    }
}
