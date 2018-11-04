package Deber1Sem2.deber2progra;

import java.time.LocalDate; //Da un formato de Fecha 
import java.time.Period; // Clase que contiene métodos de calculos de fechas 
import java.time.format.DateTimeFormatter; // Clase para dar formato de fecha, puede variar 

/**
 *
 * @author Jhon
 */
public class FrecuenciasCardiacas {

    //Atributos
    private String nombre; //nombre de la persona 
    private String apellido; //Apellido de la persona
    private int dia; // Día de nacimiento de la persona
    private int mes; //Mes de nacimiento de la persona
    private int anioNaci; //Año de nacimiento  de la persona
    
   //Constructor
    public FrecuenciasCardiacas(String nombre, String apellido, int dia, int mes, int anioNaci) {
        setAnioNaci(anioNaci);
        setApellido(apellido);
        setDia(dia);
        setMes(mes);
        setNombre(nombre);
    } //Fin del constructor

    //Asigna el nombre ingresado
    public void setNombre(String nombre) {
        this.nombre = nombre;
    } //Fin del método setNombre

    //Asigna el apellido ingresado
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }//Fin del método setApellido

    //Asigna el día de nacimiento ingresado
    public void setDia(int dia) {
        this.dia = dia;
    }//Fin del método setDia

    //Asigna el mes de nacimiento ingresado
    public void setMes(int mes) {
        this.mes = mes;
    }//Fin del método setMes

    //Asigna el año de nacimiento ingresado
    public void setAnioNaci(int anioNaci) {
        this.anioNaci = anioNaci;
    } //Fin del método setAnioNaci

    //Obtiene el nombre asignado
    public String getNombre() {
        return nombre;
    }//Fin del método getNombre

    //Obtiene el apellido asignado
    public String getApellido() {
        return apellido;
    }//Fin del método getApellido

    //Obtiene el día asignado
    public int getDia() {
        return dia;
    }//Fin del método getDia

    //Obtiene el mes asignado
    public int getMes() {
        return mes;
    }// Fin del método getMes

    //Obtiene el año asignado
    public int getAnioNaci() {
        return anioNaci;
    }//Fin del método getAnioNaci

    //Método para calcular la edad de la persona
    public int calcularEdad() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("d/M/yyyy"); //Da un formato para el tipo de fecha dia/mes/año
        LocalDate actual = LocalDate.now(); //Llama para establecer la fecha actual
        LocalDate nacimiento = LocalDate.parse(getDia() + "/" + getMes() + "/" + getAnioNaci(), formatoFecha); //Pasamos los datos ungresados de la fecha con el formato dd/mm/año
        Period tiempoTranscu = Period.between(nacimiento, actual); //Calcula el tiempo trancurrido, entre fechas.
        return tiempoTranscu.getYears();
    }//Fin del método calcularEdad

    //Método para calcular la frecuencia cardiaca máxima de la persona deacuerdo a su edad.
    public int frecCardiacaMax() {
        int frecuencia = 220 - calcularEdad(); //220- la edad calculada
        return frecuencia;
    }//Fin del método fecCardiacaMax.

    //Método para calcular el intervalo cardiaco de la paersona en un 50% y 85% 
    public int intervaloPorcen(double porcentaje) {
        int intervalo = (int) (frecCardiacaMax() * (porcentaje / 100));
        return intervalo;
    }//Fin del método intervaloPorcen

    @Override //Sobreescribe. 
    public String toString() { //Método toString
        String cardiaca = String.format("Usted: %s %s\ntiene una edad de: %d\ncon una frecuencia Cardiaca Máxima de: %d\nSu intervalo cardiaco en sun 50%% es de: %d\nSu intervalo cardiaco en su 85%% es de: %d", getNombre(), getApellido(), calcularEdad(), frecCardiacaMax(), intervaloPorcen(50), intervaloPorcen(85));
        return cardiaca;
    }//Fin del método toString

    //El método main() inicia la ejecución del programa
    public static void main(String[] args) {
        //Mensaje para avisar sobre el formato de ingreso de los datos de la fecha.
        System.out.println("Formato es dia/mes/año");
        //Creacion del objeto 1 (persona1)
        FrecuenciasCardiacas persona1 = new FrecuenciasCardiacas("Jonathan", "Herrera", 20, 01, 1999);
        //Imprime todo lo calculado en base a los datos del objeto 1 (persona1)
        System.out.println(persona1);
        System.out.println("");
        //Creacion del objeto 2 (persona2)
        FrecuenciasCardiacas persona2 = new FrecuenciasCardiacas("Darwin", "Herrera", 02, 06, 1974);
        //Imprime todo lo calculado en base a los datos del objeto 2 (persona2)
        System.out.println(persona2);    
    }
}
