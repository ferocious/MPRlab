package db.app.servlets.country;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddCountry")
public class AddCountryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	CountryServletLogic logic = new CountryServletLogic();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		logic.addNewCountry(request);
		response.sendRedirect("ShowCountries");
	}
}
