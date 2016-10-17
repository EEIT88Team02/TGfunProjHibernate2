<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World!</h2>
<body>
<h3><a href="<c:url value="/Login/Login.jsp"/>">Login</a></h3>
<h3><a href="<c:url value="/Login/Insert.jsp"/>">Insert</a></h3>
  <table>
   <tr>
    <td><img src="Kaptcha.jpg"></td>
    <td valign="top">
     <form method="POST">
      <br>請輸入驗證碼：<input type="text" name="kaptchafield"><br />
      <input type="submit" name="submit">
     </form>
    </td>
   </tr>
  </table> 
  

  

 </body>
</body>
</html>
