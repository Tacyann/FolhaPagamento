/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 *
 * @author Tacyrose
 */
public class Funcionario {

    //Os funcionários devem ter seu nome, cpf, rg, data de nascimento, endereço, cargo e telefone;
    private Cargo cargo;
    private FolhaDePagamento folha;
    private Endereco endereco;
    private Telefone telefone;

    private String nome;
    private String cpf;
    private String rg;
    private String data_nasc;

    public Funcionario() {
        this.cargo = new Cargo();
        this.endereco = new Endereco();
        this.telefone = new Telefone();
    }

    public Funcionario(String cpf) {
        this.cpf = cpf;
        this.cargo = new Cargo();
    }

    public Funcionario(String cpf, String nome, Cargo cargo) {

        this.cpf = cpf;
        this.nome = nome;
        this.cargo = new Cargo();

    }

    /**
     * @return the cargo
     */
    public Cargo getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the telefone
     */
    public Telefone getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the data_nasc
     */
    public String getData_nasc() {
        return data_nasc;
    }

    /**
     * @param data_nasc the data_nasc to set
     */
    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public void setEndereco(String endereco, String numero, String bairro, String cep) {
        if (Objects.isNull(this.endereco)) {
            this.endereco = new Endereco();
        }
        this.endereco.setEndereco(endereco);
        this.endereco.setNumero(numero);
        this.endereco.setBairro(bairro);
        if (cep != null && !cep.isEmpty() && !cep.replace("-", "").trim().isEmpty()) {
            this.endereco.setCep(Integer.parseInt(cep.replace("-", "")));
        }
    }

    public FolhaDePagamento getFolha() {
        return folha;
    }

    public void setFolha(FolhaDePagamento folha) {
        this.folha = folha;
    }

}
