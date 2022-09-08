<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../_include/inc_header.jsp" %>

<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="CSS/reset.css" rel="stylesheet" type="text/css">
  <link href="CSS/main.css" rel="stylesheet" type="text/css">
  <link href="CSS/navigation.css" rel="stylesheet" type="text/css">
  <link href="CSS/aside.css" rel="stylesheet" type="text/css">
  <link href="CSS/article.css" rel="stylesheet" type="text/css">
  <link href="CSS/footer.css" rel="stylesheet" type="text/css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@300&display=swap" rel="stylesheet">
  <title>BC.Choi`s Story</title>
  <script src="https://kit.fontawesome.com/f0aeb78d4e.js" crossorigin="anonymous"></script>
  <script src="JS/main.js" defer></script>
  <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<body>
  <!-- nav start -->
	<jsp:include page="../_include/inc_navbar.jsp"></jsp:include>
  <!-- nav end -->
  <!-- section start -->
  <section class="section">
    <!-- sidebar start -->
	<jsp:include page="../_include/inc_asidebar.jsp"></jsp:include>
    <!-- sidebar end -->
    <!-- article start -->
    <article class="article">
		<jsp:include page="<%=includePage %>"></jsp:include>
    </article>
    <!-- article end -->
  </section>
  <!-- section end -->
  <!-- footer start -->
  <jsp:include page="../_include/inc_footerbar.jsp"></jsp:include>
  <!-- footer end -->
</body>

</html>