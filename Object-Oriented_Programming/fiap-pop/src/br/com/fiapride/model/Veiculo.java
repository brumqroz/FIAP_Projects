package br.com.fiapride.model;

public class Veiculo { //Classe refatorada utilizando PascalCase

	//Atributos corrigidos (privados (-)).
    private String proprietario;
    private String placa;
    private double nivelCombustivel;

    //Métodos para adição de combustível com validação lógica.
    public void adicionarCombustivel(double quantidade) {
        if (quantidade > 0) {
            this.nivelCombustivel += quantidade;
        }
    }

    //Método para gasto de combustível com validação de nível atual.
    public void gastarCombustivel(double quantidade) {
        if (quantidade > 0 && this.nivelCombustivel >= quantidade) {
            this.nivelCombustivel -= quantidade;
        } else {
            System.out.println("Combustível insuficiente para o gasto solicitado.");
        }
    }

    //Getters e Setters coesos. 
    public String getProprietario() { 
        return proprietario;
    }

    public void setProprietario(String proprietario) { //String, nome do proprietário.
        this.proprietario = proprietario;
    }

    public String getPlaca() { 
        return placa;
    }

    public void setPlaca(String placa) {  //String, placa com letras e números.
        this.placa = placa;
    }

    public double getCombustivel() {
        return nivelCombustivel;
    }

    public void setCombustivel(double combustivel) { //double, números não inteiros.
        if (combustivel >= 0) {
            this.nivelCombustivel = combustivel;
        } else {
            System.out.println("Erro: O valor do combustível não pode ser negativo.");
        }
    }
}