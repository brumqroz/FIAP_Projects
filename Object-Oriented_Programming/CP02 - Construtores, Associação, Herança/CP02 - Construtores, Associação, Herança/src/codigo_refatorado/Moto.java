package codigo_refatorado;

public class Moto extends Veiculo {
    private boolean possuiBau; 

    public Moto(String placa, double capacidade, boolean possuiBau) { //bau é boolean por ser true/false
        super(placa, capacidade);
        this.possuiBau = possuiBau;
    }

    public boolean isPossuiBau() { return possuiBau; }
    public void setPossuiBau(boolean possuiBau) { this.possuiBau = possuiBau; }
}