package db.app.servlets.flight;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("AddAirport")
public class AddAirportServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private AirportServletLogic logic = new AirportServletLogic();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		logic.addNewAirport(request);
		response.sendRedirect("ShowAirports");
	}
}
