package db.app.servlets.airline;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddAirline")
public class AddAirlineServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	AirlineServletLogic logic = new AirlineServletLogic();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		logic.addNewAirline(request);
		response.sendRedirect("ShowAirlines");
	}
}
