## JSP

model1
model2 - MVC
Spring - MVC

JSP는 동적인 웹페이지 ex) 게시판

주소를 잘 이해해야 함!!
http://localhost:8090/jspTest/test.jsp
http://localhost:8090: 도메인
jspTest: 프로젝트이름

http://localhost:8090/jspTest = WebContent
http://localhost:8090/jspTest/test.jsp = WebContent/test.jsp
http://localhost:8090/jspTest/aaa/test.jsp = WebContent/aaa/test.jsp

<% %>: 스크립트릿 - 자바 코드를 작성하는 곳  
<%=변수명%>: 표현식(Expression) - 출력할때 사용가능

---

DB

- 이상현상 -> 정규화() -> 반정규화(역정규화) ex)JOIN
  삽입이상
  삭제이상
  갱신이상

정규화
제1정규화(1NF) -> 제2정규화(2NF) -> 제3정규화(3NF) -> BCNF -> 제4정규화(4NF) -> 제5정규화(5NF)
