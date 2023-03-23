<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL TAGS</title>
</head>
<body>

	<!-- It is use for printing purpose same as Expression tag -->
	<c:out value="Abhishek pandey"></c:out>
	<c:out value="${' Welcome to javaTpoint'}" />
	</p>

	<!-- It is similar to jsp 'include', here we import jsp file -->
	<c:import var="data" url="ScripletTag.jsp" />
	<c:out value="${data}" />
	</p>

	<!-- It is used to set property like jsp:setProperty -->
	<c:set var="income" scope="session" value="${100*10}" />
	</p>
	Before removing Income =
	<c:out value="${income }" />

	<!-- It is use for removing set var type -->
	<c:remove var="income" />
	</p>
	After removing income =
	<c:out value="${income }" />

	<!-- if is use for conditional statements -->
	<c:set var="income" scope="session" value="${4000*4}" />
	<c:if test="${income > 8000}">
		<p>
			My income is:
			<c:out value="${income}" />
		<p>
	</c:if>

	<!-- catch is use for Throwable exception handle -->
	<!--<c:catch vat="catchException">
		
	</c:catch>
	<c:if test="${catchException != null}">
		<p>
			The type of exception is : ${catchException} <br /> There is an
			exception: ${catchException.message}
		</p>
	</c:if>-->

	<c:choose>
		<c:when test="${income <= 1000}">  
       Income is not good.  
    </c:when>
		<c:when test="${income > 10000}">  
        Income is very good.  
    </c:when>
		<c:otherwise>  
       Income is undetermined...  
    </c:otherwise>
	</c:choose>

	<c:set value="10" var="num"></c:set>
	<c:choose>
		<c:when test="${num%2==0}">
			<c:out value="${num} is even number"></c:out>
		</c:when>
		<c:otherwise>
			<c:out value="${num} is odd number"></c:out>
		</c:otherwise>
	</c:choose>

	<c:forEach var="j" begin="1" end="3">  
   Item <c:out value="${j}" />
		<p>
	</c:forEach>
</body>
</html>