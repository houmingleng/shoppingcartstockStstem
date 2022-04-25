package com.uplooking.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uplooking.pojo.Tbl_sj_order;
import com.uplooking.service.Tbl_sj_orderService;
import com.uplooking.service.Tbl_sj_orderServiceImpl;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               request.setCharacterEncoding("UTF-8");
               response.setCharacterEncoding("UTF-8");
               response.setContentType("text/html;charset=utf-8");
               Tbl_sj_orderService tsos = new Tbl_sj_orderServiceImpl();
               List<Tbl_sj_order> lists = tsos.findAll();
               System.out.println(lists);
               JSONArray jsonArray = JSONArray.fromObject(lists);
               response.getWriter().write(jsonArray.toString());

	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
