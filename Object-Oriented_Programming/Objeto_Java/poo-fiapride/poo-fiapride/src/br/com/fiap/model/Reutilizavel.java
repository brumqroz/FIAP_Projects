package br.com.fiap.model;

/**
 * Interface Reutilizavel
 *
 * Aula 9: Interfaces — contrato de comportamento.
 *
 * Define o QUE um objeto reutilizável deve fazer, não COMO.
 * Pode ser implementado por GarrafaEsportiva, GarrafaTermica,
 * e também por classes fora da hierarquia de Garrafa (ex: CantilMilitar).
 *
 * Atributos em interfaces são implicitamente public static final.
 */
public interface Reutilizavel {

    // Constantes da interface (public static final implícito)
    int CICLOS_MAXIMOS          = 365;   // máximo de ciclos de reutilização por ano
    int CICLOS_MINIMOS          = 1;
    String MATERIAL_SUSTENTAVEL = "inox";

    // Contrato: quem implementa DEVE ter estes métodos
    void higienizar();
    int getCiclosDeUso();
    String calcularImpactoAmbiental();
}
