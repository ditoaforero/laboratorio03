package com.losalpes.beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.losalpes.entities.RegistroVenta;
import com.losalpes.servicios.IServicioVentasMockLocal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import org.primefaces.model.TreeNode;

/**
 *
 * @author dito
 */
@Named(value = "reporteBean")
@Dependent
public class ReporteBean {

    @EJB
    private IServicioVentasMockLocal ventas;

    private List<RegistroVenta> ventasUltimoMes;

    /**
     * Creates a new instance of ReporteDeVentas
     */
    public ReporteBean() {
    }

    /**
     * Devuelve todos los muebles del sistema
     *
     * @return muebles Lista con todos los muebles del sistema
     */
    public List<RegistroVenta> getVentas() {
        System.out.println("Se obtienen las ventas");
        System.out.println(ventas.darVentas());

        return ventas.darVentas();
    }

    public List<RegistroVenta> getUltimo() {
        ventasUltimoMes = new ArrayList();
        Date fechaMayor = obtenerFechaMayor();
        System.out.println("Fecha mayor:"+fechaMayor);
        Date fechaIni = obtenerInicioMes(fechaMayor);
        System.out.println("Fehca ini"+fechaIni);
        Date fechaFin = obtenerFinMes(fechaMayor);
        System.out.println("Fecha fin:"+fechaFin);

        for (int i = 0; i < ventas.darVentas().size(); i++) {
            if(ventas.darVentas().get(i).getFechaVenta().after(fechaIni) && ventas.darVentas().get(i).getFechaVenta().before(fechaFin)){
                ventasUltimoMes.add(ventas.darVentas().get(i));
            }
        }
        return ventasUltimoMes;
    }

    private Date obtenerFechaMayor() {
        Date fechaMayor = new Date();
        for (int i = 0; i < ventas.darVentas().size(); i++) {
            if (i == 0) {
                fechaMayor = ventas.darVentas().get(i).getFechaVenta();
            } else if (fechaMayor.before(ventas.darVentas().get(i).getFechaVenta())) {
                fechaMayor = ventas.darVentas().get(i).getFechaVenta();
            }
        }
        return fechaMayor;
    }

    private Date obtenerInicioMes(Date fecha) {
        Calendar fechaAuxiliar = Calendar.getInstance();
        Calendar fechaRetorno = Calendar.getInstance();

        fechaAuxiliar.setTime(fecha);
        fechaRetorno.set(fechaAuxiliar.get(Calendar.YEAR), fechaAuxiliar.get(Calendar.MONTH), 1);

        return fechaRetorno.getTime();

    }

    private Date obtenerFinMes(Date fecha) {

        Calendar fechaAuxiliar = Calendar.getInstance();
        Calendar fechaRetorno = Calendar.getInstance();
        fechaAuxiliar.setTime(fecha);
        fechaRetorno.set(fechaAuxiliar.get(Calendar.YEAR), fechaAuxiliar.get(Calendar.MONTH), fechaAuxiliar.getActualMaximum(Calendar.DAY_OF_MONTH));
        
        return fechaRetorno.getTime();

    }

}
