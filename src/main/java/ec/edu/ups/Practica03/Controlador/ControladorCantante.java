/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.Practica03.Controlador;

import ec.edu.ups.Practica03.Vista.VistaCantante;
import ec.edu.ups.Practica03.idao.ICantanteDAO;
import ec.edu.ups.practica03.Modelo.Cantante;
import java.util.List;

/**
 *
 * @author Juan Fernandez
 */
public class ControladorCantante {
    //objetos vist
    private VistaCantante vistaCantante;
   
    //objetos modelo
    private Cantante cantante;
  
    //objetos DAO
    private ICantanteDAO cantanteDAO;
    private String valor;
  

    //Constructor

    public ControladorCantante(VistaCantante vistaCantante, Cantante cantante, ICantanteDAO cantanteDAO) {
        this.vistaCantante = vistaCantante;
        this.cantante = cantante;
        this.cantanteDAO = cantanteDAO;
    } 
    //llama al DAO para guardar un cantante
    public void registrar() {
        cantante = vistaCantante.ingresarCantante();
        cantanteDAO.create(cantante);
    }
    
    //llama al DAO para obtener un cantante por el id y luego los muestra en la vista

    public void verCantante() {
        Cantante nombre = vistaCantante.buscarCantante(valor);
        cantante = cantanteDAO.read(nombre);
        vistaCantante.verCantante(cantante);
    }

     //llama al DAO para actualizar un cantante
    public void actualizar() {
        cantante = vistaCantante.actualizarCantante(this);
        cantanteDAO.update(cantante);
    }
    
    
    //llama al DAO para eliminar un cantante
    public void eliminar() {
        cantante = vistaCantante.eliminarCantante(this);
        cantanteDAO.delete(cantante);
    }

    //llama al DAO para obtener todos los cantantes  y luego los muestra en la vista
    public void verCantantes() {
        List<Cantante> cantantes;
        cantantes = cantanteDAO.findAll();
        vistaCantante.verCantantes(cantantes);
    }

   
    
    
    
}
