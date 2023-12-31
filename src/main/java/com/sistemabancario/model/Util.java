package com.sistemabancario.model;

/**
 * Classe com funções de uso geral.
 * @author Manoel Campos da Silva Filho
 */
public final class Util {
    /**
     * Construtor privado para evitar que a classe seja instanciada,
     * uma vez que ela não possui atributos e todos os métodos são estáticos.
     */
    private Util(){/**/}

    /**
     * Calcula um dígito verificador utilizando o algoritmo <a href="https://pt.wikipedia.org/wiki/Dígito_verificador#Módulo_11">modulo 11</a>.
     * @param numero número para calcular o dígito verificador (em formato como, por exemplo, dddd-d)
     * @return o dígito verificador calculado
     */
    public static String calculaDigitoModulo11(final String numero) {
        /*Localiza a posição do hífen no número.
        * O total de algarimos a serem usados para calcular o dígito
        * verificador será o valor que representa a posição do hífen.*/
        final int posHifen = numero.indexOf('-');
        return calculaDigitoModulo11(numero, posHifen);
    }

    /**
     * Calcula um dígito verificador utilizando o algoritmo <a href="https://pt.wikipedia.org/wiki/Dígito_verificador#Módulo_11">modulo 11</a>.
     * @param numero número para calcular o dígito verificador
     * @param totalAlgarismos número de algarismos a serem usados para calcular o dígito verificador
     * @return o dígito verificador calculado
     */
    public static String calculaDigitoModulo11(final String numero, final int totalAlgarismos) {
        //Copia os algarismos até o total indicado
        final char[] vetor = numero.substring(0, totalAlgarismos).toCharArray();

        int soma = 0;
        for (int i = 0; i < vetor.length; i++) {
            //Um jeito simples de converter char pra int usando os códigos ASCII (por exemplo, o char '1' vira o número 1).
            final int algarismo = vetor[i] - 48;
            soma += (vetor.length + 1 - i) * algarismo;
        }

        final int modulo = 11;
        final Integer dig = modulo - (soma % modulo);
        return dig > 9 ? "0" : dig.toString();
    }
}
