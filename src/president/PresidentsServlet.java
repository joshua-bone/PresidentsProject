package president;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Presidents")
public class PresidentsServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		ArrayList<President> presidents = President.getPresidents();
		ServletContext context = getServletContext();
		context.setAttribute("presidents", presidents);

	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Integer index = (Integer) session.getAttribute("index");
		if (index == null) {
			index = 1;
			session.setAttribute("index", index);
		}
		ServletContext context = getServletContext();
		ArrayList<President> presidents = (ArrayList<President>) context.getAttribute("presidents");
		String direction = req.getParameter("navigate");
		switch (direction) {
		case "forward":
			index ++;
			break;
		case "back":
			index --;
			break;
		}
		RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
		dispatcher.forward(req,  resp);
	}
}
