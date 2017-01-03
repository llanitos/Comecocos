
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
        
        // Obtener la dirección equivalente a los grados leídos por teclado. Convertir 0, 90, 180, 270 a norte, este, sur, oeste.
        
        // Iniciamos objeto comecocos e imprimimos mensaje con posicion inicial
        Comecocos elComecocos = new Comecocos(x, y, d);
        String posicionInicial = elComecocos.posicionInicial(x, y, d);
        System.out.println(posicionInicial);
        
    }   
    

    
}
