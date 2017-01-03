package comecocos;

import static comecocos.ES.*;
//import util.ES; TODO: Mover ES.java to util 

/**
 *
 * @author llanos
 */
public class Principal {

    public static void main(String[] args) {

        // Pedir los datos iniciales usando los metodos definidos en ES.java
        // valor de las coordenadas x
        String mensajeX = "Introduzca la coordenada en el eje x: ";
        int x = leeEntero(mensajeX);

        // valor de las coordenadas y
        String mensajeY = "Introduzca la coordenada en el eje y: ";
        int y = leeEntero(mensajeY);

        // leeGrados es un metodo añadido por mi a ES.java para controlar que el input sea 0, 90, 180, 270. Valor de la direccion d
        String mensajeD = "Introduzca la direccion en grados (solo permitidos 0, 90, 180, 270): ";
        int d = leeGrados(mensajeD);

        // Obtener la dirección equivalente a los grados leídos por teclado esta hecho en la clase comecocos.
        // Iniciamos objeto comecocos e imprimimos mensaje con posicion inicial
        Comecocos elComecocos = new Comecocos(x, y, d);
        String posicion = elComecocos.posicion(x, y, d);
        System.out.println(posicion);

        // Opciones con un switch para que sea mas eficiente
        // Iniciamos numero = 0 para hacer un loop while y mientras no sea 4 (salir) el menu se reiniciara dando las opciones.
        int numero = 0;
        while (numero!=4) {
            // Leer opcion limitando las opciones hasta el 4
            String mensajeOpcion = "\nElija una de las siguientes opciones: \n0-> Avanzar 10 pasos.\n1-> Girar a la derecha.\n2-> Girar a la izquierda.\n3-> Emitir sonido.\n4-> Salir del programa.";
            numero = leeEntero(mensajeOpcion, 0, 4);
            switch (numero) {
                case 0:
                    //Llamar metodo avanzarDiezX o avanzarDiezY segun una logica de si se tiene que avanzar en x o en y dependiendo de la direccion. Lo he calculado todo con grados 
                    if (d == 0 || d == 180) {
                        y = elComecocos.avanzarDiezY(y);
                    }
                    if (d == 90 || d == 270) {
                        x = elComecocos.avanzarDiezX(x);
                    }
                    System.out.println("Avanzando 10...");
                    String posicionMasDiez = elComecocos.posicion(x, y, d);
                    System.out.println(posicionMasDiez);
                    break;
                case 1:
                    // Llamar metodo girarDer
                    d = elComecocos.girarDer(d);
                    System.out.println("Girando a la derecha...");
                    String posicionDerecha = elComecocos.posicion(x, y, d);
                    System.out.println(posicionDerecha);
                    break;
                case 2:
                    //Para d = 0 hago d sera 270 para que sea OESTE. Para los otros les resto 90 en el metodo girarIzq. 
                    if (d == 0) {
                        d = 270;
                    } else {
                        d = elComecocos.girarIzq(d);
                    }
                    System.out.println("Girando a la izquierda hacia el OESTE...");
                    String posicionIzquierda = elComecocos.posicion(x, y, d);
                    System.out.println(posicionIzquierda);
                    break;
                case 3:
                    System.out.println("Emitiendo sonido...");
                    // Llamar metodo emitirSonido
                    
                    elComecocos.ReproducirSonido("src/recursos/pacman.wav");
                    break;
                case 4:
                    // Llamar metodo salir
                    System.out.println("Hasta pronto!");
                    break;
                default:
                    // Llamar metodo salir
                    System.out.println("Hasta pronto!");
                    break;
            }
        }

    }
}
