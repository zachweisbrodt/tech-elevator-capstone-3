<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@include file="/WEB-INF/jsp/header.jsp"%>
	
<div id="home-page">

	<div class="temperature-selection">
		<c:url value="/homePage" var="formAction" />
		<form method="POST" action="${formAction}">
		
		<span id="temp-label">
			<label for="temperature"><strong>Please set your temperature scale preference: </strong></label> 
		</span>
				
		<span id="temp-dropdown">
			<select name="temperature">
				<option value="fahrenheit">Fahrenheit</option>
				<option value="celsius">Celsius</option>
			</select><br>
		</span>
		
			<input id="temp-submit" type="submit" value="Save" style="color:white" />
			
		</form>
		<br>
	</div>
		
		<c:forEach var="park" items="${parkList}">

		<div class="park-container">
			<div id="park-image">
				<c:set var="imageName" value="${fn:toLowerCase(park.parkCode)}.jpg" />
				<c:url var="parkDetailHref" value="parkDetail">
					<c:param name="parkCode">${park.parkCode}</c:param>
				</c:url>
				<a class="product-image" href="${parkDetailHref}"> <img
					src="<c:url value="/img/parks/${imageName}" />" />
				</a>
			</div>

			<div>
				<p id="park-name">${park.parkName}</p>
				<p id="park-description">${park.parkDescription}</p>
			</div>
		</div>



	</c:forEach>
		
</div>
	

<%@include file="/WEB-INF/jsp/footer.jsp"%>