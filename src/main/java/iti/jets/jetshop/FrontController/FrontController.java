package iti.jets.jetshop.FrontController;

import iti.jets.jetshop.FrontController.ViewResolve.ViewResolver;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class FrontController extends HttpServlet {
    private static final String CONTROLLER_NAME = "controller";

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void processRequest(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        String controllerName =  request.getParameter(CONTROLLER_NAME);
        System.out.println(" Controller is: " + controllerName);
        if(controllerName == null) {
            response.sendRedirect("/JetShop/index.jsp");
            return;
        }

        ControllerFactory factory = new ControllerFactory();
        ControllerInt controller = factory.getController(controllerName);
        ViewResolver resolver = controller.resolve(request, response);
        dispatch(request, response, resolver);
    }

    private void dispatch(final HttpServletRequest request, final HttpServletResponse response,
                          final ViewResolver resolver) throws ServletException, IOException {

        String view = resolver.getView();
        switch (resolver.getResolveAction()) {
            case FORWARD:
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(view);
                dispatcher.forward(request, response);
                break;
            case REDIRECT:
                response.sendRedirect(view);
                break;

            default:
                break;
        }

    }

}