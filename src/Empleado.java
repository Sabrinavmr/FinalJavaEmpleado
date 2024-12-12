import java.util.ArrayList;

public class Empleado {

    private String nombreEmpleado;
    private Long dni;
    private double sueldoBasico;
    private ArrayList<BonoSueldo> bonos;

    public Empleado(String nombreEmpleado, Long dni, double sueldoBasico, ArrayList<BonoSueldo> bonos) {
        this.nombreEmpleado = nombreEmpleado;
        this.dni = dni;
        this.sueldoBasico = sueldoBasico;
        this.bonos = bonos;
    }

    public Empleado() {

    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public ArrayList<BonoSueldo> getBonos() {
        return bonos;
    }

    public void setBonos(ArrayList<BonoSueldo> bonos) {
        this.bonos = bonos;
    }
}
