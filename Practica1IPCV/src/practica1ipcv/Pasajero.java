/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1ipcv;

import java.util.Random;

/**
 *
 * @author Jhoans
 */
public class Pasajero {

    Random rnd = new Random();

    public Integer id;
    public Integer maletas;
    public Integer documentos;
    public Integer turnos;

    //Pasajero(int,((int) (rnd.nextDouble() * 4 + 1)),((int) (rnd.nextDouble() * 10 + 1)),((int) (rnd.nextDouble() * 3 + 1))  
    public Pasajero() {
    }

    public Pasajero(Integer id, Integer maletas, Integer documentos, Integer turnos) {
        this.id = id;
        this.maletas = maletas;
        this.documentos = documentos;
        this.turnos = turnos;
    }

    public Pasajero copiarPasajero(Pasajero pas) {

        Pasajero p = new Pasajero();

        p.id = pas.id;
        p.maletas = pas.maletas;
        p.documentos = pas.documentos;
        p.turnos = pas.turnos;

        return p;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaletas() {
        return maletas;
    }

    public void setMaletas(Integer maletas) {
        this.maletas = maletas;
    }

    public Integer getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Integer documentos) {
        this.documentos = documentos;
    }

    public Integer getTurnos() {
        return turnos;
    }

    public void setTurnos(Integer turnos) {
        this.turnos = turnos;
    }

    @Override
    public String toString() {
        return "Pasajero{" + "id=" + id + ", maletas=" + maletas + ", documentos=" + documentos + ", turnos=" + turnos + '}';
    }

}
