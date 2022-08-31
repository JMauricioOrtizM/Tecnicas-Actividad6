
package com.mycompany.actividad6.diseño.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class ArrayArticulo {
    private ArrayList<Articulo> articulos;
    
    public ArrayArticulo(){
        articulos= new ArrayList<Articulo>();
        cargar();
    }
    public void adicionar(Articulo a) {
        articulos.add(a);
    }

    public Articulo obtener(int posicion) {
        return articulos.get(posicion);
    }
    
    public Articulo buscar(String pNombre) {
        for (int i = 0; i < articulos.size(); i++) {
            if (pNombre.equals(articulos.get(i).getNombre())) {
                return articulos.get(i);
            }
        }
        return null;
    }

    public int getTamaño() {
        return articulos.size();
    }
    
    public void eliminar(Articulo a) {
        articulos.remove(a);
    }

    public void cargar() {
        try {
            File archivo = new File("articulos.txt");
            if (archivo.exists()) {
                BufferedReader br = new BufferedReader(new FileReader("articulos.txt"));
                String linea;
                while ((linea = br.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(linea, ",");
                    String id = st.nextToken().trim();
                    String categoria = st.nextToken().trim();//Revisar
                    String codigo= st.nextToken().trim();
                    String nombre = st.nextToken().trim();
                    Double precioVenta = Double.parseDouble(st.nextToken().trim());
                    int stock=Integer.parseInt(st.nextToken().trim());
                    String descripcion = st.nextToken().trim();
                    String rutaImagen = st.nextToken().trim();
                    String estado = st.nextToken().trim();

                    Articulo a = new Articulo(id, categoria, codigo, nombre,precioVenta,stock, descripcion,rutaImagen, estado);
                    adicionar(a);
                }
                br.close();
            } else {
                JOptionPane.showMessageDialog(null, "EL ARCHIVO NO EXISTE....");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SE PRODUJO UN ERROR...."+e);
        }
    }
    
    public void grabar(){
        try{
            PrintWriter pw= new PrintWriter( new FileWriter("articulos.txt"));
            for(int i=0;i<getTamaño();i++){
                pw.println(obtener (i).getId()+","+obtener (i).getCategoria()+"."+
                      obtener (i).getCodigo()+","+obtener (i).getNombre()+","+
                      obtener (i).getPrecioVenta()+","+obtener (i).getStock()+","+
                      obtener (i).getDescripcion()+","+obtener (i).getRutaImagen()+","+
                      obtener (i).getEstado()+",");  
            }
            pw.close();
            JOptionPane.showMessageDialog(null, "SE GRABO CON EXITO!!!....");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "SE PRODUJO UN ERROR....","",JOptionPane.ERROR_MESSAGE);
        
        }
        }  
    
    
}
