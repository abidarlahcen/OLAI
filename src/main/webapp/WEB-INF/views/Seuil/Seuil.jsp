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
                        <h1 class="page-header"><fmt:message code="common.threshold" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                
                <div class="panel panel-default">
 				 <!-- Default panel contents -->
 					 <div class="panel-heading"><strong>Gestion des Seuils: df -kh</strong></div>
                                        <!-- /.panel-heading -->
                                        
                     <div class="panel-body">
                     <form action="" method="post">
                     	<table align="center" >
                        	<tr>
                                <td>Probl�me mineur&nbsp </td>
                                <td><input class="form-control" placeholder="Seuil probl�me mineur" name="mineur" rows= "5" size= "100" /></td>
                            </tr>
                            <tr><td>&nbsp</td><td>&nbsp</td></tr>
                            <tr>
                                <td>Probl�me majeur&nbsp </td>
                                <td><input class="form-control" placeholder="Seuil probl�me majeur" name="majeur" rows= "5" size= "100" /></td>
                            </tr>
                            <tr><td>&nbsp</td><td>&nbsp</td></tr>
                            <tr>
                                <td>Probl�me critique&nbsp </td>
                                <td><input class="form-control" placeholder="Seuil probl�me critique" name="critique" rows= "5" size= "100" /></td>
                            </tr>
                      		<tr><td>&nbsp</td><td>&nbsp</td></tr>
                            <tr>
                             	<td></td>
                                <td><button type="submit" class="btn btn-primary">Enregistrer</button></td>
                            </tr>
         				</table>
         			</form>
            		</div>
            		</div>
            		
	                    
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

</body>

</html>