package br.com.fiap.model;

/**
 * Classe Abstrata GarrafaBase
 *
 * Aula 6: Herança — superclasse genérica
 * Aula 7: Polimorfismo — método calcularHidratacao() na base
 * Aula 8: Classes Abstratas — GarrafaBase não pode ser instanciada diretamente.
 *         Não existe uma "garrafa genérica" no mundo real: toda garrafa é
 *         de água, de academia, térmica, etc.
 */
public abstract class GarrafaBase {

    // Atributos comuns a TODA garrafa (herdados pelas filhas)
    private String marca;
    private double capacidadeML;
    protected double conteudoAtualML;  // protected: filhas acessam diretamente
    private boolean tampada;

    // AULA 6: Construtor da superclasse — filhas chamam via super()
    public GarrafaBase(String marca, double capacidadeML) {
        this.setMarca(marca);
        this.setCapacidadeML(capacidadeML);
        this.conteudoAtualML = 0.0;
        this.tampada = false;
    }

    // AULA 7: Método concreto na mãe — comportamento padrão genérico
    public String calcularHidratacao() {
        return "Hidratação não definida para garrafa genérica.";
    }

    // AULA 8: Método ABSTRATO — todas as filhas OBRIGATORIAMENTE implementam
    public abstract void exibirTipo();

    // Métodos concretos comuns
    public void encher(double quantidade) {
        if (quantidade <= 0) { System.out.println("Erro: quantidade inválida."); return; }
        double espaco = this.capacidadeML - this.conteudoAtualML;
        if (quantidade > espaco) {
            System.out.println("Atenção: colocando apenas " + espaco + "ml.");
            this.conteudoAtualML = this.capacidadeML;
        } else {
            this.conteudoAtualML += quantidade;
            System.out.println("Enchida com " + quantidade + "ml. Total: " + this.conteudoAtualML + "ml.");
        }
    }

    public void beber(double quantidade) {
        if (quantidade <= 0) { System.out.println("Erro: quantidade inválida."); return; }
        if (this.tampada) { System.out.println("Garrafa tampada!"); return; }
        if (quantidade > this.conteudoAtualML) {
            System.out.println("Saldo insuficiente. Restam " + this.conteudoAtualML + "ml.");
            this.conteudoAtualML = 0;
        } else {
            this.conteudoAtualML -= quantidade;
            System.out.println("Bebeu " + quantidade + "ml. Restam: " + this.conteudoAtualML + "ml.");
        }
    }

    public void tampar()  { this.tampada = true;  System.out.println("Tampada."); }
    public void abrir()   { this.tampada = false; System.out.println("Aberta."); }

    // Getters
    public String getMarca()           { return this.marca; }
    public double getCapacidadeML()    { return this.capacidadeML; }
    public double getConteudoAtualML() { return this.conteudoAtualML; }
    public boolean isTampada()         { return this.tampada; }

    public void setMarca(String marca) {
        if (marca != null && !marca.trim().isEmpty()) this.marca = marca;
        else System.out.println("Erro: Marca inválida.");
    }

    private void setCapacidadeML(double cap) {
        this.capacidadeML = (cap > 0 && cap <= 3000) ? cap : 500.0;
    }
}
