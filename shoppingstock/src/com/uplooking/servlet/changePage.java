package com.uplooking.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uplooking.pojo.Page;
import com.uplooking.service.Tbl_sj_goodsinfoService;
import com.uplooking.service.Tbl_sj_goodsinfoServiceImpl;

import net.sf.json.JSONArray;


/**
 * Servlet implementation class changePage
 */
@WebServlet("/changePage")
public class changePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changePage() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	           request.setCharacterEncoding("UTF-8");
	           response.setCharacterEncoding("UTF-8");
	           response.setContentType("text/html;charset=utf-8");
		       String num = request.getParameter("pageNum");
	           String size = request.getParameter("pageSize");
	           int pageNum = 0;
	           int pageSize=0;
	           if(num == "" || size == ""){
	        	   pageNum = 1;
	        	   pageSize = 4;
	           }else{
	        	   pageNum = Integer.parseInt(num);
	        	   pageSize = Integer.parseInt(size);
	           }
	           
	           Tbl_sj_goodsinfoService tss = new Tbl_sj_goodsinfoServiceImpl();
	           Page pg = tss.findPage(pageNum, pageSize);
	           System.out.println(pg);
	           JSONArray jsonArray = JSONArray.fromObject(pg);
	           response.getWriter().write(jsonArray.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
