package br.com.fiapride.main;

import br.com.fiapride.model.Veiculo;

public class Principal {

    public static void main(String[] args) {
        
    	//Classe corrigida e em PascalCase.
        Veiculo v1 = new Veiculo();
        
        //Dados sem interferência externa (privados (-)).
        v1.setProprietario("Carlos");
        v1.setPlaca("ABC-1234");
        
        //Valor negativo será bloqueado por "Erro".
        v1.setCombustivel(-10);
        
        //Execução dos métodos de ação.
        v1.adicionarCombustivel(50);
        v1.gastarCombustivel(100);
        
        //Getters com a leitura dos dados.
        System.out.println("Dono: " + v1.getProprietario() + " | Placa: " + v1.getPlaca() + " | Gasolina: " + v1.getCombustivel());
    }
}