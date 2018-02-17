<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
<!DOCTYPE html>
<html lang="fr">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>OSS PROBLEMS - Predict and Solve</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath() %>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%=request.getContextPath() %>/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=request.getContextPath() %>/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath() %>/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            
            <%@ include file="/WEB-INF/views/menu_top/topMenu.jsp" %>
			
            <%@ include file="/WEB-INF/views/menu_left/leftMenu.jsp" %>
            <!-- /.navbar-static-side -->
        </nav>

        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header"><fmt:message code = "commande.client.nouveau" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
            </div>
            <div class="alert alert-danger" id="notFoundMsgBlock">
               <fmt:message code="commande.client.article.not.found" />
            </div>
            <div class="alert alert-danger" id="clientNotSelectedMsgBlock">
               <fmt:message code="commande.client.select.client.msfg.erreur" />
            </div>
            <div class="alert alert-danger" id="unexpectedErrorMsgBlock">
               <fmt:message code="commande.client.select.client.unexpected.error" />
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <fmt:message code="commande.client.detail" />
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
							<form action="" enctype="multipart/form-data" role = "form">
								<div class="form-row">
									<div class="col-md-4 mb-3">
	                                    <label><fmt:message code="common.code" /></label>
	                                    <input class="form-control" placeholder="Code" id="codeCommande" value = "${code }" disabled />
	                                </div>
									<div class="col-md-4 mb-3">
	                                    <label><fmt:message code="common.date" /></label>
	                                    <input class="form-control" placeholder="Date" id="dateCommande" value = "${dateCde }" disabled />
	                                </div>
									<div class="col-md-4 mb-3">
	                                    <label><fmt:message code="common.client" /></label>
	                                    <select class = "form-control" id="listClients">
	                                    	<option value = "-1"><fmt:message code="commande.client.select.client" /></option>
	                                    	<c:forEach items = "${clients }" var = "clt">
	                                    		<option value = "${clt.getIdClient() }">${clt.getNom() }</option>
	                                    	</c:forEach>
	                                    </select>
	                                </div>
								</div>
								<br /><br /><br /><br />
                                <div class="panel-footer">
                                	<button type="button" id="btnEnrigtrerCommande" class="btn btn-primary"><i class="fa fa-save">&nbsp;<fmt:message code="common.enregister" /></i></button>
                                	<a href="<c:url value="/commandeclient/" />" class="btn btn-danger"> <i class="fa fa-arrow-left">&nbsp;<fmt:message code="common.annuler" /></i></a>
                                </div>
							</form>	                        
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <fmt:message code="commande.client.detail" />
                        </div>
                        
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<div class="form-row">
		                        <div class="col-md-4 mb-3">
		                        	<label><fmt:message code="common.article" /></label>
		                        	<input class="form-control" type = "text" id="codeArticle_search" placeholder="Saisir un code article" />
		                        </div>
                        	</div>
                        	<br /><br /><br /><br />
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th><fmt:message code="common.article" /></th>
                                        <th><fmt:message code="common.qte" /></th>
                                        <th><fmt:message code="common.prixUnitTTC" /></th>
                                        <th><fmt:message code="common.total" /></th>
                                        <th><fmt:message code="common.actions" /></th>
                                    </tr>
                                </thead>
                                <tbody id = "detailNouvelleCommande">
                                	<tr></tr>
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="<%=request.getContextPath() %>/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/dist/js/sb-admin-2.js"></script>
    <!-- My Custom JavaScript files -->
    <script src="<%=request.getContextPath() %>/resources/javascript/commandeClient.js"></script>

</body>

</html>
