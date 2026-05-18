package br.com.fiap.model;

/**
 * Classe Garrafa — Projeto Pessoal (evolução aulas 1-5)
 *
 * Aula 1: Classes e Objetos — estrutura base
 * Aula 2: Métodos com regras de negócio
 * Aula 3: Encapsulamento (private, getters, setters com validação)
 * Aula 4: Construtor obrigatório (marca e capacidade são essenciais)
 * Aula 5: Associação — Garrafa TEM UMA Tampa
 */
public class Garrafa {

    // AULA 3: Atributos PRIVADOS
    private String marca;
    private String material;
    private String cor;
    private double capacidadeML;
    private double conteudoAtualML;
    private boolean tampada;

    // AULA 5: Associação — atributo cujo papel é "tampaUtilizada"
    private Tampa tampaUtilizada;

    // ============================
    // AULA 4: Construtores
    // ============================

    /** Construtor mínimo: marca e capacidade são obrigatórios */
    public Garrafa(String marca, double capacidadeML) {
        this.setMarca(marca);
        this.setCapacidadeML(capacidadeML);
        this.conteudoAtualML = 0.0;
        this.tampada = false;
        System.out.println("Garrafa '" + this.marca + "' criada com "
                + this.capacidadeML + "ml de capacidade.");
    }

    /** Construtor completo: usa this() para reaproveitar o construtor acima */
    public Garrafa(String marca, double capacidadeML, Tampa tampa) {
        this(marca, capacidadeML);
        this.tampaUtilizada = tampa;
        System.out.println("Tampa '" + tampa.getTipo() + "' associada.");
    }

    // ============================
    // AULA 2: Métodos de ação
    // ============================

    public void encher(double quantidade) {
        if (quantidade <= 0) {
            System.out.println("Erro: A quantidade deve ser maior que zero.");
            return;
        }
        double espaco = this.capacidadeML - this.conteudoAtualML;
        if (quantidade > espaco) {
            System.out.println("Atenção: colocando apenas " + espaco
                    + "ml (capacidade máxima).");
            this.conteudoAtualML = this.capacidadeML;
        } else {
            this.conteudoAtualML += quantidade;
            System.out.println("Enchida com " + quantidade + "ml. Total: "
                    + this.conteudoAtualML + "ml.");
        }
    }

    public void beber(double quantidade) {
        if (quantidade <= 0) {
            System.out.println("Erro: A quantidade deve ser maior que zero.");
            return;
        }
        if (this.tampada) {
            System.out.println("A garrafa está tampada! Abra antes de beber.");
            return;
        }
        if (quantidade > this.conteudoAtualML) {
            System.out.println("Não tem líquido suficiente! Restam apenas "
                    + this.conteudoAtualML + "ml.");
            this.conteudoAtualML = 0;
        } else {
            this.conteudoAtualML -= quantidade;
            System.out.println("Bebeu " + quantidade + "ml. Restam: "
                    + this.conteudoAtualML + "ml.");
        }
    }

    public void tampar() {
        this.tampada = true;
        if (this.tampaUtilizada != null) {
            this.tampaUtilizada.instalar();
        } else {
            System.out.println("Garrafa tampada.");
        }
    }

    public void abrir() {
        this.tampada = false;
        if (this.tampaUtilizada != null) {
            this.tampaUtilizada.remover();
        } else {
            System.out.println("Garrafa aberta.");
        }
    }

    public void exibirDados() {
        System.out.println("===== Garrafa =====");
        System.out.println("Marca:      " + this.marca);
        System.out.println("Material:   " + this.material);
        System.out.println("Cor:        " + this.cor);
        System.out.println("Capacidade: " + this.capacidadeML + " ml");
        System.out.println("Conteúdo:   " + this.conteudoAtualML + " ml");
        System.out.println("Tampada:    " + (this.tampada ? "Sim" : "Não"));
        if (this.tampaUtilizada != null) {
            // AULA 5: Navegando entre objetos associados
            System.out.println("Tampa:      " + this.tampaUtilizada.getTipo()
                    + " (" + this.tampaUtilizada.getMaterial() + ")");
        }
        System.out.println("===================");
    }

    // ============================
    // AULA 3: Getters públicos
    // ============================
    public String getMarca()           { return this.marca; }
    public String getMaterial()        { return this.material; }
    public String getCor()             { return this.cor; }
    public double getCapacidadeML()    { return this.capacidadeML; }
    public double getConteudoAtualML() { return this.conteudoAtualML; }
    public boolean isTampada()         { return this.tampada; }
    public Tampa getTampaUtilizada()   { return this.tampaUtilizada; }

    // ============================
    // AULA 3: Setters com validação
    // ============================
    public void setMarca(String marca) {
        if (marca != null && !marca.trim().isEmpty()) {
            this.marca = marca;
        } else {
            System.out.println("Erro: Marca inválida.");
        }
    }

    public void setMaterial(String material) { this.material = material; }
    public void setCor(String cor)           { this.cor = cor; }

    /**
     * Capacidade é IMUTÁVEL após criação (uma garrafa não muda de tamanho).
     * Por isso setCapacidadeML é PRIVADO — decisão arquitetural equivalente
     * ao setModelo() que não existe no Veiculo do FiapRide.
     */
    private void setCapacidadeML(double capacidadeML) {
        if (capacidadeML > 0 && capacidadeML <= 3000) {
            this.capacidadeML = capacidadeML;
        } else {
            System.out.println("Erro: Capacidade inválida. Usando 500ml como padrão.");
            this.capacidadeML = 500.0;
        }
    }
}
