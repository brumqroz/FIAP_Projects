package br.com.fiap.main;

import br.com.fiap.model.CantilMilitar;
import br.com.fiap.model.Garrafa;
import br.com.fiap.model.GarrafaBase;
import br.com.fiap.model.GarrafaEsportiva;
import br.com.fiap.model.GarrafaTermica;
import br.com.fiap.model.Reutilizavel;
import br.com.fiap.model.Tampa;

/**
 * Classe principal — demonstra a evolução das aulas 1 a 9.
 *
 * Compilar (da raiz do projeto):
 *   javac -d out src/br/com/fiap/model/*.java src/br/com/fiap/main/Main.java
 * Rodar:
 *   java -cp out br.com.fiap.main.Main
 */
public class Main {

    public static void main(String[] args) {

        // ================================================================
        // AULAS 1-4: Classes, Objetos, Métodos, Encapsulamento, Construtores
        // ================================================================
        System.out.println("══════════════════════════════════════════════");
        System.out.println("  AULAS 1-4: Garrafa base (encapsulada)");
        System.out.println("══════════════════════════════════════════════");

        Garrafa minhaGarrafa = new Garrafa("Contigo", 500.0);
        minhaGarrafa.setMaterial("Plástico");
        minhaGarrafa.setCor("Azul");

        System.out.println("\n>> Estado inicial:");
        minhaGarrafa.exibirDados();

        System.out.println("\n>> Enchendo com 300ml:");
        minhaGarrafa.encher(300.0);

        System.out.println("\n>> Tampando e tentando beber:");
        minhaGarrafa.tampar();
        minhaGarrafa.beber(100.0);

        System.out.println("\n>> Abrindo e bebendo 150ml:");
        minhaGarrafa.abrir();
        minhaGarrafa.beber(150.0);

        System.out.println("\n>> Tentando encher com 400ml (só cabe 350ml):");
        minhaGarrafa.encher(400.0);

        System.out.println("\n>> Tentando definir saldo negativo — regra de encapsulamento:");
        minhaGarrafa.encher(-50.0);  // deve ser bloqueado

        System.out.println("\n>> Estado final:");
        minhaGarrafa.exibirDados();

        // ================================================================
        // AULA 5: Associação — Garrafa TEM UMA Tampa
        // ================================================================
        System.out.println("\n══════════════════════════════════════════════");
        System.out.println("  AULA 5: Associação — Garrafa TEM UMA Tampa");
        System.out.println("══════════════════════════════════════════════");

        Tampa tampaDeBico = new Tampa("bico", "silicone");
        Garrafa garrafaComTampa = new Garrafa("Squeeze Fit", 750.0, tampaDeBico);
        garrafaComTampa.setMaterial("Alumínio");
        garrafaComTampa.setCor("Prata");
        garrafaComTampa.encher(500.0);
        garrafaComTampa.tampar();  // navega e chama tampaDeBico.instalar()
        garrafaComTampa.exibirDados();

        // Passagem por referência: alterando a tampa afeta quem a usa
        System.out.println("\n>> Consultando tipo de tampa ATRAVÉS da Garrafa: "
                + garrafaComTampa.getTampaUtilizada().getTipo());

        // ================================================================
        // AULAS 6-7: Herança e Polimorfismo
        // ================================================================
        System.out.println("\n══════════════════════════════════════════════");
        System.out.println("  AULAS 6-7: Herança e Polimorfismo");
        System.out.println("══════════════════════════════════════════════");

        GarrafaBase esportiva = new GarrafaEsportiva("Nike Hydro", 600.0, true);
        GarrafaBase termica   = new GarrafaTermica("Stanley", 1000.0, 12);

        esportiva.encher(600.0);
        termica.encher(800.0);
        ((GarrafaTermica) termica).definirTemperatura(5.0);

        // POLIMORFISMO: mesma chamada, resultados diferentes
        System.out.println("\n>> Relatório de Hidratação da Coleção:");
        GarrafaBase[] colecao = { esportiva, termica };
        for (GarrafaBase g : colecao) {
            System.out.println("Marca: " + g.getMarca());
            System.out.println(g.calcularHidratacao());  // polimorfismo em ação
            System.out.println("---");
        }

        // ================================================================
        // AULA 8: Classes Abstratas
        // ================================================================
        System.out.println("\n══════════════════════════════════════════════");
        System.out.println("  AULA 8: Classes Abstratas");
        System.out.println("══════════════════════════════════════════════");

        // A linha abaixo NÃO compila — descomente para ver o erro:
        // GarrafaBase generica = new GarrafaBase("X", 500); // ERRO!

        System.out.println(">> Identificação polimórfica de tipos:");
        for (GarrafaBase g : colecao) {
            g.exibirTipo();  // método abstrato obrigatório nas filhas
        }

        // ================================================================
        // AULA 9: Interfaces
        // ================================================================
        System.out.println("\n══════════════════════════════════════════════");
        System.out.println("  AULA 9: Interfaces — contrato Reutilizavel");
        System.out.println("══════════════════════════════════════════════");

        // CantilMilitar NÃO herda de GarrafaBase, mas implementa Reutilizavel
        CantilMilitar cantil = new CantilMilitar("inox", 800.0);

        // Polimorfismo de interface: objetos de hierarquias DIFERENTES, mesmo contrato
        Reutilizavel[] itensReutilizaveis = {
                (GarrafaEsportiva) esportiva,
                (GarrafaTermica)   termica,
                cantil
        };

        System.out.println("\n>> Higienizando todos os itens reutilizáveis:");
        for (Reutilizavel r : itensReutilizaveis) {
            r.higienizar();
            r.higienizar(); // mais um ciclo
        }

        System.out.println("\n>> Relatório de impacto ambiental:");
        for (Reutilizavel r : itensReutilizaveis) {
            System.out.println(r.calcularImpactoAmbiental());
        }

        System.out.println("\n>> Múltiplos tipos — GarrafaEsportiva:");
        System.out.println("É uma GarrafaBase?   " + (esportiva instanceof GarrafaBase));
        System.out.println("É Reutilizavel?      " + (esportiva instanceof Reutilizavel));
        System.out.println("CantilMilitar é GarrafaBase? "
                + (cantil instanceof GarrafaBase));    // false
        System.out.println("CantilMilitar é Reutilizavel? "
                + (cantil instanceof Reutilizavel));  // true

        System.out.println("\n>> Usando constante da interface:");
        System.out.println("Ciclos máximos por ano: " + Reutilizavel.CICLOS_MAXIMOS);

        System.out.println("\n✅ Demonstração completa — Aulas 1 a 9.");
    }
}
