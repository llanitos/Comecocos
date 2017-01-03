package comecocos;
//import util.ES; TODO: Mover ES.java to util 

import static comecocos.ES.*;

/**
 *
 * @author llanos
 */
public class Principal {

    public static void main(String[] args) {

        // Pedir los datos iniciales usando los metodos definidos en ES.java
        String mensajeX = "Introduzca la coordenada en el eje x: ";
        int x = leeEntero(mensajeX);

        String mensajeY = "Introduzca la coordenada en el eje y: ";
        int y = leeEntero(mensajeY);

        // leeGrados es un metodo añadido por mi a ES.java para controlar que el input sea 0, 90, 180, 270
        String mensajeD = "Introduzca la direccion en grados (solo permitidos 0, 90, 180, 270): ";
        int d = leeGrados(mensajeD);

        // Obtener la dirección equivalente a los grados leídos por teclado.
        // Esto esta hecho en la clase comecocos 
        // Iniciamos objeto comecocos e imprimimos mensaje con posicion inicial
        Comecocos elComecocos = new Comecocos(x, y, d);
        String posicionInicial = elComecocos.posicionInicial(x, y, d);
        System.out.println(posicionInicial);

        // TODO remover, solo queria pasar al vairable direccion, seguramente no sea utilizada aqui
        //Comecocos.Direccion direccion = elComecocos.getDireccion();
        //System.out.println(direccion);
        // Leer opcion limitando las opciones hasta el 4
        String mensajeOpcion = "\nElija una de las siguientes opciones: \n0-> Avanzar 10 pasos.\n1-> Girar a la derecha.\n2-> Girar a la izquierda.\n3-> Emitir sonido.\n4-> Salir del programa.";
        int numero = leeEntero(mensajeOpcion, 0, 4);

        // Opciones. He sado un switch por eficiencia 
        boolean finalizado = false;
        switch (numero) {
            case 0:
                //Llamar metodo avanzarDiez
                System.out.println("Avanzando 10");
                break;
            case 1:
                // Llamar metodo girarDer
                System.out.println("Girando a la derecha hacia el SUR");
                break;
            case 2:
                // Llamar metodo girarIzq
                System.out.println("Girando a la izquierda hacia el OESTE");
                break;
            case 3:
                System.out.println("Emitiendo sonido");
                // Llamar metodo emitirSonido
                break;
            case 4:
                // Llamar metodo salir
                System.out.println("Saliendo");
                finalizado = true;
                break;
            default:
                // Llamar metodo salir
                System.out.println("Saliendo");
                finalizado = true;
                break;
        }

    }
    /**
     * Método que está continuamente leyendo de teclado un número entero,
     * indicando al usuario las opciones: 0-> Avanzar 10 pasos. 1-> Girar a la
     * derecha. 2-> Girar a la izquierda. 3-> Emitir sonido. 4-> Salir del
     * programa
     *
     * @param elComecocos Objeto comecocos creado al principio del programa,
     */

    // Mientras que no se cumpla la condición de terminación
    // Informar de opciones y leer número entero correspondiente a la opción a ejecutar
    // Según lo leído, invocar al método pertienente
    // Informar sobre la posición del comecocos
}
