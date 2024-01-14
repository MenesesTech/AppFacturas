package org.menesestech.appfacturas.modelo;

public class ItemFactura {

    private int cantidad;
    private Producto producto;

    public ItemFactura(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    @Override
    public String toString() {
        return producto + "\t" + cantidad + "\t" + calcularImporte();
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public float calcularImporte(){
        return this.cantidad * this.producto.getPrecio();
    }
}
