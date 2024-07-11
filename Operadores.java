public class Operadores { // Classe publica do objeto "Operadores"
    public static void main(String[] args) throws Exception { // Metodo publico

        System.out.println("Operador de atribuição: ="); //Impressão da frase string "Operador de atribuição"
        String texto = "Texto"; // Declaração da variavel de tipo "String" que recebe nome "texto" que tem seu valor como "Texto"
        System.out.println("String texto = \"Texto\";"); // Impressão da frase "String texte = "Texto" ", \"Texto\" a contrabarra serve para o programa identificar que as "" serão imprimidas tambem
        System.out.println(texto); // Impressão da variavel "texto" que carrega valor string "Texto", // Output: Texto

        System.out.println("Operador de soma: +"); //Impressão da frase string "Operador de soma"
        int soma = 1 + 1; // Declaração da variavel de tipo "INT" que recebe nome "soma" que tem seu valor como "1 + 1"
        System.out.println("int soma = 1 + 1"); // Impressão da frase string "int soma = 1 + 1"
        System.out.println(soma); // Impressão da variavel "soma" que carrega valor int "1 + 1", // Output: 2

        System.out.println("Operador de subtração: -");  //Impressão da frase string "Operador de subtração"
        int subtracao = 1 - 1; // Declaração da variavel de tipo "INT" que recebe nome "subtracao" que tem seu valor como "1 - 1"
        System.out.println("int subtracao = 1 - 1;");  // Impressão da frase string "int soma = 1 - 1"
        System.out.println(subtracao); // Impressão da variavel "subtracao" que carrega valor int "1 - 1", // Output: 0

        System.out.println("Operador de divisão: /"); //Impressão da frase string "Operador de divisão"
        int divisao = 1 / 1;  // Declaração da variavel de tipo "INT" que recebe nome "divisao" que tem seu valor como "1 / 1"
        System.out.println("int divisao = 1 / 1;"); // Impressão da frase string "int soma = 1 / 1"
        System.out.println(divisao); // Impressão da variavel "subtracao" que carrega valor int "1 / 1", // Output: 1

        System.out.println("Operador de multiplicação: *"); //Impressão da frase string "Operador de multriplicação"
        int multiplicacao = 1 * 1; // Declaração da variavel de tipo "INT" que recebe nome "multiplicacao" que tem seu valor como "1 * 1"
        System.out.println("int multiplicacao = 1 * 1;"); // Impressão da frase string "int soma = 1 * 1"
        System.out.println(multiplicacao); // Impressão da variavel "subtracao" que carrega valor int "1 * 1", // Output: 1

        System.out.println("Operador de concatenação de strings: +"); //Impressão da frase string "Operador de concatenação de strings: +"
        String concatenacao = "Texto 1 + " + "Texto 2"; // Declaração da variavel de tipo "String" que recebe nome "concatenacao" que tem seu valor como "Texto 1 + " + "Texto 2"
        System.out.println("String concatenacao = \"Texto 1 + \" + \"Texto 2\";"); // Impressão da frase string "String concatenacao = \"Texto 1 + \" + \"Texto 2\"." // texto "Texto 1 + " está sendo concatenado com "Texto 2" 
        System.out.println(concatenacao); // Impressão da variavel "concatenacao" que carrega valor string "String concatenacao = \"Texto 1 + \" + \"Texto 2\"", // Output: Texto 1 + Texto 2
    }
}