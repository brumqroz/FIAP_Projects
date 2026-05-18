package br.com.fiap.model;

/**
 * Classe GarrafaEsportiva
 *
 * Aula 6: extends GarrafaBase (É UMA GarrafaBase)
 * Aula 7: @Override calcularHidratacao() com regra específica
 * Aula 8: implementa exibirTipo() (método abstrato obrigatório)
 * Aula 9: implements Reutilizavel — mesma interface que GarrafaTermica e CantilMilitar
 */
public class GarrafaEsportiva extends GarrafaBase implements Reutilizavel {

    // Atributo exclusivo desta filha
    private boolean temCanudoEmbutido;
    private int ciclosDeUso;

    public GarrafaEsportiva(String marca, double capacidadeML, boolean temCanudoEmbutido) {
        super(marca, capacidadeML);   // AULA 6: chama construtor da mãe
        this.temCanudoEmbutido = temCanudoEmbutido;
        this.ciclosDeUso = 0;
    }

    // AULA 8: implementação obrigatória do método abstrato
    @Override
    public void exibirTipo() {
        System.out.println("Sou uma Garrafa Esportiva"
                + (this.temCanudoEmbutido ? " com canudo embutido." : "."));
    }

    // AULA 7: sobrescrita com regra de negócio própria
    @Override
    public String calcularHidratacao() {
        double percentual = (this.conteudoAtualML / this.getCapacidadeML()) * 100;
        return String.format("Hidratação esportiva: %.1f%% (%.0f ml restantes).",
                percentual, this.conteudoAtualML);
    }

    // AULA 9: contrato Reutilizavel implementado
    @Override
    public void higienizar() {
        this.ciclosDeUso++;
        System.out.println("Garrafa esportiva higienizada. Ciclo nº " + this.ciclosDeUso + ".");
    }

    @Override
    public int getCiclosDeUso() { return this.ciclosDeUso; }

    @Override
    public String calcularImpactoAmbiental() {
        return "Evitou o descarte de " + this.ciclosDeUso + " garrafa(s) descartável(is).";
    }

    public boolean isTemCanudoEmbutido() { return this.temCanudoEmbutido; }
}
