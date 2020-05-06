<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
    <title>Ant Colony Stream Clustering</title>
    <!--REQUIRED STYLE SHEETS-->
    <!-- BOOTSTRAP CORE STYLE CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLE CSS -->
    <link href="assets/css/font-awesome.min.css" rel="stylesheet" />
    <!--ANIMATED FONTAWESOME STYLE CSS -->
    <link href="assets/css/font-awesome-animation.css" rel="stylesheet" />
       <!-- CUSTOM STYLE CSS -->
    <link href="assets/css/style.css" rel="stylesheet" />
    <!-- GOOGLE FONT -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <style>
        table
        {
            width:300px;
            height:250px;
        }
    </style>
</head>
<body >
       <!-- NAV SECTION -->
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Ant Colony Stream Clustering</a>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="AdminHome.jsp">HOME</a></li>
                    <li><a href="Upload.jsp">UPLOAD DATASET</a></li>
                     <li><a href="ViewDataset.jsp">VIEW DATASET</a></li>
                      <li><a href="Clusters.jsp">CLUSTERS</a></li>
                    <li><a href="index.html">LOGOUT</a></li>
                </ul>
            </div>
           
        </div>
    </div>
     <!--END NAV SECTION -->
    
   

   

    <!--SERVICES SECTION-->    
    <section  id="services-sec">
        <div class="container">
            <div class="row ">
                <h1>Admin Login</h1>
                 <div class="col-md-12 g-pad-bottom">
                  <div class="col-md-6">
                      <%String username=(String)session.getAttribute("username");%>
                      <h2>Welcome <%=username%></h2>
                      </div>
                 <div class="col-md-6">
                     <image src="images/Admin.jpg" width="400px" height="300px">
                      </div>
                     </div>
               
                <div class="col-md-12 text-center">
                    <div class="col-md-4 ">
                
                    </div>
                    <div class="col-md-4 ">
                    
                    </div>
                   
                    <div class="col-md-4">
                        
                    </div>
                </div>
                <div class="col-md-12 g-pad-bottom">
                  <div class="col-md-12">
                    
                      </div>
                 
                     </div>
            </div>
        </div>
    </section>
    <!--END SERVICES SECTION-->
     <!--STATS SECTION-->
    

    <!--FOOTER SECTION -->
    <div id="footer">
        2019 Venkat Java Projects | All Right Reserved 
         
    </div>
    <!-- END FOOTER SECTION -->

    <!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
    <!-- CORE JQUERY  -->
    <script src="assets/plugins/jquery-1.10.2.js"></script>
    <!-- BOOTSTRAP CORE SCRIPT   -->
    <script src="assets/plugins/bootstrap.js"></script>
  
    <!-- CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script>

</body>
</html>
