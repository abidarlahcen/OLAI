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
                <h1 class="page-header">Email alarms </h1>
                </div>
                <div class="row">
                <div class="col-lg-12">
	                    <div class="panel panel-primary">
                         <div class="panel-heading">
	                        <fmt:message code="mail.nouveau" />
	                     </div>
                    
                    
                    <div class="panel-body">

	                        	 <form action="<c:url value="/emailalarms/enregistrer" />" method="post">
	                        	        
                                            <label><fmt:message code="common.object" /></label>
                                        
                                        
                                                
                                               <label class="checkbox-inline">
                                                 <input type="checkbox" name="object"  value="Dmtool">Dmtool
                                               </label>
                                               <label class="checkbox-inline">
                                                  <input type="checkbox" name="object"  value="isql_usa">isql_usa
                                               </label>
                                               <label class="checkbox-inline">
                                                   <input type="checkbox" name="object"  value="smtool">smtool
                                               </label>
                                               <label class="checkbox-inline">
                                                   <input type="checkbox" name="object"  value="Df_kh">Df_kh
                                               </label>
                                        <div class="form-group">
                                            <label><fmt:message code="common.name" /></label>
                                            <input class="form-control" placeholder="name"  name="name">
  
                                        </div>
                                        <div class="form-group">
                                            <label><fmt:message code="common.position" /></label>
                                            <input class="form-control" placeholder="position"  name="position">
  
                                        </div>
                                        <div class="form-group">
                                            <label><fmt:message code="common.mail" /></label>
                                            <input class="form-control" placeholder="mail"  name="mail">
  
                                        </div>
                                        <div class="form-group">
                                            <label><fmt:message code="common.company" /></label>
                                            <input class="form-control" placeholder="company"  name="company">
  
                                        </div>
                                 <button type="submit" class="btn btn-default">enregistrer</button>	    
                              </form>	                        
	                        </div>
                         <!-- /.panel-body -->
	                    </div>
	                    <!-- /.panel -->
	                </div>
                <!-- /.col-lg-12 -->
            </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
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