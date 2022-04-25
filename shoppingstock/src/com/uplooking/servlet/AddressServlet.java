package com.uplooking.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uplooking.pojo.Tbl_sj_address;
import com.uplooking.pojo.Tbl_sj_member;
import com.uplooking.service.Tbl_sj_addressService;
import com.uplooking.service.Tbl_sj_addressServiceImpl;
import com.uplooking.service.Tbl_sj_memberService;
import com.uplooking.service.Tbl_sj_memberServiceImpl;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class AddressServlet
 */
@WebServlet("/AddressServlet")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressServlet() {
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
	                Tbl_sj_memberService tms = new Tbl_sj_memberServiceImpl();
	                Tbl_sj_member tm = (Tbl_sj_member) request.getSession().getAttribute("user");
	                System.out.println(tm);
	                System.out.println(tm.getMemberid());
	                Tbl_sj_addressService tsas = new Tbl_sj_addressServiceImpl();
	                List<Tbl_sj_address> lists = tsas.findAll(tm.getMemberid());
	                JSONArray jsonArray = JSONArray.fromObject(lists);
	                response.getWriter().write(jsonArray.toString());
	                 
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
