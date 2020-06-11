<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Map"%>
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
<link
	href="https://fonts.googleapis.com/css?family=Raleway&display=swap"
	rel="stylesheet">
<script src="https://use.fontawesome.com/releases/v5.12.1/js/all.js"
	data-auto-a11y="true"></script>
	<script src="static/js/ytdms_codejs"
	data-auto-a11y="true"></script>

<title>YTDMS APP</title>
</head>
<body>
	<!--header-->
	<jsp:include page="includes/header.jsp" />

	<!--MAIN-->
	<div class="container col-lg-12 ">

		<div id="main-section" style="margin-top: -4%;">
			<div class="Container  text-center table-responsive mb-5"
				id="main-container" style="margin-top: 11%;">

				<div>

					<div class="row ">


						<!-- SEARCH -->
						<div class="input-group mb-3 col-lg-3 d-flex float-left">
							<form action="SearchSectionController" method="get">
								<div class="input-group-append">
									<input type="text" class="form-control ml-2"
										placeholder="search" aria-label="Recipient's username"
										aria-describedby="button-addon2" name="searchItem" required>

									<button class="btn btn-outline-secondary" type="submit"
										id="button-addon2">
										<i class="fa fa-search" aria-hidden="true"></i>
									</button>
								</div>

							</form>
						</div>
						<div class="d-flex float-right" id="buttons-container"
							style="margin-left: 40%;">

							<a href="GetCategoryController"
								class="btn btn-primary btn-lg mb-2 text-white"
								id="create-section-btn" style="margin-right: 3%;"><span>Create
									Section</span></a> <span><input type="button"
								class="btn btn-primary"
								onclick="location.href='CategorizeSectionController'"
								value="Categorize"></span>
							<div class="dropdown">
								<button class="btn btn-primary dropdown-toggle ml-3"
									type="button" id="dropdownMenuButton" data-toggle="dropdown">
									Filter
									Section
									</button>
								<div class="dropdown-menu">
							 <c:forEach items="${categories}" var="categories">
							 
					         <option value=""></option>
				 				<a class="dropdown-item bg-dark text-white" id="filterOption" href="FilterByCategoryController?categoryName=${categories}"><c:out value="${categories}" /></a> 
							 				</c:forEach>
							 				
								</div>
           			</div>

							<!-- PAGINATION BOX -->
							<span class="float-right">
								<div class="col-lg-2 float-right" id="pagination-box">
									<div class="dropdown float-right">
										<button class="btn btn-primary dropdown-toggle" type="button"
											id="dropdownMenuButton" data-toggle="dropdown">page</button>
										<div class="dropdown-menu"
											aria-labelledby="dropdownMenuButton">
											<a class="dropdown-item text-dark"
												href="SectionRecordsController?page=10">10</a> <a
												class="dropdown-item text-dark"
												href="SectionRecordsController?page=20">20</a> <a
												class="dropdown-item text-dark"
												href="SectionRecordsController?page=30">30</a>
										</div>

									</div>


								</div>
							</span>
						</div>
					</div>


				</div>

				<!-- TABLE CONTAINER -->

				<!-- TABLE -->
				<table class="table mt-1 " id="table">
					<tbody class="table "  >
						<tr>

                          
					
							<th class="bg-dark text-white text-center" scope="col" style="width:500px">Section Name</th>
							<th  class="bg-dark text-white text-center" scope="col" style="width:300px">Section Description</th>
							<th  class="bg-dark text-white text-center" scope="col" style="width:300px">Category Name</th>
							<th class="bg-dark text-white text-center" scope="col" style="width:300px" colspan="2">Edit</th>
					  		
						</tr>
						
						<c:forEach var="type" items="${sections}">

							<tr >

								<td scope="col"  style="width:300px"><a href="ListDocumentController?sectionId=${type.key.getId()}" ><c:out value="${type.key.getName()}" /></a> </td>

								<td scope="col"  style="width:300px"><c:out value="${type.key.getDescription()}" /> </td>

								<td scope="col"  style="width:300px"><c:out value="${type.value}" /> </td>


								<td class="text-center p-2" scope="col"  style="width:300px" >
								<a
									href="UpdateSectionFormController?id=
										${type.key.getId()}"
									class="btn btn-success ml-2 " data-toggle="tooltip"
									data-placement="top" title="Update Section"><i
										class="fas fa-edit"></i>Update</a>
										
										 <a href="DeleteSectionController?id=
										${type.key.getId()}"
									class="btn btn-danger mr-2 " data-toggle="tooltip"
									data-placement="top" title="Delete Section" onclick="return confirm('Are you sure to delete?')"> <i
										class="fas fa-trash" "></i>Delete
								</a> <a href="moveup?id=${type.key.getId()}" class=" ml-3"
									data-toggle="tooltip" data-placement="top" title="move up">
										<i class="fas fa-caret-up"></i>
								</a> <a href="movedown?id=
										${type.key.getId()}"
									class=" float-right mt-2" data-toggle="tooltip"
									data-placement="top" title=" move down"> <i
										class="fas fa-caret-down"></i></a>
										
								</td>

							</tr>


						</c:forEach>
						
						
					</tbody>
				</table>
			</div>
			<!-- PAGINATION SCROLL -->
			<nav aria-label="Page navigation example" class="float-right">
			<ul class="pagination">
				<li class="page-item"><a class="page-link"
					href="nextpage?page=previous">Previous</a></li>

				<li class="page-item"><a class="page-link"
					href="nextpage?page=next">Next</a></li>
			</ul>
			</nav>
		</div>

	</div>
	</div>
	<!-- footer -->
	<jsp:include page="includes/footer.jsp" />

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>