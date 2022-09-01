<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="org.apache.tika.Tika"%>
<%@ page import="org.apache.coyote.http11.filters.SavedRequestInputFilter"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>

<%@ page import="java.io.File"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.UUID"%>
<%@ page import="java.util.ArrayList"%>

<%@ page import="config.Util"%>
<%@ page import="shopProduct.model.dao.ShopProductDAO"%>
<%@ page import="shopProduct.model.dto.ShopProductDTO"%>
<%@ page import="shopVendor.model.dto.ShopVendorDTO"%>
<%@ page import="shopVendor.model.dao.ShopVendorDAO"%>

<%@ include file = "../_include/inc_header.jsp" %>
<%@ include file = "../_include/inc_sessionChk.jsp" %>

<%
//attach start
	String attachPath = "C:/cbc/attach";
	String uploadPath = attachPath + request.getContextPath() + "/shopProduct";
	int maxUpload = 1024 * 1024 * 10;
	String encoding = "UTF-8";
//attach end
	
	Util util = new Util();
%>