package com.accp.t1.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.t1.biz.StaffBiz;
import com.accp.t1.entity.Staff;

/**
 * Servlet implementation class StaffAction
 */
public class StaffAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffAction() {
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
	private StaffBiz staffBiz =new StaffBiz();
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		System.out.println();
		
		String m=req.getParameter("m");
		
		
		if("queryAll".equals(m)) {
			List<Staff> list=staffBiz.queryAll();

			
			req.setAttribute("staffList", list);
			
			
			req.getRequestDispatcher("/WEB-INF/view/list.jsp").forward(req, resp);
		}else if("queryLinkById".equals(m)) {
			String id=req.getParameter("id");
			
			Staff st=staffBiz.queryLinkByIdStaff(id);
			PrintWriter out=resp.getWriter();
			
			String te="编号："+st.getId()+"姓名："+st.getsName()+"地址："+st.getsAddress()+"Email:"+st.getEmail();
			out.write(te);
			
			
		}
		
		
		
		
		
		
			
		
	
	}

}
