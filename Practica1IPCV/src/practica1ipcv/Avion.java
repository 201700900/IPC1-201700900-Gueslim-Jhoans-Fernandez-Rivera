/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1ipcv;

/**
 *
 * @author Jhoans
 */
public class Avion {

    String tipo = " ";
    Integer no = 0;
    Integer pasajeroXAvion = 1;
    Integer desabordaje = 1;
    Integer Mantenimiento = 1;

    public Avion() {
    }

    public Avion(String tipo, Integer no, Integer pasajeroXAvion, Integer desabordaje, Integer Mantenimiento) {
        this.tipo = tipo;
        this.no = no;
        this.pasajeroXAvion = pasajeroXAvion;
        this.desabordaje = desabordaje;
        this.Mantenimiento = Mantenimiento;
    }

    Avion copiarAvion(Avion av) {
        Avion air = new Avion();

        air.Mantenimiento = av.Mantenimiento;
        air.desabordaje = av.desabordaje;
        air.pasajeroXAvion = av.pasajeroXAvion;
        air.tipo = av.tipo;
        air.no = av.no;

        return air;
    }

}
