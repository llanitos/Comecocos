package comecocos;

/**
 *
 * @author llanos
 */
public class Comecocos {

    /**
     * @param args the command line arguments
     */
    // Definimos atributos de clase pasados desde principal
    int x, y, d;
    private Direccion direccion = Direccion.NORTE;// Direccion por defecto

    public enum Direccion {
        NORTE, SUR, ESTE, OESTE;
    }

    // Constructor, esto me construira mi objeto en principal cuando lo llame usando los atributos pasados
    public Comecocos(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }

    // Asignar los numeros a los puntos cardinales
    public Direccion getDireccion() {

        switch (d) {
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
             
            case 360:
                this.direccion = Direccion.NORTE;
                break;

            default:
                this.direccion = Direccion.NORTE;
                break;
        }
        return direccion;
    }

    //Metodo posicionInicial
    String posicion(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
        // Llamamos al metodo getDireccion para que de la viariable introducida para la direccion d lo transforme en el enum con los carinales.
        getDireccion();
        this.direccion = direccion;
        String mensajePosicion = "El comecocos está en la posicion x: " + this.x + " , y: " + this.y + " y con direccion " + direccion + ".";
        return mensajePosicion;
    }

    //Metodo avanzarDiez para y si los cardinales son 0 o 180
    int avanzarDiezY(int y) {
        this.y = y;
        // Sumamos 10 a y
        y = y + 10;
        return y;
    }

    //Metodo avanzarDiez para y si los cardinales son 0 o 180
    int avanzarDiezX(int x) {
        this.x = x;
        // Sumamos 10 a x
        x = x + 10;
        return x;
    }
    
    // Metodo girarDer, calcula el nuevo valor de d sumandole 90 grados para despues poder pasarlo a cardinal
    int girarDer(int d) {
        this.d= d;
        // Sumamos 90 a d 
        d = d + 90;
        return d;
    }
    
    // Metodo girarIzq, calcula el nuevo valor de d restandole 90 grados para despues poder pasarlo a cardinal
    int girarIzq(int d) {
        this.d= d;
        // Restamos 90 a d 
        d = d - 90;
        return d;
    }

}
