package com.ssafy.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet() 실행");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
			
		// 쿼리 스트링 정보 추출
		String queryString = request.getQueryString();
		System.out.println("쿼리 스트링 정보 : " + queryString);
		
		// body에 담긴 정보 추출
		/*String data = request.getReader().readLine();
		System.out.println("body에 담긴 정보 : " + data);
		
		// json을 자바가 쓸 수 있는 객체로 만들어줌
		Gson gson = new Gson();
		// Gson.fromJson(json문자열, 자바로 바꿀 클래스)
		Map<String, String> user = gson.fromJson(data, Map.class);
		String id = user.get("id");
		String pwd = user.get("pwd");*/
		
		System.out.printf("id는 %s, pwd는 %s%n", id, pwd);
		
		// 응답
		response.getWriter().println("<h1>login success</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost() 실행");
		
//		doGet(request, response);
	}

}
