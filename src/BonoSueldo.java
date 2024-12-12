import java.util.ArrayList;

public class BonoSueldo {

    private Empleado empleado;
    private int mesLiquidacion;
    private ArrayList<ItemBono> itemsBonos;
    private double totalBono;

    public BonoSueldo(Empleado empleado, int mesLiquidacion, ArrayList<ItemBono> itemsBonos, double totalBono) {
        this.empleado = empleado;
        this.mesLiquidacion = mesLiquidacion;
        this.itemsBonos = itemsBonos;
        this.totalBono = totalBono;
    }

    public BonoSueldo() {

    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getMesLiquidacion() {
        return mesLiquidacion;
    }

    public void setMesLiquidacion(int mesLiquidacion) {
        this.mesLiquidacion = mesLiquidacion;
    }

    public ArrayList<ItemBono> getItemsBonos() {
        return itemsBonos;
    }

    public void setItemsBonos(ArrayList<ItemBono> itemsBonos) {
        this.itemsBonos = itemsBonos;
    }

    public double getTotalBono() {
        return totalBono;
    }

    public void setTotalBono(double totalBono) {
        this.totalBono = totalBono;
    }
}
