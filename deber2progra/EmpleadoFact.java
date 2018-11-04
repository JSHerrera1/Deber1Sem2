package deber2progra;

/**
 *
 * @author Jhon
 */
public class EmpleadoFact {

    //Variables de instancia o atributos de clase
    private String codigo; //Código del producto
    private String cacterisPieza; //Caracteristica del producto
    private int cantidad; //Cantidad del producto a comprar
    private double precioUnit; //Precio unitario del producto

    //Constuctor  para verificar si los datos estan bien ingresados, como un filtro
    public EmpleadoFact(String codigo, String cacterisPieza, int cantidad, double precioUnit) {
        setCacterisPieza(cacterisPieza);
        setCantidad(cantidad);
        setCodigo(codigo);
        setPrecioUnit(precioUnit);
    }//ternima el constructor

    //Obtiene el código único del producto
    public String getCodigo() {
        return codigo;
    }//Fin del método getCódigo

    //Asigna el código único al producto
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }//Fin del método setCódigo

    //Obtiene las características del producto
    public String getCacterisPieza() {
        return cacterisPieza;
    }//Fin del método getCaraterísticas

    //Asigna las características del producto
    public void setCacterisPieza(String cacterisPieza) {
        this.cacterisPieza = cacterisPieza;
    }//Fin del método setCaracterísticas 

    //Obtiene el número o la cantidad de la cual se van a comprar.
    public int getCantidad() {
        return cantidad;
    }//Fin del método getCantidad

    //Asigna las condiciones a los valores ingresados
    public void setCantidad(int cantidad) {
        if (cantidad <= 0) { //si el valor dado de la cantidad es menor o iguala 0, pues asignar por defecto 0.
            this.cantidad = 0;
        } else {
            this.cantidad = cantidad; //Si el valor es mayor a 0 pues asignar el valor ingresado
        }
    }//Fin del método setCantidad

    //Obtiene el precio unitario del producto
    public double getPrecioUnit() {
        return precioUnit;
    }//Fin del método getPrecioUnit

    //Asigna el precio unitario para evaluarlo a la siguientes condiciones
    public void setPrecioUnit(double precioUnit) {
        if (precioUnit < 0) { //Si el precio unitario dadop es menor a 0, asignar 0.
            this.precioUnit = 0.0;
        } else {              // Si el precio unitario es mayor a 0, pues asignar el valor dado.
            this.precioUnit = precioUnit;
        }
    } // Fin del método setPrecioUnit

    //Método que calcula el total a cobrar 
    public double obtenerMontoFactura() {
        double montoPieza = precioUnit * cantidad; //Multiplica el precio Unitario del produto por la cantidad de unidades. 
        return montoPieza;
    }//Fin del método obtnerMontoFactura

    @Override//Sobreescribir
    public String toString() { //Método toString, se usa para asignar el formato de presentacion a los diferentes objetos que se creen
        String factura = String.format("Código: %s\nDescripcion: %s\n", getCodigo(), getCacterisPieza());
        factura += String.format("Cantidad de articulos comprados: %d \nPrecio unitario: %.2f\nEl precio total a pagar es de: %.2f\n", getCantidad(), getPrecioUnit(), obtenerMontoFactura());
        return factura;
    } //Fin del método toString

    //El método main() inicia la ejecución del programa
    public static void main(String[] args) {
        //Creacion del eobjeto 1 con sus datos
        EmpleadoFact factura1 = new EmpleadoFact("ABC-5698", "Pernos 4 pulgadas", 2, 0.50);
        //Creación del objeto 2 con sus datos
        EmpleadoFact factura2 = new EmpleadoFact("ABC-69801", "Pernos 2 pulgadas", -5, 0.50);

        //Presentación de los datos generados en base a los datos ingresados del objeto 1
        System.out.println(factura1);
        //Presentación de los datos generados en base a los datos ingresados del objeto 2
        System.out.println(factura2);

    }//Fin del main().
} // Fin de la clase EmpleadoFact.
