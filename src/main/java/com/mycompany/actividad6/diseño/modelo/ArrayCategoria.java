package com.mycompany.actividad6.diseño.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class ArrayCategoria {

    private ArrayList<Categoria> categorias;

    public ArrayCategoria() {
        categorias = new ArrayList<Categoria>();
        cargar();
    }

    public void adicionar(Categoria c) {
        categorias.add(c);
    }

    public Categoria obtener(int posicion) {
        return categorias.get(posicion);
    }

    public String buscarPosicion(String pNombre) {
        for (int i = 0; i < categorias.size(); i++) {
            if (pNombre.equals(categorias.get(i).getNombre())) {
                return String.valueOf(categorias.indexOf(i));
                
            }
        }
        return null;
    }
    public Categoria buscar(String pNombre) {
        for (int i = 0; i < categorias.size(); i++) {
            if (pNombre.equals(categorias.get(i).getNombre())) {
                return categorias.get(i);
                
            }
        }
        return null;
    }

    public int getTamaño() {
        return categorias.size();
    }

    public void eliminar(Categoria c) {
        categorias.remove(c);
    }

    public void cargar() {
        try {
            File archivo = new File("categorias.txt");
            if (archivo.exists()) {
                BufferedReader br = new BufferedReader(new FileReader("categorias.txt"));
                String linea;
                while ((linea = br.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(linea, ",");
                    String id = st.nextToken().trim();
                    String nombre = st.nextToken().trim();
                    String descripcion = st.nextToken().trim();
                    String estado = st.nextToken().trim();

                    Categoria c = new Categoria(id, nombre, descripcion, estado);
                    adicionar(c);
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
            PrintWriter pw= new PrintWriter( new FileWriter("categorias.txt"));
            for(int i=0;i<getTamaño();i++){
                pw.println(obtener (i).getId()+","+
                      obtener (i).getNombre()+","+obtener (i).getDescripcion()+","+
                      obtener (i).getEstado()+",");
            }
            pw.close();
            JOptionPane.showMessageDialog(null, "SE GRABO CON EXITO!!!....");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "SE PRODUJO UN ERROR....","",JOptionPane.ERROR_MESSAGE);
        
        }
        }
        
    
    
    
    
    }


