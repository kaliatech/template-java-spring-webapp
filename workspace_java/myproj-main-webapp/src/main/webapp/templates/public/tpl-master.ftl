<!DOCTYPE html>
<#--
Template Properties:

 - title    : page title
 - cssFiles : page specific CSS references
 - cssCode 	: page specific CSS
 - metaTags : page specific meta tags
 
 - bodyClass : used as body class
 - containerClass : used to override for 100% layouts

 - breadcrumb  : page HTML
 - content  : page HTML

 - jsFiles : page specific JS file references
 - jsCode  : page specific JS code
 -->
<#if !mainMenu??>
	<#assign mainMenu=""/>
</#if>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>${title!'myproj'}</title>
<meta name="description" content="">
<meta name="author" content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="${config.myprojWebStaticUrl}/c/libs/bootstrap-2.3.1/bootstrap.min.css">
<link rel="stylesheet" href="${config.myprojWebStaticUrl}/c/libs/bootstrap-2.3.1/bootstrap-responsive.min.css">

<link rel="stylesheet" href="${config.myprojWebStaticUrl}/c/libs/jquery-ui-1.10.2-smoothness/jquery-ui-1.10.2.min.css">
<link rel="stylesheet" href="${config.myprojWebStaticUrl}/c/libs/jquery.datatables-1.9.4/demo_table_jui.css">

<!--
<link rel="stylesheet/less" href="/path/to/bootstrap.less">
<link rel="stylesheet/less" href="${config.myprojWebStaticUrl}/less/style-myproj.less">
<script src="${config.myprojWebStaticUrl}/j/libs/less-1.3.0.min.js"></script>
-->

<!--
Use SimpLESS (Win/Linux/Mac) or LESS.app (Mac) to compile .less files to style-myproj.css,
and replace the 2 lines above by this one:
<link rel="stylesheet" href="${config.myprojWebStaticUrl}/c/style-myproj.css">
-->

<script src="${config.myprojWebStaticUrl}/j/libs/modernizr-2.6.2.js"></script>

${cssCode!}

</head>
 <body>
 <!--[if lt IE 7]><p class=chromeframe>Your browser is <em>ancient!</em> <a href="http://browsehappy.com/">Upgrade to a different browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to experience this site.</p><![endif]-->
 <div class="navbar">
 <div class="navbar-inner">
     <div class="container">
         <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
             <span class="icon-bar"></span>
             <span class="icon-bar"></span>
             <span class="icon-bar"></span>
         </a>
         <a class="brand" href="${contextPath}/">myproj</a>
         <div class="nav-collapse">
             <ul class="nav">
                 <li<#if (mainMenu == "home")> class="active"</#if>><a href="${contextPath}">Home</a></li>
                 <li<#if (mainMenu == "section1")> class="active"</#if>><a href="${contextPath}/section1/">Section 1</a></li>
             </ul>
         </div><!--/.nav-collapse -->
     </div>
 </div>
 </div>

 <div class="${containerClass!"container"}">

${content!}

 <hr>
 <footer>
     <div class="row-fluid">
       <div class="span10">
	     <p>
	     email <a href="mailto:me@mycompany.com">me@mycompany.com</a><br/> 
		 web <a href="https://www.mycompany.com/">www.mycompany.com</a><br/>
		 phone +01 123.123.1234<br/>
		 </p>
       </div>
       <div class="span2" style="text-align:right">
         Build: [[BUILD_NUM]]<br/>
         [[BUILD_DATE]]<br/>
	     &copy; ${now?string("yyyy")}<br/>
       </div>
     </div>
 </footer>

 </div> <!-- container -->
 <script src="${config.myprojWebStaticUrl}/j/libs/jquery-2.0.0.min.js"></script>
 <script src="${config.myprojWebStaticUrl}/j/libs/jquery-ui-1.10.2/jquery-ui-1.10.2.min.js"></script>
 <script src="${config.myprojWebStaticUrl}/j/libs/bootstrap-2.3.1.min.js"></script>

 <script src="${config.myprojWebStaticUrl}/j/libs/moment-2.0.0.min.js"></script> 
 <script src="${config.myprojWebStaticUrl}/j/libs/jsrender-20130423.js"></script>

 <script src="${config.myprojWebStaticUrl}/j/libs/raf-20130423.js"></script>
 
 <script src="${config.myprojWebStaticUrl}/j/libs/jquery.datatables-1.9.4/jquery.dataTables.min.js"></script>
 
 <script src="${config.myprojWebStaticUrl}/j/plugins.js"></script>
 <script src="${config.myprojWebStaticUrl}/j/script.js"></script>

${jsFiles!}

${jsCode!}

<#---
 <script>
     var _gaq=[['_setAccount','UA-XXXXX-X'],['_trackPageview']];
     (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
         g.src=('https:'==location.protocol?'//ssl':'//www')+'.google-analytics.com/ga.js';
         s.parentNode.insertBefore(g,s)}(document,'script'));
 </script>
--->

 </body>
 </html>