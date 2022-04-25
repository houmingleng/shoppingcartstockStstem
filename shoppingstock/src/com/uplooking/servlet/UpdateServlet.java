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

import net.sf.json.JSONArray;


/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	          //显示所有会员信息
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
       String memberid = request.getParameter("memberid");
       int mid = Integer.parseInt(memberid);
	   String account = request.getParameter("account");
 	   String sex = request.getParameter("sex");
 	   String realname = request.getParameter("realname");
 	   String mobile = request.getParameter("mobile");
 	   String place = request.getParameter("place");
 	   String note = request.getParameter("note");
 	   Tbl_sj_memberService tsms = new Tbl_sj_memberServiceImpl();
 	   Tbl_sj_member tsm = new Tbl_sj_member(mid, account, null, sex, realname, mobile, null, place, 0, 0, note);
 	   request.getSession().setAttribute("user", tsm);
 	   int i = tsms.update(tsm);
	   if(i>0){
		   JSONArray jsonArray = JSONArray.fromObject(tsm);
           System.out.println(jsonArray.toString());
           response.getWriter().write(jsonArray.toString());
		   System.out.println("修改成功");
	   }else{
		   response.getWriter().write("no");
	   }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
