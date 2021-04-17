<%-- 
    Document   : agendar
    Created on : May 18, 2019, 4:56:21 PM
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

        <!-- VALIDACIONES -->
        <script type="text/javascript">
            $(function () {
                $("#btnAgendar").on("click", function () {
                    $("#solicitud").validate({
                        rules: {
                            cboProyecto: {
                                required: true
                            },
                            txtFecha: {
                                required: true
                            },
                            txtHora: {
                                required: true
                            }
                        },
                        messages: {
                            cboProyecto: {
                                required: 'Porfavor, Seleccione un Proyecto'
                            },
                            txtFecha: {
                                required: 'Porfavor, Ingrese Fecha a Terreno'
                            },
                            txtHora: {
                                required: 'Porfavor, Ingrese Hora a Terreno'
                            }
                        }
                    });
                });
            });
        </script>

        <!-- ETIQUETA -->
        <title>Agendar Hora - Cliente</title>

    </head>

    <body>
        <!-- MENU -->
        <div class="navigation navbar-fixed-top">
            <nav class="navbar navbar-default" role="navigation">
                <div class="container">
                    <div class="col-md-2">
                        <div class="site-logo">
                            <a href="indexCli.php" class="brand">NaturalVerde</a>
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
                            <li class="active"><a href="solicitudProyecto">Solicitud en Linea</a></li>
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
        </div>


    <center>
        <!-- TITULO -->
        <section id="service" class="home-section color-dark bg-gray">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="section-heading text-center">
                            <br>
                            <h2 class="h-bold" style="color: green">Agendar Hora a Terreno</h2>
                            <div class="divider-header"></div>

                            <!-- MENSAJE DE ALERTA -->
                            <div class="container-fluid">
                                <c:if test="${respuesta==true}">
                                    <div class="alert alert-success">Solicitud enviada Correctamente</div>
                                </c:if>
                                <c:if test="${respuesta==false}">
                                    <div class="alert alert-danger">Nombre de Proyecto ya Existente</div>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <br>

            <!-- FORMULARIO AGENDAR -->
            <form method="POST" action="solicitudAgendar" id="solicitud" autocomplete="off">
                <div class="text-center form-group">
                    <div class="container">
                        <div class="row animatedParent">
                            <div class="row">
                                <div class="animated bounceInUp">
                                    <div class="box-register form-row">


                                        <!-- SELECCIONAR PROYECTO -->
                                        <div class="service-desc form-group col-md-6">
                                            <h5>Mis Proyectos</h5>
                                            <select class="form-control" name="cboProyecto" id="cboProyecto">
                                                <option value="">Seleccionar</option>
                                                <c:forEach var="pro" items="${proyecto}">
                                                    <option>${pro.getNombre_Proyecto()}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <!-- FECHA A TERRENO -->
                                        <div class="service-desc form-group col-md-6">
                                            <h5>Fecha a Terreno</h5>
                                            <input class="form-control" style="text-align: center" type="date"
                                                   name="txtFecha" id="txtFecha">
                                        </div>

                                        <!-- HORA A TERRENO -->
                                        <div class="service-desc form-group col-md-6">
                                            <h5>Hora a Terreno</h5>
                                            <input class="form-control" style="text-align: center" type="time"
                                                   name="txtHora" id="txtHora">
                                        </div>


                                        <!--BOTON INFORMACIÓN SOBRE EQUIPO-->
                                        <div class="box-register">
                                            <!-- BOTON AGENDAR -->
                                            <input class="btn btn-skin" type="submit" id="btnAgendar" value="Agendar Hora">
                                            <!-- BOTON VOLVER -->
                                            <a class="btn btn-skin" href="solicitudPro.jsp">Volver</a>
                                        </div>
                                    </div> 
                                    <br>

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