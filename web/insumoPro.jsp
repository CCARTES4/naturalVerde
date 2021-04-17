<%-- 
    Document   : insumos
    Created on : May 18, 2019, 4:52:21 PM
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
            //PROYECTO
            $(function () {
                $("#btnSeleccionar").on("click", function () {
                    $("#insumo").validate({
                        rules: {
                            cboProyecto: {
                                required: true
                            }
                        },
                        messages: {
                            cboProyecto: {
                                required: 'Porfavor, Selecccione un Proyecto'
                            }
                        }
                    });
                });
            });

            $(function () {
                $("#btnPagar").on("click", function () {
                    $("#Pago").validate({
                        rules: {
                            cboBanco: {
                                required: true
                            },
                            cboTipo: {
                                required: true
                            },
                            txtCuenta: {
                                required: true
                            },
                            txtCuotas: {
                                required: true,
                                digits: true
                            }
                        },
                        messages: {
                            cboBanco: {
                                required: 'Porfavor, Seleccione un Banco'
                            },
                            cboTipo: {
                                required: 'Porfavor, Seleccione un Tipo de Cuenta'
                            },
                            txtCuenta: {
                                required: 'Porfavor, Ingrese su Numero de Cuenta'
                            },
                            txtCuotas: {
                                required: 'Vacio',
                                digits: 'Nulo'
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
                patron = /[a-zA-Z\s]/;
                te = String.fromCharCode(tecla);
                return patron.test(te);
            }
            function numeros(e) {
                tecla = (document.all) ? e.keyCode : e.which;
                if (tecla == 8)
                    return true;
                else if (tecla == 0 || tecla == 9)
                    return true;
                patron = /[0-9\s]/;
                te = String.fromCharCode(tecla);
                return patron.test(te);
            }
        </script>

        <!--ETIQUETA-->
        <title>Insumos- Cliente</title>

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
        </div>
    <center>
        <section id="service" class="home-section color-dark bg-gray">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">

                        <!-- TITULO -->
                        <div class="section-heading text-center">
                            <br>
                            <h2 class="h-bold" style="color: green">Insumos Necesarios</h2>
                            <div class="divider-header"></div>
                        </div>

                        <!-- MENSAJES DE ALERTA -->
                        <c:if test="${resultado==true}">
                            <div class="alert alert-success">Se ah realizado el Pago Correctamente</div>
                        </c:if>
                        <c:if test="${resultado==false}">
                            <div class="alert alert-warning">No se pudo realizar Pago</div>
                        </c:if>
                    </div>
                </div>
            </div>
            <br>

            <form id="insumo" action="insumoProyecto" method="POST">
                <!-- INSUMOS -->
                <div class="text-center form-group">
                    <div class="container">
                        <div class="row animatedParent">
                            <div class="row">
                                <div class="animated bounceInUp">

                                    <!-- NOMBRE DEL PROYECTO -->
                                    <center>
                                        <div class="service-desc">
                                            <h5>Nombre del Proyecto: <span style="color: green">${nombre_proyecto}</span></h5>
                                            <br>
                                            <select class="form-control" style=" width:50%" name="cboProyecto">
                                                <option value="">Seleccionar</option>
                                                <c:forEach var="pro" items="${proyecto}">
                                                    <option value="${pro.getNombre_Proyecto()}">${pro.getNombre_Proyecto()}</option>
                                                </c:forEach>
                                            </select>
                                            <br>
                                            <input class="btn btn-skin" type="submit" name="btnAccion" id="btnSeleccionar" value="Seleccionar">
                                            <hr>
                                        </div>
                                    </center>

                                    <div class="box-register form-row">
                                        <div class="container-fluid">
                                            <!-- NUMERO REGISTRO -->
                                            <ul class="list-group col-md-1 service-desc">
                                                <h5>Numero</h5>
                                            </ul>

                                            <!-- REGISTROS DEL HISTORIAL -->
                                            <ul class="list-group col-md-4 service-desc">
                                                <h5>Descripcion</h5>
                                            </ul>

                                            <ul class="list-group col-md-2 service-desc">
                                                <h5>Tienda</h5>
                                            </ul>

                                            <!-- CANTIDAD -->
                                            <ul class="list-group col-md-1 service-desc">
                                                <h5>Cantidad</h5>
                                            </ul>

                                            <!--PRECIOS-->
                                            <ul class="list-group col-md-2 service-desc">
                                                <h5>Precio Unitario</h5>
                                            </ul>

                                            <!-- VALOR TOTAL -->
                                            <ul class="list-group col-md-2 service-desc">
                                                <h5>Precio Total</h5>
                                            </ul>
                                        </div>


                                        <div class="container-fluid">
                                            <c:forEach var="insu" items="${insumo}">
                                                <!-- NUMERO REGISTRO -->
                                                <ul class="list-group col-md-1 service-desc">
                                                    <li class="list-group-item">${insu.getCodInsumo()}</li>
                                                </ul>

                                                <!-- REGISTROS DEL HISTORIAL -->
                                                <ul class="list-group col-md-4 service-desc">
                                                    <li class="list-group-item">${insu.getDescripcion()}</li>
                                                </ul>

                                                <!-- TIENDA -->
                                                <ul class="list-group col-md-2 service-desc">
                                                    <li class="list-group-item">${insu.getTienda()}</li>
                                                </ul>

                                                <!-- CANTIDAD -->
                                                <ul class="list-group col-md-1 service-desc">
                                                    <li class="list-group-item">${insu.getCantidad()}</li>
                                                </ul>

                                                <!--PRECIOS-->
                                                <ul class="list-group col-md-2 service-desc">
                                                    <li class="list-group-item">$ ${insu.getPrecio()}</li>
                                                </ul>

                                                <!-- VALOR TOTAL -->
                                                <ul class="list-group col-md-2 service-desc">
                                                    <li class="list-group-item">$ ${insu.getPrecio() * insu.getCantidad()}</li>
                                                </ul>
                                            </c:forEach>
                                        </div>
                                    </div>
                                    <div class="box-register container-fluid">
                                        <div class="service-desc form-group col-md">
                                            <c:forEach var="precio" items="${insumo}"></c:forEach>
                                            <c:set var="total" value="${insumo.stream().map(precio -> precio.getPrecio() * precio.getCantidad()).sum()}"></c:set>
                                            <c:if test="${total==null}">
                                                <h5>Valor Total: <span>$ ${0}</span></h5>
                                            </c:if>
                                            <c:if test="${total!=null}">
                                                <h5>Valor Total: <span style="color:green">$ ${total}</span></h5>
                                            </c:if>
                                        </div>

                                        <!-- BOTON PAGAR -->
                                        <div class="bg-light service-desc" id="detalle">
                                            <div class="container">
                                                <div class="row">
                                                    <div class="col-md-12 mb-5 pb-md-5 pb-sm-1">
                                                        <div class="nav nav-pills justify-content-center text-center" id="v-pills-tab"
                                                             role="tablist" aria-orientation="vertical">
                                                            <c:if test="${total!=null}">
                                                                <c:if test="${validar==0}">
                                                                    <a class="btn btn-skin" id="v-pills-performance-tab" data-toggle="pill" href="#v-pills-performance"
                                                                       role="tab" aria-controls="v-pills-performance" aria-selected="false">Ir al Carrito de Compras</a>
                                                                </c:if>
                                                                <c:if test="${validar!=0}">
                                                                    <a class="btn btn-skin" id="v-pills-performance-tab" data-toggle="pill" href="#v-pills-performance"
                                                                       role="tab" aria-controls="v-pills-performance" aria-selected="false" disabled>Pagado</a>
                                                                </c:if>
                                                            </c:if>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div> 
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <form method="POST" action="pagoInsumo" id="Pago" autocomplete="off">
                <div class="service-desc">
                    <div class="col-md-12 align-items-center form-group animatedParent">
                        <div class="tab-pane fade" id="v-pills-performance" role="tabpanel"
                             aria-labelledby="v-pills-performance-tab">
                            <hr>
                            <div class="container">
                                <h5>Nombre Proyecto</h5>
                                <div class="col-md">
                                    <input type="text" class="form-control" style="text-align: center; color: green" readonly="true" name="txtNombre" value="${nombre_proyecto}">                               
                                </div>
                                <br>
                                <div class="form-group col-md-6">
                                    <h5>Seleccione Banco</h5>
                                    <div class="col-md-12">
                                        <select class="form-control" name="cboBanco">
                                            <option value="">Seleccionar</option>
                                            <c:forEach var="banco" items="${banco}">
                                                <option value="${banco.getNombre_Banco()}">${banco.getNombre_Banco()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group col-md-6">
                                    <h5>Seleccione Tipo de Cuenta</h5>
                                    <div class="col-md-12">
                                        <select class="form-control" name="cboTipo">
                                            <option value="">Seleccionar</option>
                                            <c:forEach var="tipo" items="${tipo}">
                                                <option value="${tipo.getTipo_Cuenta()}">${tipo.getTipo_Cuenta()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group col-md-6">
                                    <h5>Ingrese Numero de Cuenta</h5>
                                    <div class="col-md-12">
                                        <input type="text" class="form-control" style="text-align: center" onkeypress="return numeros(event)" maxlength="15"  name="txtCuenta">
                                    </div>
                                </div>
                                <div class="form-group col-md-6">
                                    <div class="col-md-2">
                                        <h5>Cuotas</h5>
                                        <input type="text" class="form-control" style="text-align: center" onkeypress="return numeros(event)" maxlength="2"  name="txtCuotas">
                                    </div>
                                    <div class="col-md-10">
                                        <h5>Valor Total :</h5>
                                        <input type="text" class="form-control" style="text-align: center" name="txtTotal" value="${total}" readonly="true">
                                    </div>
                                </div
                                <br>

                                <div class="form-group col-md">
                                    <br>
                                    <div class="col-md">
                                        <input type="submit" class="btn btn-skin" name="btnAccion" id="btnPagar" value="Pagar">
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