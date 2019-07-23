<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@include file="/WEB-INF/jsp/header.jsp"%>


<div class="survey-form">
	<div id="survey-form-header">
		<h5 id="survey-title">Favorite National Park Survey</h5>
		<span id="survey-form-description">Take the daily survey to share your opinion on your favorite national park. Once you vote, you can see
		which parks are the most loved. Is your favorite also the most loved by all park geeks?</span><br>
	</div>

	<c:url var="formAction" value="/surveyForm" />
	<form:form action="${formAction}" method="POST" modelAttribute="survey">

		<div class="survey-form-container">
		
		<div id="favorite-park-selection">
		<span id="favorite-park">
		<label for="park"><strong>Favorite National Park</strong></label> 
		</span>
		<span id="park-dropdown">
		<form:select path="parkCode">
			<c:forEach var="park" items="${parkList}">
				<option value="${park.parkCode}">${park.parkName}</option>
			</c:forEach>
		</form:select>
		</span>
		<form:errors path="parkCode" cssClass="error" />
		<br /><br /> 
		</div>
		
		<span id="email-label">
		<label for="emailAddress"><strong>Your Email</strong></label> 
		</span>
		<span id="email-input">
		<form:input type="text" path="emailAddress" size="31" />
		</span>
		<form:errors path="emailAddress" cssClass="error" />
		<br /><br /> 
		
		<span id="state-label">
		<label for="stateOfResidence"><strong>State of Residence</strong></label> 
		</span>
		<span id="state-dropdown">
		<form:select path="state">
			<option value="AL">Alabama</option>
			<option value="AK">Alaska</option>
			<option value="AZ">Arizona</option>
			<option value="AR">Arkansas</option>
			<option value="CA">California</option>
			<option value="CO">Colorado</option>
			<option value="CT">Connecticut</option>
			<option value="DE">Delaware</option>
			<option value="DC">District Of Columbia</option>
			<option value="FL">Florida</option>
			<option value="GA">Georgia</option>
			<option value="HI">Hawaii</option>
			<option value="ID">Idaho</option>
			<option value="IL">Illinois</option>
			<option value="IN">Indiana</option>
			<option value="IA">Iowa</option>
			<option value="KS">Kansas</option>
			<option value="KY">Kentucky</option>
			<option value="LA">Louisiana</option>
			<option value="ME">Maine</option>
			<option value="MD">Maryland</option>
			<option value="MA">Massachusetts</option>
			<option value="MI">Michigan</option>
			<option value="MN">Minnesota</option>
			<option value="MS">Mississippi</option>
			<option value="MO">Missouri</option>
			<option value="MT">Montana</option>
			<option value="NE">Nebraska</option>
			<option value="NV">Nevada</option>
			<option value="NH">New Hampshire</option>
			<option value="NJ">New Jersey</option>
			<option value="NM">New Mexico</option>
			<option value="NY">New York</option>
			<option value="NC">North Carolina</option>
			<option value="ND">North Dakota</option>
			<option value="OH">Ohio</option>
			<option value="OK">Oklahoma</option>
			<option value="OR">Oregon</option>
			<option value="PA">Pennsylvania</option>
			<option value="RI">Rhode Island</option>
			<option value="SC">South Carolina</option>
			<option value="SD">South Dakota</option>
			<option value="TN">Tennessee</option>
			<option value="TX">Texas</option>
			<option value="UT">Utah</option>
			<option value="VT">Vermont</option>
			<option value="VA">Virginia</option>
			<option value="WA">Washington</option>
			<option value="WV">West Virginia</option>
			<option value="WI">Wisconsin</option>
			<option value="WY">Wyoming</option>
		</form:select>
		</span>
		<form:errors path="state" cssClass="error" />
		<br /><br /> 
		
		<span id="activity-label">
		<label for="activityLevel"><strong>Activity Level</strong></label> 
		</span>
		<span id="activity-selection-1">
		<form:radiobutton path="activityLevel" value="inactive" />   Inactive
		</span>
		<span id="activity-selection-2">
		<form:radiobutton path="activityLevel" value="sedentary" />   Sedentary
		</span>
		<span id="activity-selection-3">
		<form:radiobutton path="activityLevel" value="active" />     Active
		</span>
		<span id="activity-selection-4">
		<form:radiobutton path="activityLevel" value="extreme" />     Extremely Active
		</span>
		<form:errors path="activityLevel" cssClass="error" />
		<br />

		</div>
				
		<label for="submit"></label> 
		<input id="survey-submit" type="submit" value="Submit" style="color:white">

	</form:form>

</div>


<%@include file="/WEB-INF/jsp/footer.jsp"%>