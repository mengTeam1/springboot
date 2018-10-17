package com.accp.t2.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.t2.biz.bmBiz;
import com.accp.t2.entity.bm;
import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class bmAction
 */
public class BmAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BmAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private bmBiz bmBiz=new bmBiz();
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String m=req.getParameter("m");
		
	
		if("queryAll".equals(m)) {
			List<bm> list =bmBiz.queryAll();
			
			req.setAttribute("list", list);
			
			req.getRequestDispatcher("/WEB-INF/view/showBm.jsp").forward(req, resp);
		}else if("queryByLink".equals(m)) {
			String name=req.getParameter("name");
			
			bm b=bmBiz.queryByName(name);
			String jsonStr=JSON.toJSONString(b);
			
			PrintWriter out=resp.getWriter();
			System.out.println(jsonStr);
			out.print(jsonStr);
			
			
		}
		
	
	}

}
