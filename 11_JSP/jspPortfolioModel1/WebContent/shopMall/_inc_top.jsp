<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList"%>

<%@ page import="config.Util"%>
<%@ page import="shopProduct.model.dao.ShopProductDAO"%>
<%@ page import="shopProduct.model.dto.ShopProductDTO"%>
<%@ page import="shopVendor.model.dto.ShopVendorDTO"%>
<%@ page import="shopVendor.model.dao.ShopVendorDAO"%>

<%@ include file = "../_include/inc_header.jsp" %>
<%@ include file = "../_include/inc_sessionChk.jsp" %>

<%
	Util util = new Util();
%>