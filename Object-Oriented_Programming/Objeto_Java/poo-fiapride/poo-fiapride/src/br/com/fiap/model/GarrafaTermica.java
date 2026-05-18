package br.com.fiap.model;

/**
 * Classe GarrafaTermica
 *
 * Aula 6: extends GarrafaBase
 * Aula 7: @Override calcularHidratacao()
 * Aula 8: implementa exibirTipo()
 * Aula 9: implements Reutilizavel
 */
public class GarrafaTermica extends GarrafaBase implements Reutilizavel {

    private int horasDeIsolamento;
    private double temperaturaAtual;
    private int ciclosDeUso;

    public GarrafaTermica(String marca, double capacidadeML, int horasDeIsolamento) {
        super(marca, capacidadeML);
        this.horasDeIsolamento = horasDeIsolamento;
        this.temperaturaAtual = 25.0;
        this.ciclosDeUso = 0;
    }

    // AULA 8
    @Override
    public void exibirTipo() {
        System.out.println("Sou uma Garrafa Térmica — mantenho temperatura por "
                + this.horasDeIsolamento + "h.");
    }

    // AULA 7
    @Override
    public String calcularHidratacao() {
        String estado = this.temperaturaAtual <= 10 ? "gelada" : "quente";
        return String.format("Hidratação térmica: líquido %s (%.1f°C), %.0f ml.",
                estado, this.temperaturaAtual, this.conteudoAtualML);
    }

    public void definirTemperatura(double temp) {
        this.temperaturaAtual = temp;
        System.out.println("Temperatura definida: " + temp + "°C.");
    }

    // AULA 9
    @Override
    public void higienizar() {
        this.ciclosDeUso++;
        System.out.println("Garrafa térmica higienizada. Ciclo nº " + this.ciclosDeUso + ".");
    }

    @Override
    public int getCiclosDeUso() { return this.ciclosDeUso; }

    @Override
    public String calcularImpactoAmbiental() {
        double litrosEconomizados = this.ciclosDeUso * 0.5;
        return String.format("Economia estimada: %.1f litros de plástico descartável evitados.",
                litrosEconomizados);
    }

    public double getTemperaturaAtual()  { return this.temperaturaAtual; }
    public int getHorasDeIsolamento()    { return this.horasDeIsolamento; }
}
