
      <nav class="navbar fixed-top navbar-dark  bg-dark py-0 navbar-expand-lg">
        
        <a class="navbar-brand" href="home.jsp">YTDMS <i class="fa fa-laptop"></i></a>
        <div class="d-flex flex-row order-2 order-lg-3">

          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown">
            <span class="navbar-toggler-icon"></span>
          </button>
        </div>
        <div class="collapse navbar-collapse order-3 order-lg-2" id="navbarNavDropdown">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item"><a class="nav-link border-right" href="addModule.jsp">Add Module <i class='fas fa-user-circle'></i></a></li>
            <li class="nav-item"><a class="nav-link border-right" href="addRole.jsp">Add Role <i class='fas fa-bell'></i></a></li>
            <li class="nav-item"><a class="nav-link border-right" href="ListRoleController">Full View<i class='fas fa-folder'></i></a></li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown">Permissions<i class='fas fa-sitemap'></i></a>
              <div class="dropdown-menu dropdown-menu-right bg-dark">
                <a class="dropdown-item" href="PermissionModuleController">Add Permission</a>
                <a class="dropdown-item" href="ListModuleController">Assign Permissions</a>
              </div>
            </li>
          </ul>
        </div>
      </nav>