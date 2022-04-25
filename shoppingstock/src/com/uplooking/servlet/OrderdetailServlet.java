package com.uplooking.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uplooking.pojo.Tbl_sj_orderdetail;
import com.uplooking.service.Tbl_sj_orderdetailService;
import com.uplooking.service.Tbl_sj_orderdetailServiceImpl;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class OrderdetailServlet
 */
@WebServlet("/OrderdetailServlet")
public class OrderdetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderdetailServlet() {
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
        Tbl_sj_orderdetailService tsos = new Tbl_sj_orderdetailServiceImpl();
        List<Tbl_sj_orderdetail> lists = tsos.findAll();
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
