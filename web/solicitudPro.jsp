<%-- 
    Document   : solicitud
    Created on : May 18, 2019, 4:39:20 PM
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
        <script src="static/js/jquery.validate.js" type="text/javascript"></script>

        <!-- VALIDACIONES -->
        <script type="text/javascript">
            $(function () {
                $("#btnSolicitud").on("click", function () {
                    $("#solicitud").validate({
                        rules: {
                            txtNombre: {
                                required: true
                            },
                            cboServicio: {
                                required: true
                            },
                            cboEquipo: {
                                required: true
                            }
                        },
                        messages: {
                            txtNombre: {
                                required: 'Porfavor Asigne un Nombre a su Proyecto'
                            },
                            cboServicio: {
                                required: 'Porfavor, Seleccione algun Servicio a Contratar'
                            },
                            cboEquipo: {
                                required: 'Porfavor, Seleccione algun Equipo a Terreno'
                            }
                        }
                    });
                });
            });
            function letras(e) {
                tecla = (document.all) ? e.keyCode : e.which;
                if (tecla == 8)
                    return true;
                else if (tecla == 0 || tecla == 9)
                    return true;
                patron = /[a-zA-ZÑñ\s]/;
                te = String.fromCharCode(tecla);
                return patron.test(te);
            }
        </script>

        <!-- ETIQUETA -->
        <title>Crear Proyecto - Cliente</title>

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
                            <h2 class="h-bold" style="color: green">Solicitud de Servicios</h2>
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

            <!-- FORMULARIO -->
            <form method="POST" id="solicitud" action="solicitudProyecto" autocomplete="off">
                <div class="text-center form-group">
                    <div class="container">
                        <div class="row animatedParent">
                            <div class="animated bounceInUp">
                                <div class="box-register form-row">

                                    <!-- NOMBRE PROYECTO NUEVO -->
                                    <div class="service-desc form-group col-md-6">
                                        <h5>Nombre Proyecto:</h5>
                                        <input class="form-control" style="text-align: center" onkeypress="return letras(event)" type="text" name="txtNombre">
                                    </div>

                                    <!-- SERVICIO A CONTRATAR -->
                                    <div class="service-desc form-group col-md-6">
                                        <h5>Servicio a Contratar:</h5>
                                        <select class="form-control" name="cboServicio" id="cboServicio">
                                            <option value="">Seleccionar</option>
                                            <option value="DISEÑO DE JARDIN">Diseño de Jardines</option>
                                            <option value="PAISAJISMO">Paisajismo</option>
                                            <option value="SISTEMA DE RIEGOS">Sistema de Riegos</option>
                                            <option value="OBRAS CIVILES">Obras Civiles</option>
                                            <option value="COTIZACION">Cotizaciones y Desarrollo de Proyectos</option>
                                        </select>
                                    </div>

                                    <!-- EQUIPOS A TERRENO -->
                                    <div class="service-desc form-group col-md-6">
                                        <h5>Seleccione Equipo a Terreno</h5>
                                        <Select class="form-control" name="cboEquipo" id="cboEquipo">
                                            <option value="">Seleccionar</option>
                                            <c:forEach var="equi" items="${equipo}">
                                                <option>${equi.getNombre_Equipo()}</option>
                                            </c:forEach>
                                        </Select>
                                    </div>

                                    <!-- BOTON -->
                                    <div class="box-register">
                                        <input class="btn btn-skin" type="submit" id="btnSolicitud" value="Enviar Solicitud">
                                    </div>

                                    <!-- BOTON AGENDAR HORA -->
                                    <div class="service-desc box-register">
                                        <h5>Agendar Hora a Terreno</h5>
                                        <a class="btn btn-skin" href="solicitudAgendar">Agendar Hora</a>
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
    <script src="static/otros/contactform/contactform.js  "></script>
</body>

</html>