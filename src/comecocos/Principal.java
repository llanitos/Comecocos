
package comecocos;
import static comecocos.ES.leeEntero;

/**
 *
 * @author llanos
 */
public class Principal {
    
    public static void main(String[] args) {
        
        String mensajeX = "Introduzca la coordenada en el eje x: ";
        int leeEntero = leeEntero(mensajeX);
        int x = leeEntero;
        
        String mensajeY = "Introduzca la coordenada en el eje y: ";
        int leeEnteroY = leeEntero(mensajeY);
        int y = leeEnteroY;
        
        String mensajeD = "Introduzca la direccion en grados (solo permitidos 0, 90, 180, 270): ";
        int leeEnteroD = leeEntero(mensajeD);
        int direccion = leeEnteroD;
        
        System.out.println("Coordenada x: " + x);
        System.out.println("Coordenada y: " + y);
        System.out.println("Direccion: " + direccion);
        
    }
    
}
