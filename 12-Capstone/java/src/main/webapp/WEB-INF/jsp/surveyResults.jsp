<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@include file="/WEB-INF/jsp/header.jsp"%>


<div id="main-content">

	<div class="survey-results-top">
		<h5 id="survey-results-title">The Most Loved Parks</h5>
		<span id="survey-results-description">Here are the most loved parks by park geeks around the world!</span><br><br>
	</div>

	<table class="favorites-table">
		<tr>
			<th></th>
			<th>Park Name</th>
			<th>Number of Votes</th>
		</tr>
	<c:forEach var="park" items="${favoriteParks}">
		<tr>
		<td><div><img id="survey-park-img" src="<c:url value="/img/parks/${fn:toLowerCase(park.parkCode)}.jpg" />" /></div></td>
		<td id="park-name-row"><div><p>${park.parkName}</p></div></td>
		<td><div><p id="vote-number">${park.numberOfFavorites}</p></div></td>
		</tr>
	</c:forEach>
	</table>

</div>

<%@include file="/WEB-INF/jsp/footer.jsp"%>