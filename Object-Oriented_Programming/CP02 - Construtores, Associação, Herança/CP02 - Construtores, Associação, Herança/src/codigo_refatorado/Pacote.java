package codigo_refatorado;

public class Pacote {
    private String codigo; 
    private double peso; //num decimal
    private String status; 
//status contando como string
    public Pacote(String codigo, double peso, String status) {
        this.codigo = codigo;
        this.peso = peso;
        this.status = status;
    }

    public void atualizarStatus(String novoStatus) { 
        this.status = novoStatus;
    }

  //add getters e setters
    public String getCodigo() { return codigo; }
    public double getPeso() { return peso; }
    public String getStatus() { return status; }
}