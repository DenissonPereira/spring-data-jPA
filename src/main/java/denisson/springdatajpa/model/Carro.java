package denisson.springdatajpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Carro {
    
    @Id
    @GeneratedValue
    private Long id;
    private String marca;
    private String modelo;
    private int ano;
    private String cor;
    private double preco;
    private int kilometragem;
    private String tipo;
    private String motor;
    private String transmissao;
    private String descricao;

    public Carro() {
        super();
    }

    public Carro(Long id, String marca, String modelo, int ano, String cor, double preco, int kilometragem, String tipo, String motor, String transmissao, String descricao){
        super();
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.preco = preco;
        this.kilometragem = kilometragem;
        this.tipo = tipo;
        this.motor = motor;
        this.transmissao = transmissao;
        this.descricao = descricao;
    }

    public Carro(String marca, String modelo, int ano, String cor, double preco, int kilometragem, String tipo, String motor, String transmissao, String descricao){
        super();
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.preco = preco;
        this.kilometragem = kilometragem;
        this.tipo = tipo;
        this.motor = motor;
        this.transmissao = transmissao;
        this.descricao = descricao;
    }



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getKilometragem() {
        return kilometragem;
    }
    public void setKilometragem(int kilometragem) {
        this.kilometragem = kilometragem;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getMotor() {
        return motor;
    }
    public void setMotor(String motor) {
        this.motor = motor;
    }
    public String getTransmissao() {
        return transmissao;
    }
    public void setTransmissao(String transmissao) {
        this.transmissao = transmissao;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
