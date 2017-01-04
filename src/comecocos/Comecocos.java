package comecocos;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Clase Comecocos, define el constructor y los métodos para el objeto comecocos creado en la clase Principal
 * @author Llanos Núñez Alvarez
 * @see clase Principal
 * @version05012017A
 */

public class Comecocos {
    
/**
 * Clase Comecocos, define el constructor y los métodos para el objeto comecocos creado en la clase Principal
 * @param  x posición en x
 * @param y posición en y
 * @param grados dirección del objeto en grados: 0, 90, 180, 270
 * @param Dirección enum con  los puntos cardinales que se asignara segun los grados dados 
 */

    // Definimos atributos de clase pasados desde principal con valor 0. 0 grados es NORTE 
    int x, y, grados;
    private Direccion direccion = Direccion.NORTE;// Dirección por defecto

    // Definimos el enum Dirección con los cardinales
    public enum Direccion {
        NORTE, SUR, ESTE, OESTE;
    }
    
    /** Constructor sin parametros, podria inicializar un objeto con los valores por defecto
     */
    public Comecocos() {
        x=0;
        y=0;
        direccion=Direccion.NORTE;
    }

    /** Constructor con parametros, construira el objeto pasando los atributos
    * @param x posición en x
    * @param y posición en y
    * @param grados dirección del objeto en grados: 0, 90, 180, 270
     */
    public Comecocos(int x, int y, int grados) {
        this.x = x;
        this.y = y;
        this.grados = grados;
    }
    
    //Getters
    /** Método get
     * @return grados
     */
    public int getGrados() {
        return grados;
    }
    /** Método get
     * @return grados
     */
    public int getX() {
        return x;
    }
    /** Método get
     * @return y
     */
    public int getY() {
        return y;
    }
    
    //Setters
    /** Método set
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }
    /** Método set
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }
    /** Método set
     * @param grados
     */
    public void setGrados(int grados) {
        this.grados = grados;
    }
    
     /**
     * Método que asigna los números a los puntos cardinales segun el valor en grados
     * @return dirección que será el punto cardinal NORTE, SUR, ESTE u OESTE
     */
    public Direccion gradosAdireccion() {
        
        // Asignamos el valor del enum segun el valor de grados
        switch (grados) {
            case 0:
                this.direccion = Direccion.NORTE;
                break;
            case 90:
                this.direccion = Direccion.ESTE;
                break;
            case 180:
                this.direccion = Direccion.SUR;
                break;
            case 270:
                this.direccion = Direccion.OESTE;
                break;
            default:
                this.direccion = Direccion.NORTE;
                break;
        }
        return direccion;
    }
    
     /**
     * Método que asigna los grados a los 4 puntos cardinales
     * @return grados que sera 0, 90, 180, 270
     */
    public int direccionAGrados() {
        
        // Asignamos el valor del enum segun el valor de grados
        switch (direccion) {
            case NORTE:
                this.grados = 0;
                break;
            case ESTE:
                this.grados = 90;
                break;
            case SUR:
                this.grados = 180;
                break;
            case OESTE:
                this.grados = 270;
                break;
            default:
                this.grados = 0;
                break;
        }
        return grados;
    }
    
 
    /**
    * Método posicion
    * @param x posición en x
    * @param y posición en y
    * @param grados dirección del objeto en grados: 0, 90, 180, 270
    * @return mensaje describiendo la posición del objeto según los parametros pasados. Estos iran cambiando según se aplican los métodos. 
    */
    public String toString(int x, int y, int grados) {
        this.x = x;
        this.y = y;
        this.grados = grados;
        // Llamamos al metodo getDireccion para transformar grados a el enum con los carinales y pasar asi el valor de dirección.
        gradosAdireccion();
        String mensajePosicion = "El comecocos está en la posicion x:" + this.x + ", y:" + this.y + " con direccion " + direccion + ".";
        return mensajePosicion;
    }

    /**
    * Método avanzar para y si los grados son son 0 o 180
    * @param y posición en y
    * @return nuevo valor de y después de sumarle 10
    */
    int avanzarY(int y) {
        this.y = y;
        // Sumamos 10 a y
        y = y + 10;
        return y;
    }

    /**
    * Método avanzar para x si los grados son son 0 o 180
    * @param x posición en x
    * @return nuevo valor de x después de sumarle 10
    */
    int avanzarX(int x) {
        this.x = x;
        // Sumamos 10 a x
        x = x + 10;
        return x;
    }

    /**
    * Método girarDer, calcula el nuevo valor de grados sumandole 90 grados
    * @param grados valor de grados 0, 90, 180, 270
    * @return nuevo valor de x después de sumarle 90
    */
    int girarDerecha(int grados) {
        this.grados = grados;
        // Sumamos 90 a d 
        grados = grados + 90;
        // Reseteo el valor de grados si al ir girando a la derecha llega a 360 asi volvera a ser 0 y empezamos el giro de nuevo
        if (grados == 360) {
                grados = 0;
        }
        return grados;
    }

    /**
    * Método girarIzq, calcula el nuevo valor de grados restandole 90 grados
    * @param grados, valor de grados 0, 90, 180, 270
    * @return nuevo valor de x después de restarle 90
    */
    int girarIzquierda(int grados) {
        this.grados = grados;
        // Restamos 90 a d 
        grados = grados - 90;
        return grados;
    }

    /**
    * Método reproducirSonido. Reproduce el sonido del archivo del parametro muere al aplicarle el metodo al objeto
    * @param muere que es el archivo de sonido a reproducir
    */
    public void reproducirSonido(String muere) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(muere).getAbsoluteFile());
            AudioFormat formatoSonido = audioInputStream.getFormat();
            DataLine.Info infoSonido = new DataLine.Info(Clip.class, formatoSonido);
            Clip clip = (Clip)AudioSystem.getLine(infoSonido);
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido.");
        }
    }

}
