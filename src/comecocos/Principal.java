package comecocos;

import static util.ES.*;

/**
 * Clase principal del comecocos. Pregunta al usuario los valores de la posición y crea un objeto de la clase Comecocos 
 * basado en los datos. Después da opciones para modificar los valores introducidos e ir cambiando la posición del objeto. 
 * Para modificar los valores llama a métodos de la clase Comecocos. 
 * @author Llanos Núñez Alvarez
 * @see clase Comecocos
 * @version05012017A
 */
public class Principal {
    
    /**
     * Pide las posiciones x e y del comecocos, así como los grados de la 
     * dirección de partida, es decir, se espera que el usuario instroduzca
     * 0, 90, 180 o bien 270. Si no introduce como grados uno de esos datos, el
     * programa terminará la ejecución. Si introduce un valor permitido, 
     * entonces el programa creará el objeto comecocos mediante el constructor
     * con parámetros, escribirá la posición inicial y se invocará a un método
     * para controlar al comecocos, en función de las entradas por teclado.
     * @param args
     */

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
        int grados = leeGrados(mensajeD);

        /* Si son válidos los datos que hemos leído por teclado, entonces 
          creamos el objeto con los datos leídos. Iniciamos objeto comecocos e imprimimos mensaje con posicion inicial */
        Comecocos elComecocos = new Comecocos(x, y, grados);
        String posicion = elComecocos.toString(x, y, grados);
        System.out.println(posicion);
        
        // Obtener la dirección equivalente a los grados leídos por teclado esta hecho en la clase comecocos.

        // Controlar al comecocos según las ordenes recibidas por teclado
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
                    if (grados == 0 || grados == 180) {
                        y = elComecocos.avanzarY(y);
                    }
                    if (grados == 90 || grados == 270) {
                        x = elComecocos.avanzarX(x);
                    }
                    System.out.println("Avanzando 10...");
                    String posicionMasDiez = elComecocos.toString(x, y, grados);
                    System.out.println(posicionMasDiez);
                    break;
                case 1:
                    // Llamar metodo girarDer
                    grados = elComecocos.girarDerecha(grados);
                    System.out.println("Girando a la derecha...");
                    String posicionDerecha = elComecocos.toString(x, y, grados);
                    System.out.println(posicionDerecha);
                    break;
                case 2:
                    //Para d = 0 hago d sera 270 para que sea OESTE. Para los otros les resto 90 en el metodo girarIzq. 
                    if (grados == 0) {
                        grados = 270;
                    } else {
                        grados = elComecocos.girarIzquierda(grados);
                    }
                    System.out.println("Girando a la izquierda hacia el OESTE...");
                    String posicionIzquierda = elComecocos.toString(x, y, grados);
                    System.out.println(posicionIzquierda);
                    break;
                case 3:
                    System.out.println("Emitiendo sonido...");
                    // Llamar metodo emitirSonido
                    
                    elComecocos.reproducirSonido("src/recursos/pacman.wav");
                    break;
                case 4:
                    // Salir
                    System.out.println("Hasta pronto!");
                    break;
                default:
                    // Salir
                    System.out.println("Hasta pronto!");
                    break;
            }
        }

    }
}
