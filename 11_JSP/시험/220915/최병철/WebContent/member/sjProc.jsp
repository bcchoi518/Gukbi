<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="sj.model.dto.SjDTO"%>
<%@page import="sj.model.dao.SjDAO"%>

<%
	request.setCharacterEncoding("UTF-8");
	
	String name = request.getParameter("name");
	String sName = request.getParameter("sName");
	String mun_1_ = request.getParameter("mun_1");
	String mun_2_ = request.getParameter("mun_2");
	String mun_3_ = request.getParameter("mun_3");
	String mun_4_ = request.getParameter("mun_4");
	String mun_5_ = request.getParameter("mun_5");
	
	int errCounter = 0;
	if (name == null || name.trim().equals("")) {
		errCounter++;
	} else if (sName == null || sName.trim().equals("")) {
		errCounter++;
	} else if (mun_1_ == null || mun_1_.trim().equals("")) {
		mun_1_ = "0";
		errCounter++;
	} else if (mun_2_ == null || mun_2_.trim().equals("")) {
		mun_2_ = "0";
		errCounter++;
	} else if (mun_3_ == null || mun_3_.trim().equals("")) {
		mun_3_ = "0";
		errCounter++;
	} else if (mun_4_ == null || mun_4_.trim().equals("")) {
		mun_4_ = "0";
		errCounter++;
	} else if (mun_5_ == null || mun_5_.trim().equals("")) {
		mun_5_ = "0";
		errCounter++;
	}//if
	
	if (errCounter > 0) {
		out.println("<script>");
		out.println("alert('정상적인 값이 입력되지 않았습니다.');");
		out.println("location.href = 'sj.jsp';");
		out.println("</script>");
		return;
	}//if
	
	int mun_1 = Integer.parseInt(mun_1_);
	int mun_2 = Integer.parseInt(mun_2_);
	int mun_3 = Integer.parseInt(mun_3_);
	int mun_4 = Integer.parseInt(mun_4_);
	int mun_5 = Integer.parseInt(mun_5_);
	
	String[] jungdab = {"1","2","3","4","3"};
	String[] mun_ox = new String[jungdab.length];
	int jumsu = 0;
	
	for (int i = 0; i < jungdab.length; i++) {
		if (jungdab[i].equals(request.getParameter("mun_" + (i+1)))) {
			mun_ox[i] = "O";
			jumsu += 20;
		} else {
			mun_ox[i] = "X";
		}//if
	}//for
	
	SjDTO arguSjDto = new SjDTO();
	arguSjDto.setName(name);
	arguSjDto.setsName(sName);
	arguSjDto.setMun_1(mun_1);
	arguSjDto.setMun_2(mun_2);
	arguSjDto.setMun_3(mun_3);
	arguSjDto.setMun_4(mun_4);
	arguSjDto.setMun_5(mun_5);
	arguSjDto.setMun_ox_1(mun_ox[0]);
	arguSjDto.setMun_ox_2(mun_ox[1]);
	arguSjDto.setMun_ox_3(mun_ox[2]);
	arguSjDto.setMun_ox_4(mun_ox[3]);
	arguSjDto.setMun_ox_5(mun_ox[4]);
	arguSjDto.setJumsu(jumsu);
	
	SjDAO sjDao = new SjDAO();
	int result = sjDao.setInsert(arguSjDto);
	
	if (result > 0) {
		out.println("<script>");
		out.println("alert('등록이 정상적으로 완료되었습니다.');");
		out.println("location.href = 'sj.jsp';");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('등록 처리 중 오류가 발생했습니다.');");
		out.println("location.href = 'sj.jsp';");
		out.println("</script>");
	}//if
%>