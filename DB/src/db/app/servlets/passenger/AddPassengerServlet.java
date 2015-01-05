package db.app.servlets.passenger;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("AddPassenger")
public class AddPassengerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private PassengerServletLogic logic = new PassengerServletLogic();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		logic.addNewPassenger(request);
		response.sendRedirect("ShowPassengers");
	}
}
