package org.menesestech.appfacturas.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {

    private int folio;
    private String description;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;
    private int indiceItem;
    public static final int MAX_ITEMS = 10;
    private static int ultimoFolio;

    public Factura(String description, Cliente cliente) {
        this.description = description;
        this.cliente = cliente;
        this.items = new ItemFactura[MAX_ITEMS];
        this.folio = ++ultimoFolio;
        this.fecha = new Date();
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFactura[] getItems() {
        return items;
    }

    public void setItems(ItemFactura[] items) {
        this.items = items;
    }

    public void addItemFactura(ItemFactura item) {
        if (indiceItem < MAX_ITEMS) {
            this.items[indiceItem++] = item;
        }
    }

    public float calcularTotal() {
        float total = 0.0f;
        for (ItemFactura item : this.items) {
            if (item == null) {
                continue;
            }
            total += item.calcularImporte();
        }
        return total;
    }

    public String generarDetalle() {
        StringBuilder sb = new StringBuilder("Factura N° : ");
        sb.append(folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\tNIF: ").append(cliente.getNif())
                .append("\nDescripción: ")
                .append(this.description)
                .append("\n");

        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        sb.append("Fecha Emisión: ").append(df.format(this.fecha)).append("\n").append("\n#\tNombre\t$\tCant.\tTotal\n");
        for (ItemFactura item : this.items) {
            if (item == null) {
                continue;
            }
            sb.append(item)
                    .append("\n");

        }
        sb.append("\nGran Total: ")
                .append(calcularTotal());
        return sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }
    
    
}
