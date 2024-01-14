package org.menesestech.appfacturas;

import java.util.Scanner;
import org.menesestech.appfacturas.modelo.*;

public class EjemploFactura {
    public static void main(String[] args) {
        Cliente cliente  = new Cliente();
        cliente.setNif("5555-5");
        cliente.setNombre("Andres");
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una descripcion de la factura: ");
        String desc = sc.nextLine();
        Factura factura = new Factura(desc, cliente);
        
        Producto producto;
        
        System.out.println("");
        
        for (int i = 0; i < 3; i++) {
            producto = new Producto();
            System.out.println("Ingrese producto n°  "+producto.getCodigo());
            producto.setNombre(sc.nextLine());
            
            System.out.println("Ingrese el precio: ");
            producto.setPrecio(sc.nextFloat());
            
            System.out.println("Ingrese la cantidad: ");
            factura.addItemFactura(new ItemFactura(sc.nextInt(), producto));
            
            System.out.println();
            sc.nextLine();
        }
        System.out.println(factura);
    }
}
