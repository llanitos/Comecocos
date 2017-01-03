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

    public void setDireccion() {

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

            default:
                this.direccion = Direccion.NORTE;
                break;
        }
    }

    // No usado por ahora, TODO remover?
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

            default:
                this.direccion = Direccion.NORTE;
                break;
        }
        return direccion;
    }

    //Metodo posicionInicial
    String posicionInicial(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
        // Llamamos al metodo getDireccion para que de la viariable introducida para la direccion d lo transforme en el enum con los carinales.
        getDireccion();
        this.direccion = direccion;
        String mensajePosicion = "El comecocos está en la posicion " + this.x + "," + this.y + " con direccion " + direccion + ".";
        return mensajePosicion;
    }

}
