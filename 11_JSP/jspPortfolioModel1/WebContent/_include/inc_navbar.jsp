<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../_include/inc_header.jsp" %>
<%@ include file = "../_include/inc_sessionChk.jsp" %>
    
  <nav class="navbar">
    <div class="navbar__logo">
      <i class="fa-solid fa-hat-wizard"></i>
      <a href="#">BC.Choi's Story</a>
    </div>

    <ul class="navbar__menu">
      <li><a href="#">Home</a></li>
      <li><a href="#">Profile</a></li>
      <li><a href="#">Resume</a></li>
      <li><a href="<%=path %>">Portfolio</a></li>
    </ul>

    <ul class="navbar__icons">
      <li><i class="fa-brands fa-instagram"></i></li>
    </ul>

    <a href="#" class="navbar__toggleBtn">
      <i class="fa-solid fa-bars"></i>
    </a>
  </nav>