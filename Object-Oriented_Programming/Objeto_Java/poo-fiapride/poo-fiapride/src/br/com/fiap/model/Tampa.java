package br.com.fiap.model;

/**
 * Classe Tampa
 *
 * Aula 5: Associação — Garrafa TEM UMA Tampa
 */
public class Tampa {

    private String tipo;       // rosca, pressão, bico
    private String material;
    private boolean instalada;

    public Tampa(String tipo, String material) {
        this.tipo = tipo;
        this.material = material;
        this.instalada = false;
        System.out.println("Tampa do tipo '" + this.tipo + "' criada.");
    }

    public void instalar() {
        this.instalada = true;
        System.out.println("Tampa instalada na garrafa.");
    }

    public void remover() {
        this.instalada = false;
        System.out.println("Tampa removida da garrafa.");
    }

    public String getTipo()      { return this.tipo; }
    public String getMaterial()  { return this.material; }
    public boolean isInstalada() { return this.instalada; }
}
