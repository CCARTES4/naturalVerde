<%-- 
    Document   : login
    Created on : May 18, 2019, 4:19:07 PM
    Author     : mjara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- COMPLEMENTOS CSS-->
        <link rel="stylesheet" href="static/css/animations.css">
        <link rel="stylesheet" href="static/css/bootstrap.css">
        <link rel="stylesheet" href="static/css/bootstrap.min.css">
        <link rel="stylesheet" href="static/css/nivo-lightbox.css">
        <link rel="stylesheet" href="static/css/style.css">
        <link rel="stylesheet" href="static/css/nivo-lightbox-theme/default/default.css">
        <link rel="stylesheet" href="adicionales/color/default.css">
        <link rel="stylesheet" href="adicionales/font-awesome/css/font-awesome.css">
        <link rel="stylesheet" href="adicionales/font-awesome/css/font-awesome.min.css">

        <!-- JS VALIDACIONES -->
        <script src="static/js/jquery.min.js" type="text/javascript"></script>
        <script src="static/js/jquery.validate.min.js" type="text/javascript"></script>
        <script src="static/js/validarRut.js" type="text/javascript"></script>

        <!-- VALIDACIONES -->
        <script type="text/javascript">
            $(function () {
                $("#btnEntrar").on("click", function () {
                    $("#login").validate({
                        rules: {
                            txtRut: {
                                required: true
                            },
                            txtPass: {
                                required: true
                            }
                        },
                        messages: {
                            txtRut: {
                                required: 'Porfavor Ingrese su Rut'
                            },
                            txtPass: {
                                required: 'Porfavor Ingrese su Contraseña'
                            }
                        }
                    });
                });
            });
            function formatoRut(e) {
                tecla = (document.all) ? e.keyCode : e.which;
                if (tecla == 8)
                    return true;
                else if (tecla == 0 || tecla == 9)
                    return true;
                patron = /[0-9Kk\s]/;
                te = String.fromCharCode(tecla);
                return patron.test(te);
            }
        </script>
        
        <!-- ETIQUETA -->
        <title>Login</title>

    </head>

    <body>

        <!-- MENU -->
        <div class="navigation navbar-fixed-top">
            <nav class="navbar navbar-default" role="navigation">
                <div class="container">
                    <div class="col-md-2">
                        <div class="site-logo">
                            <a href="index.jsp" class="brand">NaturalVerde</a>
                        </div>
                    </div>
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#menu">
                            <i class="fa fa-bars"></i>
                        </button>
                    </div>
                    <div class="collapse navbar-collapse" id="menu">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="index.jsp">Home</a></li>
                            <li><a href="registro.jsp">Registro</a></li>
                            <li class="active"><a href="login.jsp">Login</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>

    <center>
        <!-- TITULO -->
        <section id="service" class="home-section color-dark bg-gray">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="section-heading text-center">
                            <br>
                            <h2 class="h-bold" style="color: green">Iniciar Sesion</h2>
                            <div class="divider-header"></div>
                            <c:if test="${error!=null}">
                                <div class="alert alert-danger">${error}</div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
            </div>
            <br>

            <!-- FORMULARIO (SESION) -->
            <form method="POST" id="login" action="loginUsuario" autocomplete="off">
                <div class="text-center form-group">
                    <div class="container">
                        <div class="row animatedParent">
                            <div class="row">
                                <div class="animated animated bounceInUp">
                                    <div class="box-register form-row">

                                        <!-- USUARIO -->
                                        <div class="service-desc form-group col-md-6">
                                            <h5>Ingrese su Rut:</h5>
                                            <input class="form-control" style="text-align: center" type="text"
                                                   name="txtRut" oninput="checkRut(this)" onkeypress="return formatoRut(event)" maxlength="10" placeholder="Ingrese su Rut (11111111-1)">
                                        </div>

                                        <!-- CONTRASEÑA -->
                                        <div class="service-desc form-group col-md-6">
                                            <h5>Ingrese su Contraseña:</h5>
                                            <input class="form-control" style="text-align: center" type="password"
                                                   name="txtPass" placeholder="Ingrese su Contraseña">
                                        </div>

                                        <!-- BOTON -->
                                        <div class="box-register">
                                            <input class="btn btn-skin" type="submit" id="btnEntrar" value="Entrar">
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </section>
    </center>

    <!-- COMPLEMENTOS JS -->
    <script src="static/js/bootstrap.min.js"></script>
    <script src="static/js/jquery.sticky.js"></script>
    <script src="static/js/jquery.easing.min.js"></script>
    <script src="static/js/jquery.scrollTo.js"></script>
    <script src="static/js/jquery.appear.js"></script>
    <script src="static/js/stellar.js"></script>
    <script src="static/js/nivo-lightbox.min.js"></script>
    <script src="static/js/custom.js"></script>
    <script src="static/js/css3-animate-it.js"></script>
</body>

</html>