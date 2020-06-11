<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet" href="static/css/sectionStyle.css">
<script src="https://use.fontawesome.com/releases/v5.12.1/js/all.js"
	data-auto-a11y="true"></script>
<title>YTDMS APP</title>
</head>
<body>
	<!--header-->
	<jsp:include page="includes/header.jsp" />

	<!-- MAIN CONTAINER -->
	<div class="container card col-lg-6 float-left mt-5 p-5" style="margin-top:4%">
		<form action="UpdateSectionController"  method="post">
			<h2 class="form-group text-center mb-5 display-5">Update Section</h2>

			<!-- CATEGORY CONTAINER -->
			<div>
				<select class="custom-select mb-3" id="category-options"
					name="category" required>
				<option selected>select category</option>
						<c:forEach items="${categories}" var="categories">
							<option value="${categories}"><c:out
									value="${categories}" /></option>
						</c:forEach>

				</select> <span id="categorySelectionError"></span>

				<div class="d-inline" id="add-icon-div">

					<button type="button" class="btn btn-primary mb-3" data-toggle="modal" data-target="#exampleModal">
                               <i class="fa fa-plus" aria-hidden="true"></i>
                   </button>

				</div>
			</div>
			<div class="form-group">
				<input type="text" class="form-control p-2" id="name"
					placeholder="enter the section name" name="name"  value="${name}"></input>
				<span id="nameError"></span>

			</div>

			<div class="form-group">
				<textarea type="text" class="form-control p-3" id="description"
					placeholder="add description" name="description">${description}</textarea>
				<span id="descriptionError"></span>

			</div>

			
			<button type="submit" class="btn btn-primary float-right" value="update Section">Update</button>
		</form>

	</div>

	<div>


		<!-- Modal -->
		<div class="modal fade" id="add-category-modal">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">...</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save
							changes</button>
					</div>
				</div>
			</div>
		</div>

	</div>
	<jsp:include page="includes/footer.jsp" />
	<script>

$('#myModal').on('shown.bs.modal', function () {
	  $('#myInput').trigger('focus')
	})
	
</script>
	<script src="static/js/validation.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous">
</script>

</body>
</html>