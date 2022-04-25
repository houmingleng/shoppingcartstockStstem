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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String account = request.getParameter("account");
//		System.out.println(account);
		String password = request.getParameter("password");
		Tbl_sj_memberService tdms = new Tbl_sj_memberServiceImpl();
		Tbl_sj_member tdMember = tdms.findOne(account);
		System.out.println(tdMember.getAccount()+","+tdMember.getLogpwd());
		if(account != null &&tdMember.getLogpwd().equals(password)){
			System.out.println(tdMember);
			request.getSession().setAttribute("user", tdMember);
			   System.out.println("µÇÂ¼³É¹¦");
		}else{
			System.out.println("Ê§°Ü");
			response.getWriter().write("error");
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
