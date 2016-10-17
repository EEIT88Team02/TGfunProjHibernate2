package Controller.MemberFunction;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member.MemberBean;
import model.Member.MemberService;


@WebServlet(
		urlPatterns={"/Login/Login.controller"}		
)
public class LoginServlet extends HttpServlet {
	private MemberService service;
	@Override
	public void init() throws ServletException {
		service = new MemberService();
		System.out.println("STEP8");
	}
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//接收資料
		System.out.println("STEP7");
		String account = request.getParameter("account");
		String pwd = request.getParameter("pwd");
		System.out.println("STEP6");
		
//驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("error", errors);
		if(account==null || account.length()==0) {
			errors.put("account", "請輸入帳號");
		}
		if(pwd==null || pwd.length()==0) {
			errors.put("pwd", "請輸入密碼");
		}
		
		if(errors!=null && !errors.isEmpty()) {
			request.getRequestDispatcher(
					"/Login/Login.jsp").forward(request, response);
			System.out.println("STEP5");
			return;
		}
		
//呼叫model
		MemberBean bean = service.login(account, pwd);
		
//根據model執行結果，導向view
		if(bean==null) {
			errors.put("pwd", "登入失敗!請檢查帳號密碼");
			request.getRequestDispatcher(
					"/Login/Login.jsp").forward(request, response);
			System.out.println("STEP4");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", bean);
			
			String path = request.getContextPath();
			response.sendRedirect(path+"/index.jsp");
			System.out.println("STEP3");
		}
	}
	@Override
	protected void doPost(HttpServletRequest reqest, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(reqest, response);
	}
}