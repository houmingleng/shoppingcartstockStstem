package com.uplooking.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uplooking.pojo.Tbl_sj_member;
import com.uplooking.service.Tbl_sj_memberService;
import com.uplooking.service.Tbl_sj_memberServiceImpl;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String regaccount = request.getParameter("regaccount");
		// 实例对象
		Tbl_sj_memberService tdms = new Tbl_sj_memberServiceImpl();
 			Tbl_sj_member tdMember = tdms.findOne(regaccount);
 			if( tdMember == null ){
 				response.getWriter().write("OK");
 				//用户存在 ，传送not
	         }else{
			    response.getWriter().write("Not");
			    }
			}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    doGet(request, response);
	}
}
