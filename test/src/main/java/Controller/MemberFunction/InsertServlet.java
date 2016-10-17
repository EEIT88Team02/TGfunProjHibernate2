package Controller.MemberFunction;

import java.io.IOException;
import java.lang.reflect.Member;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import model.Member.MemberBean;
import model.Member.MemberService;
@WebServlet(
		urlPatterns={"/Login/Insert.controller"}
)
public class InsertServlet extends HttpServlet {

	private MemberService service;
	private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public void init() throws ServletException {
		service = new MemberService();
		System.out.println("STEP8");
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接收資料
		System.out.println("Step0");
		String account = request.getParameter("account");
		String temp1 = request.getParameter("pwd");
		String name = request.getParameter("name");
		String ID = request.getParameter("ID");
		String Email = request.getParameter("Email");
		String Celphone = request.getParameter("Celphone");
		String Telephone = request.getParameter("Telephone");
		String Address = request.getParameter("Address");
		String temp2 = request.getParameter("Birthday");
		String Sex = request.getParameter("Sex");
		String prodaction = request.getParameter("prodaction");
		System.out.println("Step1");
		
		// 轉換資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("error",errors);
		byte[] pwd = null;
		if (temp1 != null && temp1.trim().length() != 0) {
			pwd = temp1.getBytes();
		}
		System.out.println("Step2");
		java.util.Date Birthday = null;
		if (temp2 != null && temp2.trim().length() != 0) {
			try {
				Birthday = sFormat.parse(temp2);
			}
			catch (ParseException e) {
				errors.put("Birthday","日期格式:yyyy-MM-dd");
				e.printStackTrace();
			}
		}
		System.out.println("Step3");
		// 驗證資料
		if ("Insert".equals(prodaction)) {
			if (account == null) {
				errors.put("account","請輸入帳號" + prodaction);
			}
		}
		System.out.println("Step4");
		if (errors != null && !errors.isEmpty()) {
			request.getRequestDispatcher("/Login/Login.jsp").forward(request,response);
			return;
		}
		
		System.out.println("Step5");
		// 根據model執行結果，導向view
		MemberBean bean = new MemberBean();
		System.out.println("Step6");
		bean.setAccount(account);
		bean.setPwd(pwd);
		bean.setName(name);
		bean.setID(ID);
		bean.setEmail(Email);
		bean.setCelphone(Celphone);
		bean.setTelephone(Telephone);
		bean.setAddress(Address);
		bean.setBirthday(Birthday);
		bean.setSex(Sex);
		System.out.println("Step6-1");
		
		if ("Insert".equals(prodaction)) {		
			System.out.println("Step6-2"+bean);
			MemberBean result = service.insert(bean);
			System.out.println("Step6-3"+bean);
			if (result == null) {
				errors.put("action","新增失敗");
				System.out.println("Step6-4");
			}
			else {
				request.setAttribute("insert",result);
				System.out.println("Step6-5");
			}
			request.getRequestDispatcher("index.jsp").forward(request,response);
			System.out.println("Step6-6");
			
		}
	}
	@Override
	protected void doPost(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(reqest,response);
	}

}
