/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code.imobiliaria.modelo;

import java.util.Date;

public class Propriedade {

    private int id;
    private int proprietarioId;
    private String nome;
    private String endereco;
    private double preco;
    private String tipo;
    private String descricao;
    private String regiao;
    private Date dataCadastro;
    private int enderecoId; // ID do endereço associado à propriedade

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(int enderecoId) {
        this.enderecoId = enderecoId;
    }

    public int getProprietarioId() {
        return proprietarioId;
    }

    public void setProprietarioId(int proprietarioId) {
        this.proprietarioId = getId();
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

        @Override
    public String toString() {
        return "Propriedade [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", preco=" + preco + ", tipo=" + tipo + ", descricao=" + descricao + ", dataCadastro=" + dataCadastro + ", enderecoId=" + enderecoId + "]";
    }
}
