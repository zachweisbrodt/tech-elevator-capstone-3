<%@include file="/WEB-INF/jsp/header.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<body>
	<div id="park-detail">
		<img id="detailPic"
			src="<c:url value="/img/parks/${fn:toLowerCase(park.parkCode)}.jpg" />" />

		<h2>${park.parkName}</h2>
		<p id="quote">"${park.inspirationalQuote}"<br>
			-${park.inspirationalQuoteSource}</p>
	</div>

	<div id="park-details">
		<h1 id="park-details-title">Park Details</h1>
		<p>
			<strong>${park.parkDescription}</strong>
		</p>
		<p>
			Located In Beautiful <strong>${park.state}</strong>
		</p>
		<p>
			Spanning Over <strong><fmt:formatNumber
					value="${park.acreage}" pattern="###,###" /></strong> Acres
		</p>
		<p>
			An Elevation Of <strong><fmt:formatNumber
					value="${park.elevationInFeet}" pattern="###,###" /></strong> Feet
		</p>
		<p>
			Over <strong>${park.milesOfTrail}</strong> Miles Of Hiking Trails
		</p>
		<p>
			Spend The Night In One Of Our <strong>${park.numberOfCampsites}</strong>
			Campsites
		</p>
		<p>
			Enjoy All Of The <strong>${park.climate}</strong> Surroundings
		</p>
		<p>
			Founded In <strong>${park.yearFounded}</strong>
		</p>
		<p>
			<strong><fmt:formatNumber value="${park.annualVisitorCount}"
					pattern="###,###" /></strong> People Visit This Park Every Year
		</p>
		<p>
			Number of Animal Species: <strong>${park.numberOfAnimalSpecies}</strong>
		</p>
		<p>
			Entry Fee: <strong>$${park.entryFee}</strong>
		</p>
	</div>

	<br>

	<div id="weather">

		<c:forEach var="forecast" items="${weather}">
			<c:choose>
				<c:when test="${forecast.fiveDayForecastValue==1}">
					<div class="today">
						<span id="today-header">Today</span>
						<div>
							<img width="90%"
								src="img/weather/${forecast.forecast}.png">
						</div>
						<c:choose>
							<c:when test="${temperature == 'celsius'}">
                   				 High ${forecast.highInCelsius}°C Low ${forecast.lowInCelsius}°C  
                				</c:when>
							<c:otherwise>
                    			High ${forecast.high}°F  Low ${forecast.low}°F
                   				</c:otherwise>
						</c:choose>
						<div class="forecastAdvice">${forecast.forecastAdvice}</div>
						<div>${forecast.temperatureAdvice}</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="future">
						<div>
							<img width="90%"
								src="img/weather/${forecast.forecast}.png">
						</div>
						<c:choose>
							<c:when test="${temperature == 'celsius'}">
                   				 High ${forecast.highInCelsius}°C <br>Low ${forecast.lowInCelsius}°C  
                				</c:when>
							<c:otherwise>
                    			High ${forecast.high}°F <br> Low ${forecast.low}°F
                   				</c:otherwise>
						</c:choose>
					</div>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</div>
</body>


<%@include file="/WEB-INF/jsp/footer.jsp"%>