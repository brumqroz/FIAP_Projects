package codigo_refatorado;

public abstract class Veiculo {
    private String placa; 
    private double capacidade; 

    public Veiculo(String placa, double capacidade) {
        this.placa = placa;
        this.capacidade = capacidade;
    }

 
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public double getCapacidade() { return capacidade; }
    public void setCapacidade(double capacidade) { this.capacidade = capacidade; }
}