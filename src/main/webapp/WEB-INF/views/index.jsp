<!-- обратите внимание на spring тэги -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 
<html>
 
<head>
  <title>Index Page</title>
</head>
 
<body>
<form:form method="post"  modelAttribute="group" action="createGroup">

  Name: <form:input path="groupName"/>   <br/>
  <form:button>Create Group</form:button>
 
</form:form>


 <h1>Groups</h1>

 <c:if test="${!empty groupList}">
     <table>
         <tr>
             <th width="60">id</th>
             <th width="120">name</th>
             <th width="60">edit</th>
             <th width="60">delete</th>
         </tr>
         <c:forEach items="${groupList}" var="group">
             <tr>
                 <td>${group.id}</td>
                 <td>${group.groupName}</td>
                 <td><a href="<c:url value='/edit/${book.id}'/>">Edit</a></td>
                 <td><a href="<c:url value='/deleteGroup/${group.id}'/>">Delete</a></td>
             </tr>
         </c:forEach>
     </table>
 </c:if>



</body>
 
</html>