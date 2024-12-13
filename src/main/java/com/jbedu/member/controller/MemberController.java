package com.jbedu.member.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.naver")
public class MemberController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(".naver로 끝나는 요청이 들어왔어요!");
		String uri = request.getRequestURI(); //client가 요청한 전체 주소
		System.out.println(uri);
		String conPath = request.getContextPath();
		System.out.println(conPath);
		//uri - conPath = 요청 부분 
		String com = uri.substring(conPath.length()); //uri 주소 앞에서 부터 conPath 길이만큼 삭제
		System.out.println(com);
		
		String viewPage = ""; //실제 유저에게 전달된 jsp 파일의 이름이 들어갈 문자 변수 
		if(com.equals("/baseball.naver")) {
			viewPage = "baseball.jsp";			
		} else if(com.equals("/golf.naver")) {
			viewPage = "golf.naver";
		} else if(com.equals("/soccer.naver")) {
			viewPage = "soccer.naver";			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		// 실제 유저에게 jsp 파일을 전달하는 클래스 
		dispatcher.forward(request, response);
		//viewPage 파일이름의 jsp파일을 유저에게 전달 
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	
	
}
