package mx.edu.utez.vbo_servlets3a.controller.person;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.edu.utez.vbo_servlets3a.model.person.BeanPerson;
import mx.edu.utez.vbo_servlets3a.model.person.DaoPerson;

import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "servletperson", urlPatterns = {
        "/getPersons",
        "/createPersons",
        "/deletePersons",
        "/updatePersons",
}
)
public class ServletPerson extends HttpServlet {
    private String action;
    private String redirect = "/getPersons";


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath();

        switch (action) {
            case "/getPersons":
                List<BeanPerson> personList = DaoPerson.findPersons();
                System.out.println(personList.size());
                request.setAttribute("personList", personList);
                redirect = "/view/person/indexPersons.jsp";
                break;
            case "/createPersons":
                redirect = "/view/person/createPersons.jsp";
                break;

            default:
                redirect = "/getPersons";

        }
        request.getRequestDispatcher(redirect).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
