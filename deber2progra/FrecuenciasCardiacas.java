package deber2progra;

import java.time.LocalDate; //Da un formato de Fecha 
import java.time.Period; // Clase que contiene m'etodos de calculos de fechas 
import java.time.format.DateTimeFormatter; // Clase para dar formato de fecha, puede variar 

/**
 *
 * @author Jhon
 */
public class FrecuenciasCardiacas {

    //Atributos
    private String nombre;
    private String apellido;
    private int dia;
    private int mes;
    private int anioNaci;

    public FrecuenciasCardiacas(String nombre, String apellido, int dia, int mes, int anioNaci) {
        setAnioNaci(anioNaci);
        setApellido(apellido);
        setDia(dia);
        setMes(mes);
        setNombre(nombre);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAnioNaci(int anioNaci) {
        this.anioNaci = anioNaci;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnioNaci() {
        return anioNaci;
    }

    public int calcularEdad() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("d/M/yyyy"); //Da un formato para el tipo de fecha dia/mes/año
        LocalDate actual = LocalDate.now(); //Llama para establecer la fecha actual
        LocalDate nacimiento = LocalDate.parse(getDia() + "/" + getMes() + "/" + getAnioNaci(), formatoFecha); //Pasamos los datos ungresados de la fecha con el formato dd/mm/año
        Period tiempoTranscu = Period.between(nacimiento, actual); //Calcula el tiempo trancurrido, entre fechas.
        return tiempoTranscu.getYears();
    }

    public int frecCardiacaMax() {
        int frecuencia = 220 - calcularEdad();
        return frecuencia;
    }

    public int intervaloPorcen(double porcentaje) {
        int intervalo = (int) (frecCardiacaMax() * (porcentaje / 100));
        return intervalo;
    }

    @Override
    public String toString() {
        String cardiaca = String.format("Usted: %s %s\ntiene una edad de: %d\ncon una frecuencia Cardiaca Máxima de: %d\nSu intervalo cardiaco en sun 50%% es de: %d\nSu intervalo cardiaco en su 85%% es de: %d", getNombre(), getApellido(), calcularEdad(), frecCardiacaMax(), intervaloPorcen(50), intervaloPorcen(85));
        return cardiaca;
    }

    public static void main(String[] args) {
        FrecuenciasCardiacas persona1 = new FrecuenciasCardiacas("Jonathan", "Herrera", 20, 01, 1999);
        System.out.println(persona1);
        FrecuenciasCardiacas persona2 = new FrecuenciasCardiacas("Darwin", "Herrera", 05, 28, 1974);
        System.out.println(persona2);
        
    }

}
