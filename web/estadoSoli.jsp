<%-- 
    Document   : estado
    Created on : May 18, 2019, 4:44:04 PM
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
                $("#btnSeleccionar").on("click", function () {
                    $("#estado").validate({
                        rules: {
                            cboProyecto: {
                                required: true
                            }
                        },
                        messages: {
                            cboProyecto: {
                                required: 'Porfavor, Seleccione un Proyecto'
                            }
                        }
                    });
                });
            });
        </script>

        <!--ETIQUETA-->
        <title>Estado de Proyecto - Cliente</title>

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
                            </li>s
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
        <section id="service" class="home-section color-dark bg-gray">
            <!-- TITULO -->
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="section-heading text-center">
                            <br>
                            <h2 class="h-bold" style="color: green">Estado de Solicitud</h2>
                            <div class="divider-header"></div>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <br>

            <!-- INFORMACION SOBRE EL ESTADO DEL PROYECTO -->
            <form method="POST" action="estadoSolicitud" id="estado" autocomplete="off">
                <div class="text-center form-group">
                    <div class="container">
                        <div class="row animatedParent">
                            <div class="row">
                                <div class="animated bounceInUp">
                                    <div class="box-register form-row col-md-6">

                                        <!-- SELECCIONAR PROYECTO -->
                                        <div class="service-desc form-group col-md">
                                            <!-- RESCATA LOS PROYECTO-->
                                            <h5>Mis Proyectos</h5>
                                            <hr>
                                            <br>
                                            <select class="form-control" name="cboProyecto" id="cboProyecto">
                                                <option value="">Seleccionar</option>
                                                <c:forEach var="pro" items="${proyecto}">
                                                    <option>${pro.getNombre_Proyecto()}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <!-- BOTON SELECCIONAR-->
                                        <div class="service-desc form-group">
                                            <input class="btn btn-skin" type="submit" name="btnAccion" id="btnSeleccionar" value="Seleccionar">
                                        </div>

                                    </div>

                                    <!-- NOMBRE PROYECTO-->
                                    <div class="service-desc form-group col-md-6">
                                        <h5>Nombre Proyecto</h5>
                                        <c:if test="${nombreProyecto!=null}">
                                            <input class="form-control" style="text-align: center" type="text" name="txtNombre" readonly="true" value="${nombreProyecto}">
                                        </c:if>
                                        <c:if test="${nombreProyecto==null}">
                                            <input class="form-control" style="text-align: center" type="text" name="txtNombre" readonly="true">
                                        </c:if>
                                    </div>

                                    <!-- EQUIPO A TERRENO -->
                                    <div class="service-desc form-group col-md-6">
                                        <h5>Equipo a Terreno</h5>
                                        <c:if test="${equipo!=null}">
                                            <input class="form-control" style="text-align: center" type="text"
                                                   name="txtEquipo" id="txtEquipo" readonly="true" value="${equipo}">
                                        </c:if>
                                        <c:if test="${equipo==null}">
                                            <input class="form-control" style="text-align: center" type="text"
                                                   name="txtEquipo" id="txtEquipo" readonly="true">
                                        </c:if>
                                    </div>

                                    <div class="service-desc form-group col-md-6">
                                        <h5>Servicio a Contratar</h5>
                                        <c:if test="${servicio!=null}">
                                            <input class="form-control" style="text-align: center" type="text"
                                                   name="txtServicio" id="txtServicio" readonly="true" value="${servicio}">
                                        </c:if>
                                        <c:if test="${servicio==null}">
                                            <input class="form-control" style="text-align: center" type="text"
                                                   name="txtServicio" id="txtServicio" readonly="true">
                                        </c:if>
                                    </div>

                                    <!--ESTADO SOLICITUD-->
                                    <div class="service-desc form-group col-md-6">
                                        <h5>Estado</h5>
                                        <c:if test="${estado!=null}">
                                            <input class="form-control" style="text-align: center; color: green" type="text"
                                                   name="txtEstado" id="txtEstado" readonly="true" value="${estado}">
                                        </c:if>
                                        <c:if test="${estado==null}">
                                            <input class="form-control" style="text-align: center; color: green" type="text"
                                                   name="txtEstado" id="txtEstado" readonly="true">
                                        </c:if>
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