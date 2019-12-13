/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1ipcv;

import java.util.Random;
import javax.swing.JTextArea;

/**
 *
 * @author Jhoans
 */
public class Escritorio {

    Random rnd = new Random();

    Integer pasAbajo = 0;

    Avion arrayAvion[];

    public void generarAviones(Integer aviones) {

        aviones--;
        arrayAvion = new Avion[aviones];

        for (int i = 0; i < arrayAvion.length; i++) {

            Integer azar = (int) (rnd.nextDouble() * 100 + 0);

            if (azar <= 25) {
                arrayAvion[i] = new Avion("pequeño", 1, ((int) (rnd.nextDouble() * 10 + 5)), 1, (int) (rnd.nextDouble() * 3 + 1));
            } else if (azar <= 55 && azar >= 26) {
                arrayAvion[i] = new Avion("mediano", 2, ((int) (rnd.nextDouble() * 25 + 15)), 2, ((int) (rnd.nextDouble() * 4 + 2)));
            } else {
                arrayAvion[i] = new Avion("grande", 3, ((int) (rnd.nextDouble() * 40 + 30)), 3, ((int) (rnd.nextDouble() * 6 + 3)));
            }

        }

    }

//    Integer m;
//    Integer n;
    //matriz = new tipo [fila][columna];
//    public void setMatriz(int columna, int fila) {
//        m = columna;
//        n = fila;
//    }
    public Pasajero atienden[][];// = new Pasajero[m][n];
    public Pasajero tempPasajero[][];
    public Avion servicios[][];
    public String maletas[];

    public void paraConsola(JTextArea Mostrar, int turnos, int aviones, int escritorio, int fila, int colServicio, int filaServicio, int turnoActual) {
        try {

            tempPasajero = new Pasajero[fila][escritorio];
            atienden = new Pasajero[fila][escritorio];
            servicios = new Avion[colServicio][filaServicio];
            maletas = new String[500];

            if (pasAbajo == 0) {

                generarAviones(aviones);

                for (int x = 0; x < tempPasajero.length; x++) {
                    for (int y = 0; y < tempPasajero[0].length; y++) {
                        tempPasajero[x][y] = new Pasajero();

                    }
                }

                for (int x = 0; x < servicios.length; x++) {
                    for (int y = 0; y < servicios[0].length; y++) {
                        servicios[x][y] = new Avion();
                    }
                }
            }

            int avionActual = 0;

            Mostrar.append("\n--------------------------------------------------------------------------------------------------\n"
                    + "\n*****************************************Turno " + turnoActual + "*************************************************\n"
                    + "--------------------------------------------------------------------------------------------------\n"
                    + "arribo avión " + arrayAvion[avionActual].tipo + "\n"
                    ////                +"Pasajeros desabordando: " +  arrayAvion[avionActual+turnoActual].pasajeroXAvion + "\n"        
                    + "Avión desabordando: " + arrayAvion[(avionActual)].tipo + "\n"
                    + "\n---------------------------------Escritorios de registro--------------------------------------\n");

            pasajerosSaliendo(arrayAvion[avionActual].pasajeroXAvion);

            if (arrayAvion[avionActual].desabordaje > 0) {
                arrayAvion[avionActual].desabordaje--;
                arrayAvion[avionActual].tipo = "ninguno";

            } else {
                avionActual++;

            }

            for (Integer abc = 0; abc < escritorio; abc++) {
                char L = (char) (65 + abc);

                Mostrar.append("Escritorio " + L + ": ocupado\n"
                        + "         \tPasajero atendido:" + atienden[0][abc].id + "\n"
                        + "         \tTurnos restantes:" + (atienden[0][abc].turnos) + " \n"
                        + "         \tCantidad de documentos:" + (atienden[0][abc].documentos) + " \n"
                );

                if (atienden[0][abc].turnos == 1) {
                    atienden[1][abc] = atienden[0][abc].copiarPasajero(atienden[0][abc]);
                    //mostrarMaletas();
                } else {
                    atienden[0][abc].turnos--;
                    atienden[0][abc].documentos--;
                }

            }

            Mostrar.append("\n***************************************Estaciones de Servicio************************************************\n");

            for (int i = 0; i < colServicio; i++) {
                Mostrar.append("Estación" + i + ": ocupado\n"
                        + "         Avión en mantenimiento:" + servicios[0][i].no + "\n"
                        + "         Turnos restantes: " + servicios[0][i].Mantenimiento + "\n"
                );
            }
            Mostrar.append("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"
                    + "Cantidad de maletas actualmente en el sistema:" + pasAbajo + "\n"
                    + "Estado de las maletas anterior\n");

            for (int i = 0; i <= pasAbajo; i++) {
                Mostrar.append(maletas[i]);
            }

            Mostrar.append("Estado de las maletas ordenadas\n");

            for (int i = 0; i <= pasAbajo; i++) {
                Mostrar.append(maletas[i]+"\n");
            }

            Mostrar.append("Turnos restantes" + (turnos - turnoActual) + "\n"
                    + "***************************************************Fin de Turno 3***************************************************");

        } catch (Exception ex) {

        }
    }

    private void pasajerosSaliendo(int bajando) {

        int contador = 0;

        for (int x = 0; x < atienden.length; x++) {
            for (int y = 0; y < atienden[0].length; y++) {
                if (atienden[x][y] != null || contador < bajando) {
                    atienden[x][y] = new Pasajero(pasAbajo, ((int) (rnd.nextDouble() * 4 + 1)), ((int) (rnd.nextDouble() * 10 + 1)), ((int) (rnd.nextDouble() * 3 + 1)));
                    maletas[pasAbajo] = atienden[x][y].id + "-" + atienden[x][y].maletas;
                    contador++;
                    pasAbajo = +contador;
                    //tempPasajero[y][x] = atienden[y][x].copiarPasajero(atienden[y][x]);
                }
            }
        }

    }

}
