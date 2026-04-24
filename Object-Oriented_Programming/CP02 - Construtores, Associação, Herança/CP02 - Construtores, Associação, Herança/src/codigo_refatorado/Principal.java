package codigo_refatorado;

public class Principal {
    public static void main(String[] args) {
    	
        //Criação de objetos com construtores
        Pacote pac = new Pacote("BR999", 18.5, "Pendente");
        Caminhao cam = new Caminhao("ABC1234", 1000.0, 3); 
        
        Rota rota = new Rota();
        rota.planejarRota(pac, cam);
        rota.executarEntrega();
        
        // Podemos utilizar Moto na mesma Rota
        Moto moto = new Moto("MOT5678", 50.0, true);
        rota.planejarRota(pac, moto);
        rota.executarEntrega();
    }
}