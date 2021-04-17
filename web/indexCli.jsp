<%-- 
    Document   : index
    Created on : May 18, 2019, 4:35:38 PM
    Author     : mjara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        <!-- ETIQUETA -->
        <title>Inicio - Cliente</title>

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
                            <li class="active"><a href="indexCli.jsp">Inicio</a></li>
                            <li><a href="solicitudProyecto">Solicitud en linea</a></li>
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
                            <li><a href="loginUsuario">Cerrar Sesion</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>

    <center>
        <!-- FOTO PRINCIPAL -->
        <section class="hero" id="intro">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 text-right navicon">
                        <a id="nav-toggle" class="nav_slide_button" href="#"><span></span></a>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-8 col-md-offset-2 text-center inner">
                        <div class="animatedParent">
                            <c:if test="${nombre!=null && apellido!=null}">
                                <h1 class="animated fadeInDown borde-texto">BIENVENIDO</h1>
                                <h1 class="animated fadeInDown borde-texto">${nombre} ${apellido}</h1>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- QUIENES SOMOS -->
        <section id="about" class="home-section color-dark bg-white">
            <!-- TITULO -->
            <div class="container marginbot-50">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="animatedParent">
                        <div class="section-heading text-center">
                            <h2 class="h-bold" style="color: green">Quienes Somos</h2>
                            <div class="divider-header"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2 animatedParent">
                        <div class="text-center  animated bounceInUp">
                            <p>
                                <br>
                                <br>
                                La empresa NaturalVerde dedicada al diseño de Jardines y Parques, así como de servicios
                                destinados
                                a decorar el entorno y el tratamiento de espacios y ambientación de los mismos.
                                NaturalVerde lleva años realizando exitosos proyectos de paisajismo, en el país y ofrece
                                servicios de
                                primer nivel, de cualquier tamaño. Para cada proyecto considera tres componentes para
                                lograr
                                el
                                tratamiento y ambientación de espacios; Componente Antrópico, que es la distribución de
                                suelo y su
                                uso. Componente Abiótico, Relieve y condiciones atmosféricas, rocas, agua, viento,
                                hielo,
                                etc.
                                Componentes Bióticos, que son las plantas, vegetación, árboles, césped, etc.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </section>


        <!-- NUESTROS SERVICIOS -->
        <section id="service" class="home-section color-dark bg-gray">
            <!-- TITULO -->
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="section-heading text-center">
                            <br>
                            <h2 class="h-bold" style="color: green">Nuestros Servicios</h2>
                            <div class="divider-header"></div>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <br>


            <!-- SISTEMAS DE RIEGOS -->
            <div class="text-center">
                <div class="container">
                    <div class="row animatedParent">
                        <div class="col-md-4">
                            <div class="animated bounceInUp">
                                <div class="service-box">
                                    <div class="service-icon">
                                        <span class="fa fa-code fa-2x"></span>
                                    </div>
                                    <div class="service-desc">
                                        <h5>Sistemas de Riegos</h5>
                                        <div class="divider-header"></div>
                                        <p>
                                            Nosotros regamos por ustedes.
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- OBRAS CIVILES -->
                        <div class="col-md-4">
                            <div class="animated bounceInUp">
                                <div class="service-box">
                                    <div class="service-icon">
                                        <span class="fa fa-code fa-2x"></span>
                                    </div>
                                    <div class="service-desc">
                                        <h5>Obras Civiles</h5>
                                        <div class="divider-header"></div>
                                        <p>
                                            Buscamos el descanso y bienestar de su familia.
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- ADMINISTRA TUS PROYECTOS -->
                        <div class="col-md-4">
                            <div class="animated bounceInUp">
                                <div class="service-box">
                                    <div class="service-icon">
                                        <span class="fa fa-code fa-2x"></span>
                                    </div>
                                    <div class="service-desc">
                                        <h5>Administra tus Proyectos</h5>
                                        <div class="divider-header"></div>
                                        <p>
                                            Brindamos seguimiento a tus proyectos
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <br>
        <br>

    </center>
    <!-- COMPLEMENTOS JS -->
    <script src="static/js/jquery.min.js"></script>
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