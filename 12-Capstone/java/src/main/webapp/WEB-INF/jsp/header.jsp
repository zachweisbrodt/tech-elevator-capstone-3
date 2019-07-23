<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<!-- FONTS -->
	<link href="https://fonts.googleapis.com/css?family=Sail&display=swap" rel="stylesheet">
	
    <!-- Required Bootstrap metas -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title><c:out value="${pageTitle}"/>/National Park Geek</title>
    
    <!--Bootstrap CSS-->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="<c:url value="/css/site.css"/>" rel="stylesheet" type="text/css" />
    
    <!-- JavaScript for Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>

<img id="logo" src="<c:url value="/img/logo.png"/>" />

    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #5e4a3a;">
    	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    		<span class="navbar-toggler-icon"></span>
  		</button>
        <div class="container text-center">
	        <div class="collapse navbar-collapse" id="navbarNav">
	   			 <ul class="navbar-nav mr-auto">
	     			<li class="nav-item active">
	        			<a class="nav-link pull-left" style="color:white" href="homePage"><strong>HOME</strong></a>
	      			</li>
	      			<li class="nav-item">
	        			<a class="nav-link pull-left" style="color:white" href="surveyForm"><strong>SURVEY</strong></a>
	      			</li>
	      		</ul>
	      	</div>
        </div>
    </nav>

    <div class="main-content">