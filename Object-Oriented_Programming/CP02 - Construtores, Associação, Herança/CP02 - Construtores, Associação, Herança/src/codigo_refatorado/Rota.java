package codigo_refatorado;

public class Rota {
    
    public void planejarRota(Pacote pac, Veiculo v) {
        System.out.println("Planejando rota para o pacote: " + pac.getCodigo());
        System.out.println("Veículo escolhido: " + v.getClass().getSimpleName()); 
    }
//adicionando system.out.printin para ver o código rodando sem erro
    public void executarEntrega() {
        System.out.println("Entrega realizada com sucesso!\n");
    }
}