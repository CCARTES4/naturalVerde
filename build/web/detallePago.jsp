<%-- 
    Document   : detallePago
    Created on : Jun 27, 2019, 10:04:24 PM
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

        <!-- ETIQUETA -->
        <title>Detalle Pago - Cliente</title>
    </head>

    <body>
        <!-- MENU -->
        <div class="navigation navbar-fixed-top">
            <nav class="navbar navbar-default" role="navigation">
                <div class="container">
                    <div class="col-md-2">
                        <div class="site-logo">
                            <a href="indexCli.jsp" class="brand">NaturalVerde</a>
                        </div>
                    </div>
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#menu">
                            <i class="fa fa-bars"></i>
                        </button>
                    </div>
                    <div class="collapse navbar-collapse" id="menu">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="indexCli.jsp">Inicio</a></li>
                            <li><a href="solicitudProyecto">Solicitud en Linea</a></li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Estado de Solicitud
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="estadoSolicitud">SOLICITUD PROYECTO</a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="estadoHora">HORA AGENDADA</a>
                                </div>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Monitorear Proyectos
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="historialProyecto">HISTORIAL</a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="insumoProyecto">INSUMOS</a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="informacionEquipo">INFORMACIÓN DEL EQUIPO</a>
                                </div>
                            </li>
                            <li><a href="login.jsp">Cerrar Sesion</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>x
    <center>

        <!-- TITULO -->
        <section id="service" class="home-section color-dark bg-gray">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="section-heading text-center">
                            <br>
                            <h2 class="h-bold" style="color: green">Detalle de Compra</h2>
                            <div class="divider-header"></div>

                            <!-- MENSAJE DE ALERTA -->
                            <div class="container-fluid">
                                <c:if test="${resultado==true}">
                                    <div class="alert alert-success">Pago realizado Correctamente</div>
                                </c:if>
                                <c:if test="${resultado==false}">
                                    <div class="alert alert-warning">No se pudo realizar Pago</div>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <br>

            <!-- DETALLE COMPRA -->
            <form id="registro" method="POST" action="registroUsuario" autocomplete="off">
                <div class="text-center form-group">
                    <div class="container">
                        <div class="row animatedParent">
                            <div class="animated bounceInUp">
                                <div class="box-register form-row">

                                    <!-- CODIGO CARRITO -->
                                    <div class="service-desc form-group col-md-6">
                                        <h5>Codigo Carrito:</h5>
                                        <input class="form-control" style="text-align: center" type="text"
                                               name="txtCarrito" id="txtCarrito" value="${codcarrito}" readonly="true">
                                    </div>

                                    <!-- NOMBRE PROYECTO -->
                                    <div class="service-desc form-group col-md-6">
                                        <h5>Nombre Proyecto:</h5>
                                        <input class="form-control" style="text-align: center" type="text"
                                               name="txtNombre" id="txtNombre" value="${nombrepro}" readonly="true">
                                    </div>
                                    <br>

                                    <!-- NUMERO DE CUENTA -->
                                    <div class="service-desc form-group col-md-6">
                                        <h5>Numero de Cuenta:</h5>
                                        <input class="form-control" style="text-align: center" type="text"
                                               name="txtCuenta" id="txtCuenta" value="${numcuenta}" readonly="true">
                                    </div>

                                    <!-- NOMBRE DEL BANCO -->
                                    <div class="service-desc form-group col-md-6">
                                        <h5>Nombre Banco:</h5>
                                        <input class="form-control" style="text-align: center" type="text"
                                               name="txtBanco" id="txtBanco" value="${nombrebanco}" readonly="true">
                                    </div>
                                    <br>

                                    <!-- TIPO DE CUENTA -->
                                    <div class="service-desc form-group col-md-6">
                                        <h5>Tipo de Cuenta:</h5>
                                        <input class="form-control" style="text-align: center" type="text"
                                               name="txtTipo" id="txtTipo" value="${tipocuenta}" readonly="true">
                                    </div>

                                    <!-- CUOTAS (VALORES) -->
                                    <div class="service-desc form-group col-md-6">
                                        <!-- CUOTAS -->
                                        <div class="col-md-2">
                                            <h5>Cuotas</h5>
                                            <input class="form-control" style="text-align: center" type="text"
                                                   name="txtCuota" id="txtCuota" value="${numcuotas}" readonly="readonly">
                                        </div>


                                        <!-- VALOR DE CUOTA -->
                                        <div class="col-md-10">
                                            <h5>Valor Cuota</h5>
                                            <input class="form-control" style="text-align: center" type="text"
                                                   name="txtValor" id="txtValor" value="$ ${valorCuota}" readonly="true">
                                        </div>
                                    </div>

                                    <br>

                                    <!-- BOTON -->
                                    <div class="box-register service-desc">
                                        <br>
                                        <h5>Valor Total <span style="color: green">$ ${total}</span></h5>
                                        <a class="btn btn-skin" href="insumoProyecto">Volver</a>
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