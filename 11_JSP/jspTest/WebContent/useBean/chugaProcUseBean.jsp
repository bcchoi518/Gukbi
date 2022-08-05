<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="dto" class="testUseBean.BossDTO" scope="page">
	<jsp:setProperty name="dto" property="*" />
</jsp:useBean>

boss_1 : <jsp:getProperty name="dto" property="boss_1" /><br>
boss_2 : <jsp:getProperty name="dto" property="boss_2" /><br>
boss_3 : <jsp:getProperty name="dto" property="boss_3" /><br>

<hr>

<%
	String boss_1 = dto.getBoss_1();
	String boss_2 = dto.getBoss_2();
	String boss_3 = dto.getBoss_3();
%>

boss_1 --> <%=boss_1 %><br>
boss_2 --> <%=boss_2 %><br>
boss_3 --> <%=boss_3 %><br>