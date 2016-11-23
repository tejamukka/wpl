package com.biddingproject.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostBid
 */
@WebServlet("/PostBid")
public class PostBid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostBid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String itemname = request.getParameter("itemname");
		String itemdesc = request.getParameter("itemdescription");
		String itemprice = request.getParameter("itemPrice");
		
		request.setAttribute("itemname", itemname);
		request.setAttribute("itemdesc", itemdesc);
		request.setAttribute("itemprice", itemprice);
		
		request.getRequestDispatcher("/ShowcaseBids.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
