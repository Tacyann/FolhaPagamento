/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Tacyrose
 */
public class Cargo {
    
    private int Codigo;
    private String Nome;
    private ArrayList<Funcionario> ListaFunc;
    
    public Cargo(){
      ListaFunc =  new ArrayList();  
    }
    
    public Cargo(int Codigo, String Nome){
        this.Codigo = Codigo;
        this.Nome = Nome;
        ListaFunc =  new ArrayList(); 
        
    }

    /**
     * @return the Codigo
     */
    public int getCodigo() {
        return Codigo;
    }

    /**
     * @param Codigo the Codigo to set
     */
    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    /**
     * @return the Nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * @param Nome the Nome to set
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * @return the ListaFunc
     */
    public ArrayList<Funcionario> getListaFunc() {
        return ListaFunc;
    }

    /**
     * @param ListaFunc the ListaFunc to set
     */
    public void setListaFunc(ArrayList<Funcionario> ListaFunc) {
        this.ListaFunc = ListaFunc;
    }
    
    //Adiciona um Funcionario a minha Lista.
    public void AddFunc( Funcionario F){
        F.setCargo(this);
        ListaFunc.add(F);
    }
    
}
