/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.conexion.Conexion;
import modelo.entidades.Banco;
import modelo.entidades.Carrito;
import modelo.entidades.Cliente;
import modelo.entidades.Equipo;
import modelo.entidades.Historial;
import modelo.entidades.Insumo;
import modelo.entidades.Proyecto;
import modelo.entidades.Solicitud;
import modelo.entidades.Tipo_Cuenta;
import modelo.entidades.Trabajador;
import modelo.entidades.Usuario;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author mjara
 */
public class daoControlador {

    private Connection conexion;

    public daoControlador() {
    }

    //AGREGAR USUARIO
    public boolean AgregarUsuario(Usuario usu) throws SQLException {
        boolean respuesta = false;
        try {
            //OBTENEMOS LA CONEXION
            this.conexion = new Conexion().obtenerConexion();
            //LLAMAMOS AL PROCEDIMIENTO ALMACENANDOLO EN UNA VARIABLE
            String agregarUsuario = "{ CALL SP_AGREGAR_USUARIO(?,?,?) }";
            //LLAMAMOS A LA CONEXION NUEVAMENTE PARA ASI VALIDAR EL ARREGLO ALMACENADO
            CallableStatement cstmt = this.conexion.prepareCall(agregarUsuario);
            //VARIABLES DE CAPTURA
            cstmt.setString(1, usu.getRutCliente());
            cstmt.setString(2, usu.getContrasena());
            cstmt.setString(3, usu.getTipo_Usuario());

            //VALIDAMOS 
            if (cstmt.executeUpdate() > 0) {
                respuesta = true;
            } else {
                respuesta = false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //CERRAMOS LA CONEXION
            this.conexion.close();
        }
        return respuesta;
    }

    //AGREGAR CLIENTE
    public boolean AgregarCliente(Cliente cli) throws SQLException {
        boolean respuesta = false;
        try {
            //OBTENEMOS LA CONEXION
            this.conexion = new Conexion().obtenerConexion();
            //LLAMAMOS AL PROCEDIMIENTO ALMACENANDOLO EN UNA VARIABLE
            String AgregarCliente = "{ CALL SP_AGREGAR_CLIENTE(?,?,?,?,?) }";
            //LLAMAMOS A LA CONEXION NUEVAMENTE PARA ASI VALIDAR EL ARREGLO ALMACENADO
            CallableStatement cstmt = this.conexion.prepareCall(AgregarCliente);
            //VARIABLES DE CAPTURA
            cstmt.setString(1, cli.getRutCliente());
            cstmt.setString(2, cli.getNombre());
            cstmt.setString(3, cli.getApellido());
            cstmt.setInt(4, cli.getTelefono());
            cstmt.setString(5, cli.getCorreo());

            //VALIDAMOS 
            if (cstmt.executeUpdate() > 0) {
                respuesta = true;
            } else {
                respuesta = false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //CERRAMOS LA CONEXION
            this.conexion.close();
        }
        return respuesta;
    }

    //Ingresar Carrito
    public boolean IngresarCarrito(Carrito carrito) throws SQLException {
        boolean respuesta = false;

        try {
            this.conexion = new Conexion().obtenerConexion();
            String IngresarCarrito = "{ CALL SP_INGRESAR_CARRITO(?,?,?,?,?,?,?,?) }";
            CallableStatement cstmt = this.conexion.prepareCall(IngresarCarrito);
            cstmt.setInt(1, carrito.getCodCarrito());
            cstmt.setString(2, carrito.getNombre_Proyecto());
            cstmt.setString(3, carrito.getNumCuenta());
            cstmt.setString(4, carrito.getNombre_Banco());
            cstmt.setString(5, carrito.getTipo_Cuenta());
            cstmt.setInt(6, carrito.getNumCuota());
            cstmt.setInt(7, carrito.getTotalPagar());
            cstmt.setInt(8, carrito.getValorCuota());

            if (cstmt.executeUpdate() > 0) {
                respuesta = true;
            } else {
                respuesta = false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            this.conexion.close();
        }
        return respuesta;
    }

    //AGREGAR PROYECTO
    public boolean AgregarProyecto(Proyecto pro) throws SQLException {
        boolean respuesta = false;

        try {
            //OBTENEMOS LA CONEXION
            this.conexion = new Conexion().obtenerConexion();
            //LLAMAMOS AL PROCEDIMIENTO ALMACENANDOLO EN UNA VARIABLE
            String AgregarProyecto = "{ CALL SP_AGREGAR_PROYECTO(?,?,?,?,?) }";
            //LLAMAMOS A LA CONEXION NUEVAMENTE PARA ASI VALIDAR EL ARREGLO ALMACENADO
            CallableStatement cstmt = this.conexion.prepareCall(AgregarProyecto);
            //VARIABLES DE CAPTURA
            cstmt.setString(1, pro.getNombre_Proyecto());
            cstmt.setString(2, pro.getServicio());
            cstmt.setString(3, pro.getEstado());
            cstmt.setString(4, pro.getRutCliente());
            cstmt.setString(5, pro.getNombre_Equipo());

            //VALIDAMOS 
            if (cstmt.executeUpdate() > 0) {
                respuesta = true;
            } else {
                respuesta = false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //CERRAMOS LA CONEXION
            this.conexion.close();
        }
        return respuesta;
    }

    //AGREGAR INSUMO PROYECTO
    public boolean AgregarInsumo(Insumo in) throws SQLException {
        boolean respuesta = false;

        try {
            //OBTENEMOS LA CONEXION
            this.conexion = new Conexion().obtenerConexion();
            //LLAMAMOS AL PROCEDIMIENTO ALMACENANDOLO EN UNA VARIABLE
            String AgregarInsumo = "{ CALL SP_AGREGAR_INSUMO (?,?,?,?,?,?) }";
            //LLAMAMOS A LA CONEXION NUEVAMENTE PARA ASI VALIDAR EL ARREGLO ALMACENADO
            CallableStatement cstmt = this.conexion.prepareCall(AgregarInsumo);
            //VARIABLES DE CAPTURA
            cstmt.setInt(1, in.getCodInsumo());
            cstmt.setString(2, in.getDescripcion());
            cstmt.setString(3, in.getTienda());
            cstmt.setInt(4, in.getCantidad());
            cstmt.setInt(5, in.getPrecio());
            cstmt.setString(6, in.getNombre_Proyecto());

            //VALIDAMOS
            if (cstmt.executeUpdate() > 0) {
                respuesta = true;
            } else {
                respuesta = false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //CERRAMOS LA CONEXION
            this.conexion.close();
        }
        return respuesta;
    }

    //AGREGAR HISTORIAL PROYECTO
    public boolean AgregarHistorial(Historial hist) throws SQLException {
        boolean respuesta = false;

        try {
            //OBTENEMOS LA CONEXION
            this.conexion = new Conexion().obtenerConexion();
            //LLAMAMOS AL PROCEDIMIENTO ALMACENANDOLO EN UNA VARIABLE
            String AgregarHistorial = "{ CALL SP_AGREGAR_HISTORIAL(?,?,?,?,?) }";
            //LLAMAMOS A LA CONEXION NUEVAMENTE PARA ASI VALIDAR EL ARREGLO ALMACENADO
            CallableStatement cstmt = this.conexion.prepareCall(AgregarHistorial);
            //VARIABLES DE CAPTURA
            cstmt.setInt(1, hist.getFase());
            cstmt.setString(2, hist.getFecha());
            cstmt.setString(3, hist.getDescripcion());
            cstmt.setString(4, hist.getEstado());
            cstmt.setString(5, hist.getNombre_Proyecto());

            //VALIDAMOS
            if (cstmt.executeUpdate() > 0) {
                respuesta = true;
            } else {
                respuesta = false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //CERRAMOS LA CONEXION
            this.conexion.close();
        }
        return respuesta;
    }

    //AGREGAR SOLICITUD PROYECTO
    public boolean AgregarSolicitud(Solicitud soli) throws SQLException {
        boolean respuesta = false;

        try {
            //OBTENEMOS LA CONEXION
            this.conexion = new Conexion().obtenerConexion();
            //LLAMAMOS AL PROCEDIMIENTO ALMACENANDOLO EN UNA VARIABLE
            String AgregarSolicitud = "{ CALL SP_AGREGAR_SOLICITUD(?,?,?,?,?) }";
            //LLAMAMOS A LA CONEXION NUEVAMENTE PARA ASI VALIDAR EL ARREGLO ALMACENADO
            CallableStatement cstmt = this.conexion.prepareCall(AgregarSolicitud);
            //VARIABLES DE CAPTURA
            cstmt.setInt(1, soli.getCodSolicitud());
            cstmt.setString(2, soli.getHora());
            cstmt.setString(3, soli.getFecha());
            cstmt.setString(4, soli.getEstado());
            cstmt.setString(5, soli.getNombre_Proyecto());

            //VALIDAMOS
            if (cstmt.executeUpdate() > 0) {
                respuesta = true;
            } else {
                respuesta = false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //CERRAMOS LA CONEXION
            this.conexion.close();
        }
        return respuesta;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //LISTADOS
    //LISTADO DE TODO LOS PROYECTOS
    public List<Proyecto> listarProyecto() throws SQLException {
        List<Proyecto> listaProyecto = new ArrayList<Proyecto>();
        try {
            //OBTENEMOS LA CONEXION
            this.conexion = new Conexion().obtenerConexion();
            //LLAMAMOS AL PROCEDIMIENTO ALMACENANDOLO EN UNA VARIABLE
            String lista = "{ CALL SP_LISTAR_PROYECTO (?) }";
            //LLAMAMOS A LA CONEXION NUEVAMENTE PARA ASI VALIDAR EL ARREGLO ALMACENADO
            CallableStatement cstmt = this.conexion.prepareCall(lista);
            //LLAMAMOS A UN CURSOR PARA PODER GENERAR UN LISTADO
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);

            //EJECUTAMOS LA CONSULTA
            cstmt.execute();

            //RESCATAMOS LOS DATOS
            ResultSet rs = (ResultSet) cstmt.getObject(1);

            //MOSTRAMOS LOS DATOS EXISTETES
            while (rs.next()) {
                Proyecto pro = new Proyecto();
                pro.setNombre_Proyecto(rs.getString("Nombre_Proyecto"));
                pro.setServicio(rs.getString("Servicio"));
                pro.setEstado(rs.getString("Estado"));
                pro.setRutCliente(rs.getString("RutCliente"));
                pro.setNombre_Equipo(rs.getString("Nombre_Equipo"));

                //AGREGAMOS LOS DATOS RESCATADOS A LA LISTA
                listaProyecto.add(pro);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //CERRAMOS LA CONEXION
            this.conexion.close();
        }
        return listaProyecto;
    }

    //LISTADO DE TODAS LAS SOLICITUDES
    public List<Solicitud> ListarSolicitud() throws SQLException {
        List<Solicitud> listaSolicitud = new ArrayList<Solicitud>();
        try {
            //OBTENEMOS LA CONEXION
            this.conexion = new Conexion().obtenerConexion();
            //LLAMAMOS AL PROCEDIMIENTO ALMACENANDOLO EN UNA VARIABLE
            String lista = "{ CALL SP_LISTAR_SOLICITUD(?) }";
            //LLAMAMOS A LA CONEXION NUEVAMENTE PARA ASI VALIDAR EL ARREGLO ALMACENADO
            CallableStatement cstmt = this.conexion.prepareCall(lista);
            //LLAMAMOS A UN CURSOR PARA PODER GENERAR UN LISTADO
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            //EJECUTAMOS LA CONSULTA
            cstmt.execute();

            //RESCATAMOS LOS DATOS
            ResultSet rs = (ResultSet) cstmt.getObject(1);

            //MOSTRAMOS LOS DATOS EXISTETES
            while (rs.next()) {
                Solicitud soli = new Solicitud();
                soli.setCodSolicitud(rs.getInt("CodSolicitud"));
                soli.setHora(rs.getString("Hora"));
                soli.setFecha(rs.getString("Fecha"));
                soli.setEstado(rs.getString("Estado"));
                soli.setNombre_Proyecto(rs.getString("Nombre_Proyecto"));

                //AGREGAMOS LOS DATOS RESCATADOS A LA LISTA
                listaSolicitud.add(soli);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //CERRAMOS LA CONEXION
            this.conexion.close();
        }
        return listaSolicitud;
    }

    //LISTADO DE TODOS LOS HISTORIALES
    public List<Historial> ListarHistorial() throws SQLException {
        List<Historial> listaHistorial = new ArrayList<Historial>();
        try {
            //OBTENEMOS LA CONEXION
            this.conexion = new Conexion().obtenerConexion();
            //LLAMAMOS AL PROCEDIMIENTO ALMACENANDOLO EN UNA VARIABLE
            String lista = "{ CALL SP_LISTAR_HISTORIAL(?) }";
            //LLAMAMOS A LA CONEXION NUEVAMENTE PARA ASI VALIDAR EL ARREGLO ALMACENADO
            CallableStatement cstmt = this.conexion.prepareCall(lista);
            //LLAMAMOS A UN CURSOR PARA PODER GENERAR UN LISTADO
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            //EJECUTAMOS LA CONSULTA
            cstmt.execute();

            //RESCATAMOS LOS DATOS
            ResultSet rs = (ResultSet) cstmt.getObject(1);

            //MOSTRAMOS LOS DATOS EXISTETES
            while (rs.next()) {
                Historial hist = new Historial();
                hist.setFase(rs.getInt("Fase"));
                hist.setFecha(rs.getString("Fecha"));
                hist.setDescripcion(rs.getString("Descripcion"));
                hist.setEstado(rs.getString("Estado"));
                hist.setNombre_Proyecto(rs.getString("Nombre_Proyecto"));

                //AGREGAMOS LOS DATOS RESCATADOS A LA LISTA
                listaHistorial.add(hist);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //CERRAMOS LA CONEXION
            this.conexion.close();
        }
        return listaHistorial;
    }

    //LISTADO DE TODOS LOS INSUMOS
    public List<Insumo> ListaInsumo() throws SQLException {
        List<Insumo> listaInsumo = new ArrayList<Insumo>();
        try {
            //OBTENEMOS LA CONEXION
            this.conexion = new Conexion().obtenerConexion();
            //LLAMAMOS AL PROCEDIMIENTO ALMACENANDOLO EN UNA VARIABLE
            String lista = "{ CALL SP_LISTAR_INSUMO(?) }";
            //LLAMAMOS A LA CONEXION NUEVAMENTE PARA ASI VALIDAR EL ARREGLO ALMACENADO
            CallableStatement cstmt = this.conexion.prepareCall(lista);
            //LLAMAMOS A UN CURSOR PARA PODER GENERAR UN LISTADO
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            //EJECUTAMOS LA CONSULTA
            cstmt.execute();

            //RESCATAMOS LOS DATOS
            ResultSet rs = (ResultSet) cstmt.getObject(1);

            //MOSTRAMOS LOS DATOS EXISTETES
            while (rs.next()) {
                Insumo ins = new Insumo();
                ins.setCodInsumo(rs.getInt("CodInsumo"));
                ins.setDescripcion(rs.getString("Descripcion"));
                ins.setTienda(rs.getString("Tienda"));
                ins.setCantidad(rs.getInt("Cantidad"));
                ins.setPrecio(rs.getInt("Precio"));
                ins.setNombre_Proyecto(rs.getString("Nombre_Proyecto"));

                //AGREGAMOS LOS DATOS RESCATADOS A LA LISTA
                listaInsumo.add(ins);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //CERRAMOS LA CONEXION
            this.conexion.close();
        }
        return listaInsumo;
    }

    //LISTADO DE TODOS LOS EQUIPOS A TERRENO
    public List<Equipo> ListaEquipo() throws SQLException {
        List<Equipo> listaEquipo = new ArrayList<Equipo>();
        try {
            //OBTENEMOS LA CONEXION
            this.conexion = new Conexion().obtenerConexion();
            //LLAMAMOS AL PROCEDIMIENTO ALMACENANDOLO EN UNA VARIABLE
            String lista = "{ CALL SP_LISTAR_EQUIPO(?) }";
            //LLAMAMOS A LA CONEXION NUEVAMENTE PARA ASI VALIDAR EL ARREGLO ALMACENADO
            CallableStatement cstmt = this.conexion.prepareCall(lista);
            //LLAMAMOS A UN CURSOR PARA PODER GENERAR UN LISTADO
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            //EJECUTAMOS LA CONSULTA
            cstmt.execute();

            //RESCATAMOS LOS DATOS
            ResultSet rs = (ResultSet) cstmt.getObject(1);

            //MOSTRAMOS LOS DATOS EXISTETES
            while (rs.next()) {
                Equipo equi = new Equipo();
                equi.setNombre_Equipo(rs.getString("Nombre_Equipo"));

                //AGREGAMOS LOS DATOS RESCATADOS A LA LISTA
                listaEquipo.add(equi);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //CERRAMOS LA CONEXION
            this.conexion.close();
        }
        return listaEquipo;
    }

    //LISTADO DE TODOS LOS TRABAJADORES
    public List<Trabajador> listarTrabajador() throws SQLException {
        List<Trabajador> listaTrabajador = new ArrayList<Trabajador>();
        try {
            //OBTENEMOS LA CONEXION
            this.conexion = new Conexion().obtenerConexion();
            //LLAMAMOS AL PROCEDIMIENTO ALMACENANDOLO EN UNA VARIABLE
            String lista = "{ CALL SP_LISTAR_TRABAJADORES(?) }";
            //LLAMAMOS A LA CONEXION NUEVAMENTE PARA ASI VALIDAR EL ARREGLO ALMACENADO
            CallableStatement cstmt = this.conexion.prepareCall(lista);
            //LLAMAMOS A UN CURSOR PARA PODER GENERAR UN LISTADO
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            //EJECUTAMOS LA CONSULTA
            cstmt.execute();

            //RESCATAMOS LOS DATOS
            ResultSet rs = (ResultSet) cstmt.getObject(1);

            //MOSTRAMOS LOS DATOS EXISTETES
            while (rs.next()) {
                Trabajador tra = new Trabajador();
                tra.setRut_Trabajador(rs.getString("Rut_Trabajador"));
                tra.setNombre_Trabajador(rs.getString("Nombre_Trabajador"));
                tra.setCargo(rs.getString("Cargo"));
                tra.setNombre_Equipo(rs.getString("Nombre_Equipo"));

                //AGREGAMOS LOS DATOS RESCATADOS A LA LISTA
                listaTrabajador.add(tra);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //CERRAMOS LA CONEXION
            this.conexion.close();
        }
        return listaTrabajador;
    }

    //LISTADO BANCO
    public List<Banco> listarBanco() throws SQLException {
        List<Banco> listadoBanco = new ArrayList<Banco>();
        try {
            this.conexion = new Conexion().obtenerConexion();
            String lista = "{CALL SP_LISTAR_BANCO (?) }";
            CallableStatement cstmt = this.conexion.prepareCall(lista);
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();

            ResultSet rs = (ResultSet) cstmt.getObject(1);

            while (rs.next()) {
                Banco banco = new Banco();
                banco.setNombre_Banco(rs.getString("Nombre_Banco"));

                listadoBanco.add(banco);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            this.conexion.close();
        }
        return listadoBanco;
    }

    //LISTADO TIPO CUENTA
    public List<Tipo_Cuenta> listarTipoCuenta() throws SQLException {
        List<Tipo_Cuenta> listadoTipo = new ArrayList<Tipo_Cuenta>();
        try {
            this.conexion = new Conexion().obtenerConexion();
            String lista = "{ CALL SP_LISTAR_TIPO (?) }";
            CallableStatement cstmt = this.conexion.prepareCall(lista);
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();

            ResultSet rs = (ResultSet) cstmt.getObject(1);

            while (rs.next()) {
                Tipo_Cuenta tipo = new Tipo_Cuenta();
                tipo.setTipo_Banco(rs.getString("Tipo_Cuenta"));

                listadoTipo.add(tipo);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            this.conexion.close();
        }
        return listadoTipo;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //BUSQUEDAS EN EL PROYECTOS
    //BUSQUEDAS DE PROYECTOS DE UN CLIENTE
    public List<Proyecto> buscarProyecto(String rutcliente) throws SQLException {
        List<Proyecto> proyecto = new ArrayList<Proyecto>();
        try {
            //OBTENEMOS LA CONEXION
            this.conexion = new Conexion().obtenerConexion();
            //LLAMAMOS AL PROCEDIMIENTO ALMACENANDOLO EN UNA VARIABLE
            String buscarProyecto = "SELECT * FROM PROYECTO WHERE RUTCLIENTE='" + rutcliente + "'";
            //LLAMAMOS A LA CONEXION NUEVAMENTE PARA ASI VALIDAR LA CONSULTA
            CallableStatement cstmt = this.conexion.prepareCall(buscarProyecto);
            //EJECUTAMOS LA CONSULTA
            cstmt.execute();

            //RESCATAMOS LOS DATOS
            ResultSet rs = cstmt.getResultSet();

            //MOSTRAMOS LOS DATOS EXISTETES
            while (rs.next()) {
                Proyecto pro = new Proyecto();
                pro.setNombre_Proyecto(rs.getString("Nombre_Proyecto"));
                pro.setServicio(rs.getString("Servicio"));
                pro.setEstado(rs.getString("Estado"));
                pro.setRutCliente(rs.getString("RutCliente"));
                pro.setNombre_Equipo(rs.getString("Nombre_Equipo"));

                //AGREGAMOS LOS DATOS RESCATADOS A LA LISTA
                proyecto.add(pro);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //CERRAMOS LA CONEXION
            this.conexion.close();
        }
        return proyecto;
    }

    //BUSQUEDA DE LOS HISTORIALES REALIZADOS A UN PROYECTO
    public List<Historial> buscarHistorial(String nombre) throws SQLException {
        List<Historial> historial = new ArrayList<Historial>();
        try {
            //OBTENEMOS LA CONEXION
            this.conexion = new Conexion().obtenerConexion();
            //LLAMAMOS AL PROCEDIMIENTO ALMACENANDOLO EN UNA VARIABLE
            String buscarHistorial = "SELECT * FROM HISTORIAL WHERE NOMBRE_PROYECTO='" + nombre + "'";
            //LLAMAMOS A LA CONEXION NUEVAMENTE PARA ASI VALIDAR LA CONSULTA
            CallableStatement cstmt = this.conexion.prepareCall(buscarHistorial);
            //EJECUTAMOS LA CONSULTA
            cstmt.execute();

            //RESCATAMOS LOS DATOS
            ResultSet rs = cstmt.getResultSet();

            //MOSTRAMOS LOS DATOS EXISTETES
            while (rs.next()) {
                Historial his = new Historial();
                his.setFase(rs.getInt("Fase"));
                his.setFecha(rs.getString("Fecha"));
                his.setDescripcion(rs.getString("Descripcion"));
                his.setNombre_Proyecto(rs.getString("Nombre_Proyecto"));
                his.setEstado(rs.getString("Estado"));

                //AGREGAMOS LOS DATOS RESCATADOS A LA LISTA
                historial.add(his);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //CERRAMOS LA CONEXION
            this.conexion.close();
        }
        return historial;
    }

    //BUSQUEDA DE TODOS LOS INSUMOS DE UN PROYECTO
    public List<Insumo> buscarInsumo(String nombre) throws SQLException {
        List<Insumo> insumo = new ArrayList<Insumo>();
        try {
            //OBTENEMOS LA CONEXION
            this.conexion = new Conexion().obtenerConexion();
            //LLAMAMOS AL PROCEDIMIENTO ALMACENANDOLO EN UNA VARIABLE
            String buscarInsumo = "SELECT * FROM INSUMO WHERE NOMBRE_PROYECTO = '" + nombre + "'";
            //LLAMAMOS A LA CONEXION NUEVAMENTE PARA ASI VALIDAR LA CONSULTA
            CallableStatement cstmt = this.conexion.prepareCall(buscarInsumo);
            //EJECUTAMOS LA CONSULTA
            cstmt.execute();

            //RESCATAMOS LOS DATOS
            ResultSet rs = cstmt.getResultSet();

            //MOSTRAMOS LOS DATOS EXISTETES
            while (rs.next()) {
                Insumo insu = new Insumo();
                insu.setCodInsumo(rs.getInt("CodInsumo"));
                insu.setDescripcion(rs.getString("Descripcion"));
                insu.setTienda(rs.getString("Tienda"));
                insu.setCantidad(rs.getInt("Cantidad"));
                insu.setPrecio(rs.getInt("Precio"));

                //AGREGAMOS LOS DATOS RESCATADOS A LA LISTA
                insumo.add(insu);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //CERRAMOS LA CONEXION
            this.conexion.close();
        }
        return insumo;
    }

    //BUSQUEDA DE TRABAJADORES QUE SON PARTE DE UN PROYECTO
    public List<Trabajador> buscarTrabajador(String nombre) throws SQLException {
        List<Trabajador> trabajador = new ArrayList<Trabajador>();
        try {
            //OBTENEMOS LA CONEXION
            this.conexion = new Conexion().obtenerConexion();
            //LLAMAMOS AL PROCEDIMIENTO ALMACENANDOLO EN UNA VARIABLE
            String buscarTrabajador = "SELECT * FROM TRABAJADOR WHERE NOMBRE_EQUIPO='" + nombre + "'";
            //LLAMAMOS A LA CONEXION NUEVAMENTE PARA ASI VALIDAR LA CONSULTA
            CallableStatement cstmt = this.conexion.prepareCall(buscarTrabajador);
            //EJECUTAMOS LA CONSULTA
            cstmt.execute();

            //RESCATAMOS LOS DATOS
            ResultSet rs = cstmt.getResultSet();

            //MOSTRAMOS LOS DATOS EXISTETES
            while (rs.next()) {
                Trabajador tra = new Trabajador();
                tra.setRut_Trabajador(rs.getString("Rut_Trabajador"));
                tra.setNombre_Trabajador(rs.getString("Nombre_Trabajador"));
                tra.setCargo(rs.getString("Cargo"));
                tra.setNombre_Equipo(rs.getString("Nombre_Equipo"));

                //AGREGAMOS LOS DATOS RESCATADOS A LA LISTA
                trabajador.add(tra);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //CERRAMOS LA CONEXION
            this.conexion.close();
        }
        return trabajador;
    }

    //BUSQUEDA DE TODAS LAS SOLICITUDES DE UN PROYECTO (HORAS A TERRENO)
    public Solicitud buscarSolicitud(String nombre) throws SQLException {
        Solicitud solicitud = new Solicitud(0, "false", "false", "false", "false");

        try {
            //OBTENEMOS LA CONEXION
            this.conexion = new Conexion().obtenerConexion();
            //LLAMAMOS AL PROCEDIMIENTO ALMACENANDOLO EN UNA VARIABLE
            String buscarSolicitud = "SELECT * FROM SOLICITUD WHERE NOMBRE_PROYECTO='" + nombre + "'";
            //LLAMAMOS A LA CONEXION NUEVAMENTE PARA ASI VALIDAR LA CONSULTA
            CallableStatement cstmt = this.conexion.prepareCall(buscarSolicitud);
            //EJECUTAMOS LA CONSULTA
            cstmt.execute();

            //RESCATAMOS LOS DATOS
            ResultSet rs = cstmt.getResultSet();

            //MOSTRAMOS LOS DATOS EXISTETES
            while (rs.next()) {
                solicitud.setCodSolicitud(rs.getInt("CodSolicitud"));
                solicitud.setHora(rs.getString("Hora"));
                solicitud.setFecha(rs.getString("Fecha"));
                solicitud.setEstado(rs.getString("Estado"));
                solicitud.setNombre_Proyecto(rs.getString("Nombre_Proyecto"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //CERRAMOS LA CONEXION
            this.conexion.close();
        }
        return solicitud;
    }

    //BUSQUEDA DE UN PROYECTO (RETORNA LOS DETALLES DE ESE PROYECTO)
    public Proyecto estadoProyecto(String nombre) throws SQLException {
        Proyecto proyecto = new Proyecto("false", "false", "false", "false", "false");
        try {
            //OBTENEMOS LA CONEXION
            this.conexion = new Conexion().obtenerConexion();
            //LLAMAMOS AL PROCEDIMIENTO ALMACENANDOLO EN UNA VARIABLE
            String estadoProyecto = "SELECT * FROM PROYECTO WHERE NOMBRE_PROYECTO ='" + nombre + "'";
            //LLAMAMOS A LA CONEXION NUEVAMENTE PARA ASI VALIDAR LA CONSULTA
            CallableStatement cstmt = this.conexion.prepareCall(estadoProyecto);
            //EJECUTAMOS LA CONSULTA
            cstmt.execute();

            //RESCATAMOS LOS DATOS
            ResultSet rs = cstmt.getResultSet();

            //MOSTRAMOS LOS DATOS EXISTETES
            while (rs.next()) {
                proyecto.setNombre_Proyecto(rs.getString("Nombre_Proyecto"));
                proyecto.setServicio(rs.getString("Servicio"));
                proyecto.setEstado(rs.getString("Estado"));
                proyecto.setRutCliente(rs.getString("RutCliente"));
                proyecto.setNombre_Equipo(rs.getString("Nombre_Equipo"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //CERRAMOS LA CONEXION
            this.conexion.close();
        }
        return proyecto;
    }

    //RESCATAR SOLICITUD SEGUN SU FECHA
    public Solicitud filtrarFecha(String fecha) throws SQLException {
        Solicitud solicitud = new Solicitud(0, "false", "false", "false", "false");
        try {
            //OBTENEMOS LA CONEXION
            this.conexion = new Conexion().obtenerConexion();
            //LLAMAMOS AL PROCEDIMIENTO ALMACENANDOLO EN UNA VARIABLE
            String filtrarFecha = "SELECT * FROM SOLICITUD WHERE FECHA='" + fecha + "'";
            //LLAMAMOS A LA CONEXION NUEVAMENTE PARA ASI VALIDAR LA CONSULTA
            CallableStatement cstmt = this.conexion.prepareCall(filtrarFecha);
            //EJECUTAMOS LA CONSULTA
            cstmt.execute();

            //RESCATAMOS LOS DATOS
            ResultSet rs = cstmt.getResultSet();

            //MOSTRAMOS LOS DATOS EXISTETES
            while (rs.next()) {
                solicitud.setCodSolicitud(rs.getInt("CodSolicitud"));
                solicitud.setHora(rs.getString("Hora"));
                solicitud.setFecha(rs.getString("Fecha"));
                solicitud.setEstado(rs.getString("Estado"));
                solicitud.setNombre_Proyecto(rs.getString("Nombre_Proyecto"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //CERRAMOS LA CONEXION
            this.conexion.close();
        }
        return solicitud;
    }

    //RESCATAR FECHAS
    public List<Solicitud> fechaSolicitud(String nombre) throws SQLException {
        List<Solicitud> solicitud = new ArrayList<Solicitud>();
        try {
            //OBTENEMOS LA CONEXION
            this.conexion = new Conexion().obtenerConexion();
            //LLAMAMOS AL PROCEDIMIENTO ALMACENANDOLO EN UNA VARIABLE
            String fechaSolicitud = "SELECT * FROM SOLICITUD WHERE NOMBRE_PROYECTO='" + nombre + "'";
            //LLAMAMOS A LA CONEXION NUEVAMENTE PARA ASI VALIDAR LA CONSULTA
            CallableStatement cstmt = this.conexion.prepareCall(fechaSolicitud);
            //EJECUTAMOS LA CONSULTA
            cstmt.execute();

            //RESCATAMOS LOS DATOS
            ResultSet rs = cstmt.getResultSet();

            //MOSTRAMOS LOS DATOS EXISTETES
            while (rs.next()) {
                Solicitud soli = new Solicitud();
                soli.setFecha(rs.getString("Fecha"));
                solicitud.add(soli);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //CERRAMOS LA CONEXION
            this.conexion.close();
        }
        return solicitud;
    }

    //BUSQUEDA DE EQUIPO A TERRENO DE UN PROYECTO
    public Proyecto buscarEquipo(String nombre) throws SQLException {
        Proyecto proyecto = new Proyecto("false", "false", "false", "false", "false");
        try {
            //OBTENEMOS LA CONEXION
            this.conexion = new Conexion().obtenerConexion();
            //LLAMAMOS AL PROCEDIMIENTO ALMACENANDOLO EN UNA VARIABLE
            String buscarEquipo = "SELECT * FROM PROYECTO WHERE NOMBRE_PROYECTO='" + nombre + "'";
            //LLAMAMOS A LA CONEXION NUEVAMENTE PARA ASI VALIDAR LA CONSULTA
            CallableStatement cstmt = this.conexion.prepareCall(buscarEquipo);
            //EJECUTAMOS LA CONSULTA
            cstmt.execute();

            //RESCATAMOS LOS DATOS
            ResultSet rs = cstmt.getResultSet();

            //MOSTRAMOS LOS DATOS EXISTETES
            while (rs.next()) {
                proyecto.setNombre_Proyecto(rs.getString("Nombre_Proyecto"));
                proyecto.setNombre_Equipo(rs.getString("Nombre_Equipo"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //CERRAMOS LA CONEXION
            this.conexion.close();
        }
        return proyecto;
    }

    public Cliente buscarCliente(String rut) throws SQLException {
        Cliente cliente = new Cliente("false", "false", "false", 0, "false");
        try {
            this.conexion = new Conexion().obtenerConexion();
            String buscarCliente = "SELECT * FROM CLIENTE WHERE RUTCLIENTE ='" + rut + "'";
            CallableStatement cstmt = this.conexion.prepareCall(buscarCliente);
            cstmt.execute();

            ResultSet rs = cstmt.getResultSet();

            while (rs.next()) {
                cliente.setRutCliente(rs.getString("RutCliente"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setApellido(rs.getString("Apellido"));
                cliente.setTelefono(rs.getInt("Telefono"));
                cliente.setCorreo(rs.getString("Correo"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            this.conexion.close();
        }
        return cliente;
    }

    public Carrito validarCompra(String nombre) throws SQLException {
        Carrito carro = new Carrito(0, "false", "false", "false", "false", 0, 0, 0);
        try {
            this.conexion = new Conexion().obtenerConexion();
            String validarCompra = "SELECT * FROM CARRITO WHERE NOMBRE_PROYECTO = '" + nombre + "'";
            CallableStatement cstmt = this.conexion.prepareCall(validarCompra);
            cstmt.execute();

            ResultSet rs = cstmt.getResultSet();

            while (rs.next()) {
                carro.setCodCarrito(rs.getInt("CodCarrito"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            this.conexion.close();
        }
        return carro;
    }

    public List<Proyecto> detalleProyecto(String nombre) throws SQLException {
        List<Proyecto> proyecto = new ArrayList<Proyecto>();

        try {
            this.conexion = new Conexion().obtenerConexion();
            String detalleProyecto = "SELECT * FROM PROYECTO WHERE NOMBRE_PROYECTO='" + nombre + "'";
            CallableStatement cstmt = this.conexion.prepareCall(detalleProyecto);
            cstmt.execute();

            ResultSet rs = cstmt.getResultSet();

            while (rs.next()) {
                Proyecto pro = new Proyecto();
                pro.setServicio(rs.getString("Servicio"));
                pro.setNombre_Equipo(rs.getString("Nombre_Equipo"));
                pro.setEstado(rs.getString("Estado"));

                proyecto.add(pro);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            this.conexion.close();
        }
        return proyecto;
    }

    public List<Solicitud> fechaProyecto(String fecha) throws SQLException {
        List<Solicitud> solicitud = new ArrayList<Solicitud>();
        try {
            this.conexion = new Conexion().obtenerConexion();
            String fechaProyecto = "SELECT * FROM SOLICITUD WHERE FECHA='" + fecha + "'";
            CallableStatement cstmt = this.conexion.prepareCall(fechaProyecto);
            cstmt.execute();

            ResultSet rs = cstmt.getResultSet();

            while (rs.next()) {
                Solicitud soli = new Solicitud();
                soli.setCodSolicitud(rs.getInt("CodSolicitud"));
                soli.setHora(rs.getString("Hora"));
                soli.setFecha(rs.getString("Fecha"));
                soli.setEstado(rs.getString("Estado"));

                solicitud.add(soli);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            this.conexion.close();
        }
        return solicitud;
    }

    public List<Solicitud> detalleSolicitud(String nombre) throws SQLException {
        List<Solicitud> solicitud = new ArrayList<Solicitud>();
        try {
            this.conexion = new Conexion().obtenerConexion();
            String detalleSolicitud = "SELECT * FROM SOLICITUD WHERE NOMBRE_PROYECTO='" + nombre + "'";
            CallableStatement cstmt = this.conexion.prepareCall(detalleSolicitud);
            cstmt.execute();

            ResultSet rs = cstmt.getResultSet();

            while (rs.next()) {
                Solicitud soli = new Solicitud();
                soli.setCodSolicitud(rs.getInt("CodSolicitud"));
                soli.setNombre_Proyecto(rs.getString("Nombre_Proyecto"));
                soli.setHora(rs.getString("Hora"));
                soli.setFecha(rs.getString("Fecha"));
                soli.setEstado(rs.getString("Estado"));

                solicitud.add(soli);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            this.conexion.close();
        }
        return solicitud;
    }

    public List<Historial> faseHistorial(String nombre) throws SQLException {
        List<Historial> historial = new ArrayList<Historial>();
        try {
            this.conexion = new Conexion().obtenerConexion();
            String faseHistorial = "SELECT * FROM HISTORIAL WHERE NOMBRE_PROYECTO='" + nombre + "'";
            CallableStatement cstmt = this.conexion.prepareCall(faseHistorial);
            cstmt.execute();

            ResultSet rs = cstmt.getResultSet();

            while (rs.next()) {
                Historial hist = new Historial();
                hist.setFase(rs.getInt("Fase"));

                historial.add(hist);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            this.conexion.close();
        }
        return historial;
    }

    public List<Historial> detalleHistorial(int fase) throws SQLException {
        List<Historial> historial = new ArrayList<Historial>();
        try {
            this.conexion = new Conexion().obtenerConexion();
            String detalleHistorial = "SELECT * FROM HISTORIAL WHERE FASE='" + fase + "'";
            CallableStatement cstmt = this.conexion.prepareCall(detalleHistorial);
            cstmt.execute();

            ResultSet rs = cstmt.getResultSet();

            while (rs.next()) {
                Historial hist = new Historial();
                hist.setFase(rs.getInt("Fase"));
                hist.setFecha(rs.getString("Fecha"));
                hist.setDescripcion(rs.getString(("Descripcion")));
                hist.setEstado(rs.getString("Estado"));
                hist.setNombre_Proyecto(rs.getString("Nombre_Proyecto"));

                historial.add(hist);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            this.conexion.close();
        }
        return historial;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //MODIFICAR
    //CAMBIAR EL ESTADO DE UN PROYECTO GENERADO POR EL CLIENTE
    public boolean cambiarEstadoPro(Proyecto pro) throws SQLException {
        boolean respuesta = false;
        try {
            //OBTENEMOS LA CONEXION
            this.conexion = new Conexion().obtenerConexion();
            //LLAMAMOS AL PROCEDIMIENTO ALMACENANDOLO EN UNA VARIABLE
            String cambiarEstado = "{ CALL SP_CAMBIAR_ESTADO_PROYECTO (?,?,?,?,?)}";
            //LLAMAMOS A LA CONEXION NUEVAMENTE PARA ASI VALIDAR EL ARREGLO ALMACENADO
            CallableStatement cstmt = this.conexion.prepareCall(cambiarEstado);
            //VARIABLES DE CAPTURA
            cstmt.setString(1, pro.getNombre_Proyecto());
            cstmt.setString(2, pro.getServicio());
            cstmt.setString(3, pro.getEstado());
            cstmt.setString(4, pro.getRutCliente());
            cstmt.setString(5, pro.getNombre_Equipo());

            //VALIDAMOS
            if (cstmt.executeUpdate() == 1) {
                respuesta = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //CERRAMOS LA CONEXION
            this.conexion.close();
        }
        return respuesta;
    }

    //CAMBIAR EL ESTADO DE SOLICITUD (HORA AGENDAD) DE UN PROYECTO SOLICITADO POR UN CLIENTE
    public boolean cambiarEstadoSoli(Solicitud soli) throws SQLException {
        boolean respuesta = false;
        try {
            //OBTENEMOS LA CONEXION
            this.conexion = new Conexion().obtenerConexion();
            //LLAMAMOS AL PROCEDIMIENTO ALMACENANDOLO EN UNA VARIABLE
            String cambiarEstado = "{ CALL SP_CAMBIAR_ESTADO_SOLICITUD (?,?,?,?,?) }";
            //LLAMAMOS A LA CONEXION NUEVAMENTE PARA ASI VALIDAR EL ARREGLO ALMACENADO
            CallableStatement cstmt = this.conexion.prepareCall(cambiarEstado);
            //VARIABLES DE CAPTURA
            cstmt.setInt(1, soli.getCodSolicitud());
            cstmt.setString(2, soli.getHora());
            cstmt.setString(3, soli.getFecha());
            cstmt.setString(4, soli.getEstado());
            cstmt.setString(5, soli.getNombre_Proyecto());

            //VALIDAMOS
            if (cstmt.executeUpdate() == 1) {
                respuesta = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //CERRAMOS LA CONEXION
            this.conexion.close();
        }
        return respuesta;
    }

    public boolean cambiarEstadoHist(Historial hist) throws SQLException {
        boolean respuesta = false;
        try {
            this.conexion = new Conexion().obtenerConexion();
            String cambiarEstado = "{ CALL SP_CAMBIAR_ESTADO_HISTORIAL(?,?,?,?) }";
            CallableStatement cstmt = this.conexion.prepareCall(cambiarEstado);

            cstmt.setString(1, hist.getFecha());
            cstmt.setString(2, hist.getDescripcion());
            cstmt.setString(3, hist.getEstado());
            cstmt.setString(4, hist.getNombre_Proyecto());

            if (cstmt.executeUpdate() == 1) {
                respuesta = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            this.conexion.close();
        }
        return respuesta;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //VALIDACIONES
    //LOGIN DE UN USUARIO
    public boolean Login(String rut, String contrasena) throws SQLException {
        boolean respuesta = false;
        try {
            //OBTENEMOS LA CONEXION
            this.conexion = new Conexion().obtenerConexion();
            //LLAMAMOS AL PROCEDIMIENTO ALMACENANDOLO EN UNA VARIABLE
            String login = "SELECT * FROM USUARIO WHERE RUTCLIENTE = ? AND CONTRASENA = ?";
            //LLAMAMOS A LA CONEXION NUEVAMENTE PARA ASI VALIDAR LA CONSULTA
            CallableStatement cstmt = this.conexion.prepareCall(login);
            cstmt.setString(1, rut);
            cstmt.setString(2, contrasena);
            //EJECUTAMOS LA CONSULTA
            cstmt.execute();

            //RESCATAMOS LOS DATOS
            ResultSet rs = cstmt.getResultSet();

            //VALIDAMOS USUARIO
            while (rs.next()) {
                respuesta = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //CERRAMOS LA CONEXION
            this.conexion.close();
        }
        return respuesta;
    }

    public boolean LoginAdmin(String usuario, String contrasena) throws SQLException {
        boolean respuesta = false;
        try {
            this.conexion = new Conexion().obtenerConexion();
            String loginAdmin = "SELECT * FROM ADMINISTRADOR WHERE USUARIO='" + usuario + "' AND CONTRASENA ='" + contrasena + "'";
            CallableStatement cstmt = this.conexion.prepareCall(loginAdmin);

            cstmt.execute();

            ResultSet rs = cstmt.getResultSet();

            while (rs.next()) {
                respuesta = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            this.conexion.close();
        }
        return respuesta;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //FILTROS
    //FILTRAR TRABAJADOR
    public boolean filtrarTrabajadores(String equipo) throws SQLException {
        boolean respuesta = false;
        try {
            //OBTENEMOS LA CONEXION
            this.conexion = new Conexion().obtenerConexion();
            //LLAMAMOS AL PROCEDIMIENTO ALMACENANDOLO EN UNA VARIABLE
            String buscarTrabajadores = "SELECT * FROM TRABAJADOR WHERE NOMBRE_EQUIPO='" + equipo + "'";
            //LLAMAMOS A LA CONEXION NUEVAMENTE PARA ASI VALIDAR LA CONSULTA
            CallableStatement cstmt = this.conexion.prepareCall(buscarTrabajadores);

            //RESCATAMOS LOS DATOS
            ResultSet rs = cstmt.getResultSet();

            //VALIDAMOS
            if (cstmt.executeUpdate() == 1) {
                respuesta = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //CERRAMOS LA CONEXION
            this.conexion.close();
        }
        return respuesta;
    }

    //FILTRAR PROYECTO (VALIDAMOS SI EXISTE EL PROYECTO)
    public boolean filtrarProyecto(String rutcliente) throws SQLException {
        boolean respuesta = false;
        try {
            //OBTENEMOS LA CONEXION
            this.conexion = new Conexion().obtenerConexion();
            //LLAMAMOS AL PROCEDIMIENTO ALMACENANDOLO EN UNA VARIABLE
            String buscarProyecto = "SELECT * FROM PROYECTO WHERE RUTCLIENTE='" + rutcliente + "'";
            //LLAMAMOS A LA CONEXION NUEVAMENTE PARA ASI VALIDAR LA CONSULTA
            CallableStatement cstmt = this.conexion.prepareCall(buscarProyecto);

            //RESCATAMOS LOS DATOS
            ResultSet rs = cstmt.getResultSet();

            //VALIDAMOS
            if (cstmt.executeUpdate() == 1) {
                respuesta = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //CERRAMOS LA CONEXION
            this.conexion.close();
        }
        return respuesta;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //OPERACIONES
    public List<Insumo> totalPagar(String nombre) throws SQLException {
        List<Insumo> insumo = null;
        try {
            this.conexion = new Conexion().obtenerConexion();
            String totalPagar = "SELECT * FROM INSUMO WHERE NOMBRE_PROYECTO='" + nombre + "'";
            CallableStatement cstmt = this.conexion.prepareCall(totalPagar);
            cstmt.execute();

            ResultSet rs = cstmt.getResultSet();

            while (rs.next()) {
                Insumo insu = new Insumo();
                insu.setPrecio(rs.getInt("Precio"));
                insu.setCantidad(rs.getInt("Cantidad"));

                insumo.add(insu);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            this.conexion.close();
        }
        return insumo;
    }

}
