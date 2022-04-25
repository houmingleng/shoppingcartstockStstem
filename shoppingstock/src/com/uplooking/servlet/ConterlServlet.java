package com.uplooking.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uplooking.pojo.Tbl_sj_member;

import net.sf.json.JSONArray;

@WebServlet("/ConterlServlet")
public class ConterlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConterlServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		         //登录跳转后，界面显示用户姓名和籍贯
		        request.setCharacterEncoding("UTF-8");
		        response.setCharacterEncoding("UTF-8");
		        response.setContentType("text/html;charset=utf-8");
                Tbl_sj_member user = (Tbl_sj_member) request.getSession().getAttribute("user");
	            JSONArray jsonArray = JSONArray.fromObject(user);
	            System.out.println(jsonArray.toString());
	            response.getWriter().write(jsonArray.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
