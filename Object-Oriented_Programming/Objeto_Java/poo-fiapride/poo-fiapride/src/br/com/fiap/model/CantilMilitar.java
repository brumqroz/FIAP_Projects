package br.com.fiap.model;

/**
 * Classe CantilMilitar
 *
 * Aula 9: Demonstra o poder das interfaces.
 * CantilMilitar NÃO herda de GarrafaBase (é de outra hierarquia),
 * mas TAMBÉM implementa Reutilizavel — assim como GarrafaEsportiva e GarrafaTermica.
 *
 * Isso seria impossível com herança, mas é trivial com interfaces.
 */
public class CantilMilitar implements Reutilizavel {

    private String material;
    private double volumeML;
    private int ciclosDeUso;

    public CantilMilitar(String material, double volumeML) {
        this.material = material;
        this.volumeML = volumeML;
        this.ciclosDeUso = 0;
        System.out.println("Cantil militar de " + material + " criado (" + volumeML + "ml).");
    }

    @Override
    public void higienizar() {
        this.ciclosDeUso++;
        System.out.println("Cantil militar higienizado com pastilha purificadora. Ciclo nº "
                + this.ciclosDeUso + ".");
    }

    @Override
    public int getCiclosDeUso() { return this.ciclosDeUso; }

    @Override
    public String calcularImpactoAmbiental() {
        return "Cantil militar: " + this.ciclosDeUso
                + " usos em campo — zero descartáveis gerados.";
    }

    public String getMaterial() { return this.material; }
    public double getVolumeML() { return this.volumeML; }
}
