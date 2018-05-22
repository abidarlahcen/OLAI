<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">
		<ul class="nav" id="side-menu">
			<li class="sidebar-search">
				<div class="input-group custom-search-form">
					<input type="text" class="form-control" placeholder="Recherche...">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">
							<i class="fa fa-search"></i>
						</button>
					</span>
				</div> <!-- /input-group -->
			</li>
			<c:url value="/home/" var="home" />
			<li class=""><a href="${home }"><i class="fa fa-dashboard fa-fw"></i>
					<fmt:message code="common.dashbord" /> </a></li>
			
			
				
				<c:url value="/logimport/" var="logimport" />
				<li><a href="${logimport }"><i class="fa fa-database fa-fw"></i>
					<fmt:message code="common.log.import" /></a><li>
				
				<c:url value="/OSSproblems/" var="OSSproblems" />
				<li><a href="${OSSproblems }"><i class="fa fa-users fa-fw"></i>
					<fmt:message code="common.OSS.problems" /></a></li>
				
				
				<li><a href="#"><i class="fa fa-support fa-fw"></i>
					<fmt:message code="common.fournisseur" /><span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<c:url value="/fournisseur/" var="fournisseur" />
					<li><a href="${fournisseur }"><fmt:message code="common.fournisseur" /></a></li>
					<c:url value="/commandefournisseur/" var="cdeFournisseur" />
					<li><a href="${cdeFournisseur }"><fmt:message code="common.fournisseur.commande" /></a></li>
				</ul> <!-- /.nav-second-level --></li>
	
				
				<li><a href="#"><i class="fa fa-percent fa-fw"></i>
						<fmt:message code="common.threshold" /><span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
					<c:url value="/Seuil/" var="seuil" />
					<li><a href="${seuil }"><fmt:message code="common.threshold.df" /></a></li></ul>
				</li>
						
				<li><a href="#"><i class="fa fa-wrench fa-fw"></i>
						<fmt:message code="common.parametrage" /><span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<c:url value="/utilisateur/" var="user" />
					<li><a href="${user }"><fmt:message code="common.parametrage.utilisateur" /></a></li>
					<c:url value="/category/" var="category" />
					<li><a href="${category }"><fmt:message code="common.parametrage.category" /></a></li>
				</ul> <!-- /.nav-second-level --></li>
		</ul>
	</div>
	<!-- /.sidebar-collapse -->
</div>