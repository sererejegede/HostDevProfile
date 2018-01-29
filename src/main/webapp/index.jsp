<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>The Developer's Choice</title>

    <!-- Bootstrap core CSS -->
    <link href="grayscale/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="grayscale/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <script src="grayscale/js/jquery-3.2.1.js" type="text/javascript"></script>

    <!-- Custom styles for this template -->
    <link href="grayscale/css/grayscale.min.css" rel="stylesheet">
    

  </head>

  <body id="page-top">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="index.jsp">Developer Profile</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class=" hov nav-link btn btn-primary hide" id="home">Back</a>
            </li>
<!--            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#download">Download</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#contact">Contact</a>
            </li>-->
          </ul>
        </div>
      </div>
    </nav>

    <!-- Intro Header -->
    <header class="masthead">
      <div class="intro-body">
        <div class="container-fluid">
          <div class="row">
            <div class="col-lg-6 mx-auto">
              <h1 class="brand-heading">The <br>Developer's Choice</h1>
              <p class="intro-text">A simple application to record the
                <br>most preferred programming language of developers</p>
              <!--<a href="#about" class="btn btn-circle js-scroll-trigger">-->
                <!--<i class="fa fa-angle-double-down animated"></i>-->
              <!--</a>-->
            </div>
            <div class="col-lg-6">
              <div class="row">
                <div class="col-2"></div>
                
                <div class="col-7 card-body login-form" id="loginDiv">
                  <h5>Select Your Preference</h5>
                  <h6 id="err-disp" class="dispa"></h6>
               <form>   
                <table class="table table-hover table-striped">
                  <tr>
                    <th>First Option </th>
                    <td>
                      <select id="first" name="first">
                          <option disabled="true" selected>-Select Option-</option>
                        <option>Java</option>
                        <option>FORTRAN</option>
                        <option>Python</option>
                        <option>C</option>
                        <option>C++</option>
                        <option>C#</option>
                        <option>PHP</option>
                        <option>JavaScript</option>
                        <option>Swift</option>
                        <option>Arduino</option>
                        <option>Ruby</option>
                        <option>MATLAB</option>
                        <option>HTML</option>
                        <option>Perl</option>
                        <option>SQL</option>
                      </select>
                    </td>
                  </tr>

                  <tr>
                    <th>Second Option </th>
                    <td>
                      <select id="second" name="second">
                        <option disabled="true" selected>-Select Option-</option>
                        <option>Java</option>
                        <option>FORTRAN</option>
                        <option>Python</option>
                        <option>C</option>
                        <option>C++</option>
                        <option>C#</option>
                        <option>PHP</option>
                        <option>JavaScript</option>
                        <option>Swift</option>
                        <option>Arduino</option>
                        <option>Ruby</option>
                        <option>MATLAB</option>
                        <option>HTML</option>
                        <option>Perl</option>
                        <option>SQL</option>
                      </select>
                    </td>
                  </tr>

                  <tr>
                    <th>Third Option </th>
                    <td>
                      <select id="third" name="third">
                        <option disabled="true" selected>-Select Option-</option>
                        <option>Java</option>
                        <option>FORTRAN</option>
                        <option>Python</option>
                        <option>C</option>
                        <option>C++</option>
                        <option>C#</option>
                        <option>PHP</option>
                        <option>JavaScript</option>
                        <option>Swift</option>
                        <option>Arduino</option>
                        <option>Ruby</option>
                        <option>MATLAB</option>
                        <option>HTML</option>
                        <option>Perl</option>
                        <option>SQL</option>
                      </select>
                    </td>
                  </tr>
                  <tr>
                      <td colspan="2"><button id="modal-pop" type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                      Submit
                    </button></td>
                  </tr>
                </table>
               </form>
                  
              </div>
                
                <div class="col-7" id="list">
                    
               </div>
                <div class="col-2"></div>
              </div>
            <div class="row">
                
            </div>
                
              <!----------Modal**********-->


              <!-- The Modal -->
              <div class="modal fade" id="myModal">
                <div class="modal-dialog">
                  <div class="modal-content">
                    <!-- Modal Header -->
<!--                    <div class="modal-header">
                        <h4 id="modal-header" class="modal-title">Login</h4> <br>
                      <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>-->
                    <div class="row rowlink">
                        <div class="col-sm-6"><button id="login" class="btn btn-info">Login</button></div>
                        <div class="col-sm-6"><button id="reg" class="extra btn btn-info">Register</button></div>
                      </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <h6 class="dispa" id="disp"></h6>
                        <div class='tab-content'>
                        <div id="loginModal">
                      <form id="loginForm" action="Main" method="POST">
                          <label for="username">Username</label>
                          <input class="input-group input-padding" id="username" type="text" name="userName"/><br>
                          <label for="password">Password</label>
                          <input class="input-group input-padding" id="password" type="password" name="password"/><br>
                          <button class="btn btn-success" id="forLogin" type="button">Submit <i id="spin"></i></button>  
                      </form>
                    </div>   
                     <h6 class="dispa" id="dispR"></h6>
                     <div id="regModal" class="regModal">
                      <form id="" action="Login" method="POST">
                        <label for="fname">First Name</label>
                        <input class="input-group input-padding" id="fname" type="text" name="fname"/><br>
                        <label for="lname">Last Name</label>
                        <input class="input-group input-padding" id="lname" type="text" name="lname"/><br>
                        <label for="usernameR">Username</label>
                        <input class="input-group input-padding" id="usernameR" type="text" name="username"/><br>
                        <label for="passwordR">Password</label>
                        <input class="input-group input-padding" id="passwordR" type="password" name="password"/><br>
                        <div class="div1"> <button class="btn btn-success" id="forReg" type="button" value="Submit">Submit <i id="spin"></i></button>  </div>
                      </form>
                     </div>
                     </div>       
                     <br>
<!--                      <div class="row rowlink">
                        <div class="col-sm-6"><button id="login" class="btn btn-info" onclick="login()">Login</button></div>
                        <div id="reg" class="col-sm-6"><button class="extra btn btn-info" onclick="reg()">Register</button></div>
                      </div>-->
                    </div>

                    <!-- Modal footer -->
<!--                    <div class="modal-footer">
                      <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>-->

                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </header>


<script>
//        function login() {
//            var x = document.getElementById("loginModal");
//            var y = document.getElementById("regModal");
//            
//            
//                x.style.display = "block";
//                document.getElementById("modal-header").innerHTML = "Login";
//                y.style.display = "none";
//        }
//        function reg() {
//            var x = document.getElementById("loginModal");
//            var y = document.getElementById("regModal");
//
//                y.style.display = "block";
//                document.getElementById("modal-header").innerHTML = "Register";
//                x.style.display = "none";
//
//        }

    </script>
    <!-- Bootstrap core JavaScript -->
    
    <script src="grayscale/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    
    <!--<script src="grayscale/vendor/jquery-easing/jquery.easing.min.js"></script>-->
    

    

    <!-- Custom scripts for this template -->
    <script src="grayscale/js/grayscale.js"></script>
    

  </body>

</html>
