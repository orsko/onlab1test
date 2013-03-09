package ors.kovacs.test1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class myServlet1
 */
@WebServlet("/myServlet1")
public class myServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public myServlet1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	//HTTP get esetén lefutó kód
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//A válasz típusa
		response.setContentType("text/http");
		//Majd ide fogunk írni
		PrintWriter out = response.getWriter();
		//A ..?param=xxx html paraméter utáni string-et kérjük le
		String s = request.getParameter("param");
		//ha ez null, akkor nincs paraméter
		if (s == null)
			out.println("NO PARAM");
		//egyébként pedig vagy egy json objektumot írunk ki, vagy html oldal jelenik meg
		else if (s.equals("json")){
		     String returnS = new String("{\"Keresztnev\":\"Ors\", \"Vezeteknev\":\"Kovacs\"}");
		     out.print(returnS);
		     out.flush();
		}
		else if (s.equals("html")){
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 "
					+ "Transitional//EN\">\n" + "<HTML>\n"
					+ "<HEAD><TITLE>Hello Servlet</TITLE></HEAD>\n" + "<BODY>\n"
					+ "<H1>Hello Servlet</H1>\n" + "</BODY></HTML>");
		}

	}

}
