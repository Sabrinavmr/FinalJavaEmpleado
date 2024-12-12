public class ItemBono {
    private BonoSueldo bono;
    private int codigoItem;
    private String denominacionItem;
    private boolean esDeduccion;
    private double porcentajeItem;
    private double montoItem;

    public ItemBono(BonoSueldo bono, int codigoItem, String denominacionItem, boolean esDeduccion, double porcentajeItem, double montoItem) {
        this.bono = bono;
        this.codigoItem = codigoItem;
        this.denominacionItem = denominacionItem;
        this.esDeduccion = esDeduccion;
        this.porcentajeItem = porcentajeItem;
        this.montoItem = montoItem;
    }

    public ItemBono() {

    }

    public BonoSueldo getBono() {
        return bono;
    }

    public void setBono(BonoSueldo bono) {
        this.bono = bono;
    }

    public int getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
    }

    public String getDenominacionItem() {
        return denominacionItem;
    }

    public void setDenominacionItem(String denominacionItem) {
        this.denominacionItem = denominacionItem;
    }

    public boolean isEsDeduccion() {
        return esDeduccion;
    }

    public void setEsDeduccion(boolean esDeduccion) {
        this.esDeduccion = esDeduccion;
    }

    public double getPorcentajeItem() {
        return porcentajeItem;
    }

    public void setPorcentajeItem(double porcentajeItem) {
        this.porcentajeItem = porcentajeItem;
    }

    public double getMontoItem() {
        return montoItem;
    }

    public void setMontoItem(double montoItem) {
        this.montoItem = montoItem;
    }
}
