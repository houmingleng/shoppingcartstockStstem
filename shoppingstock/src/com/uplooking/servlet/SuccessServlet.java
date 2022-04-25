package com.uplooking.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uplooking.pojo.Tbl_sj_member;
import com.uplooking.service.Tbl_sj_memberService;
import com.uplooking.service.Tbl_sj_memberServiceImpl;

/**
 * Servlet implementation class SuccessServlet
 */
@WebServlet("/SuccessServlet")
public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuccessServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	               //×¢²á³É¹¦
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String regaccount = request.getParameter("regaccount");
		String regpassword = request.getParameter("regpassword");
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		Timestamp ts = null;
		Date date1;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(df.format(day));
			ts = new Timestamp(date1.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Tbl_sj_memberService tdms = new Tbl_sj_memberServiceImpl();
		Tbl_sj_member tdm = tdms.findOne(regaccount);
		System.out.println(tdm);
		if(tdm!=null){
			response.getWriter().write("noOK");
		}else{
		int i = tdms.add(new Tbl_sj_member(0, regaccount, regpassword, null, null, null, ts, null, 0, 0, null));
		if(i>0){
			response.getWriter().write("OK");
		}
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
