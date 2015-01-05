package db.app.servlets.passenger;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("ShowPassengers")
public class ShowPassengersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private PassengerServletLogic logic = new PassengerServletLogic();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.getWriter().print(logic.showPassengersInHtmlForm());
	}
}
