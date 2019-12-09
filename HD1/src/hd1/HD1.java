/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hd1;

import java.util.Scanner;

import java.util.InputMismatchException;

/**
 *
 * @author Jhoans
 */
public class HD1 {

    static Scanner teclado = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu();

    }

    public static void Menu() {

        boolean salir = false;
        int opcion;

        while (!salir) {

            System.out.println("\n1. Enunciado 1");
            System.out.println("2. Enunciado 2");
            System.out.println("3. Enunciado 3");
            System.out.println("4. Enunciado 4");
            System.out.println("Para salir presione 5");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1\n"
                        );
                        Numero();

                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        Fecha();

                        break;
                    case 3:
                        System.out.println("Has seleccionado la opción 3");
                        Unidades();
                        break;
                    case 4:
                        System.out.println("Has seleccionado la opción 3");
                        Alumnos();
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                teclado.next();
            }
        }
    }

    public static void Numero() {
        System.out.println("Ingrese un número: ");
        String numero = teclado.next();
        
        String num[]= numero.split("\\.");
        String decimal = num[1];
        String entero = num[0];
        int cantDec= decimal.length();
        int canEntero= entero.length();
        
        int digitos = cantDec + canEntero;
        System.out.println("El numero ingresado tiene " + digitos + " digitos.");
        
        double n = Double.parseDouble(numero);
        
        
        if(n % 1 != 0){
        
        System.out.println("El número es decimal y tiene "+ cantDec+" decimales.");
            
        }else{
           if(n%2 == 0){
               System.out.println("El número es entero y es múltiplo de dos");
               
           }else System.out.println("El número es entrero y no es múltiplo de dos.");
        }
        
        
        
        

    }

    public static void Fecha() {
        int total = 0;
        int enMes[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        System.out.println("Ingese el día: ");
        int dia = teclado.nextInt();
        System.out.println("Ingese el mes: ");
        int mes = teclado.nextInt();
        System.out.println("Ingese el año: ");
        int anyio = teclado.nextInt();
        
        

        for (int i = 0; i < mes - 1; i++) {
            total = enMes[i]+total;
        }
        total = total + dia;

        System.out.println("Los días hata la fecha " + dia + "/" + mes + "/" + anyio + " son: " + total + " días\n.");

    }

    public static void Unidades() {

        System.out.println(" Ingrese la longitud en pulgadas que desea convertir a centimetros");
        System.out.println("Pulgadas: ");
        double longitud = teclado.nextDouble();
     
        System.out.println(" Ingrese la masa en kilogramos que desea convertir a libras");
        System.out.println("Kilogramos: ");
        double masa = teclado.nextDouble();
 

        if (longitud < 0 || masa < 0) {
            Menu();

        }

        double lb = 2.2 * masa;
        double cm = 2.54 * longitud;

        System.out.println(masa + " kilogramos equivalen a " + lb + " libras.");
        System.out.println(longitud + " pulgadas equivalen a " + cm + " centimetros.");

    }

    public static void Alumnos() {
        int n = 0;

        double edad[] = new double[6];
        double altura[] = new double[6];
        double promEdad = 0, promAltura = 0;
        int adultos = 0;
        int altos = 0;

        while (n < 6) {
            System.out.println("Ingrese la edad del alumno " + (n+1));
            edad[n] = teclado.nextInt();
            System.out.println("Ingese la altura del alumno " + (n+1));
            altura[n] = teclado.nextDouble();
            n++;
        }

        for (int i = 0; i < 6; i++) {
            promEdad = edad[i] + promEdad;
            promAltura = altura[i] + promAltura;

            if (edad[i] >= 18) {
                adultos++;
            }

            if (altura[i] >= 1.70) {
                altos++;
            }

        }

        System.out.println("El promedio de edades es de " + promEdad / 6);
        System.out.println("El promedio de estaturas es de " + promAltura/6);
        System.out.println("Los mayores de edad son " + adultos + " alumnos");
        System.out.println("Los que miden más de 1.70m son " + altos + " alumnos");

    }

}
