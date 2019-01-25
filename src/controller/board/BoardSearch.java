package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Article;
import board.Service;
import board.ServiceImpl;

/**
 * Servlet implementation class BoardSearch
 */
@WebServlet("/BoardSearch")
public class BoardSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Service service = new ServiceImpl();
		
		//int num = Integer.parseInt(request.getParameter("num"));
		String searchCheck = request.getParameter("searchCheck");
		ArrayList<Article> list = null;
		String search = request.getParameter("search");

		if(searchCheck.equals("writer")) {
			list = service.getByWriter(search);
			
			System.out.println(list.size());
			int size = list.size()-1;
			request.setAttribute("listLength", size);
			
		}else if(searchCheck.equals("title")) {
			list = service.getByTitle(search);
		}

		request.setAttribute("list", list);

		String result = "/board/searchForm.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(result);
		if(dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
