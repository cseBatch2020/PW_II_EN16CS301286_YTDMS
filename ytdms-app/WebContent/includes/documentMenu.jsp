
<link href="https://fonts.googleapis.com/css?family=Raleway&display=swap" rel="stylesheet">

<nav class="navbar fixed-top navbar-dark  bg-dark py-0 navbar-expand-lg">

	<a class="navbar-brand" href="home.jsp">YTDMS <i
		class="fa fa-laptop"></i></a>
	<div class="d-flex flex-row order-2 order-lg-3">

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown">
			<span class="navbar-toggler-icon"></span>
		</button>
	</div>
	<div class="collapse navbar-collapse order-3 order-lg-2"
		id="navbarNavDropdown">
		<ul class="navbar-nav ml-auto">
			<li class="nav-item"><a class="nav-link border-right" href="#">Profile
					<i class='fas fa-folder-plus'></i>
			</a></li>
			<li class="nav-item"><a class="nav-link border-right" href="#">Notifications
				 <i class='fas fa-trash'></i>
			</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#"
				id="navbarDropdownMenuLink" data-toggle="dropdown">Menu <i
					class='fas fa-sitemap'></i></a>
				<div class="dropdown-menu dropdown-menu-right bg-dark">
				<a class="dropdown-item" href="ListDocumentController">Document List</a>
					<a class="dropdown-item" href="addDocument.jsp">Add Document
					</a> <a class="dropdown-item" href="ShowTrashListController">Trash List</a>
					<a class="dropdown-item" href="DisplaySectionListController">Section List</a>
				</div></li>
		</ul>
	</div>
</nav>