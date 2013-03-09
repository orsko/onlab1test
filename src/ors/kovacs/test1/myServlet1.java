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
	//HTTP get eset�n lefut� k�d
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//A v�lasz t�pusa
		response.setContentType("text/http");
		//Majd ide fogunk �rni
		PrintWriter out = response.getWriter();
		//A ..?param=xxx html param�ter ut�ni string-et k�rj�k le
		String s = request.getParameter("param");
		//ha ez null, akkor nincs param�ter
		if (s == null)
			out.println("NO PARAM");
		//egy�bk�nt pedig vagy egy json objektumot �runk ki, vagy html oldal jelenik meg
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
