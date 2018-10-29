package deber2progra;

/**
 *
 * @author Jhon
 */
public class EmpleadoFact {

    //Variables de instancia o atributos de clase
    private String codigo;
    private String cacterisPieza;
    private int cantidad;
    private double precioUnit;

    //Constuctor 
    public EmpleadoFact(String codigo, String cacterisPieza, int cantidad, double precioUnit) {
        setCacterisPieza(cacterisPieza);
        setCantidad(cantidad);
        setCodigo(codigo);
        setPrecioUnit(precioUnit);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCacterisPieza() {
        return cacterisPieza;
    }

    public void setCacterisPieza(String cacterisPieza) {
        this.cacterisPieza = cacterisPieza;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            this.cantidad = 0;
        } else {
            this.cantidad = cantidad;
        }

    }

    public double getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(double precioUnit) {
        if (precioUnit < 0) {
            this.precioUnit = 0.0;
        } else {
            this.precioUnit = precioUnit;
        }

    }

    public double obtenerMontoFactura() {
        double montoPieza = precioUnit * cantidad;
        return montoPieza;
    }

    @Override
    public String toString() {
        String factura = String.format("Código: %s\nDescripcion: %s\n", getCodigo(), getCacterisPieza());
        factura += String.format("Cantidad de articulos comprados: %d \nPrecio unitario: %.2f\nEl precio total a pagar es de: %.2f\n", getCantidad(), getPrecioUnit(), obtenerMontoFactura());
        return factura;
    }

    public static void main(String[] args) {
        EmpleadoFact factura1 = new EmpleadoFact("ABC-5698", "Pernos 4 pulgadas", 2, 0.50);
        EmpleadoFact factura2 = new EmpleadoFact("ABC-69801", "Pernos 2 pulgadas", -5, 0.50);

        System.out.println(factura1);
        System.out.println(factura2);

    }
}
