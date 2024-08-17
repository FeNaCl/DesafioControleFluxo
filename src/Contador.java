import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador {
    public static void main(String[] args) throws Exception {
        Scanner leitura = new Scanner(System.in);
        // cores
        String RESET = "\u001B[0m";
        String CYAN = "\u001B[36m";
        String RED = "\u001B[31m";

        // inicia falso para rodar o programa
        boolean parametroValido = false;

        // fora do while para não ficar repetindo
        System.out.println(CYAN + "Desafio - Controle de Fluxo" + RESET + "\n");

        while (!parametroValido) {
            // encapsula as entradas no trycatch para a "inputmismatch" funcionar
            try {
                System.out.println(CYAN + "Digite o primeiro parâmetro: " + RESET);
                int parametroUm = leitura.nextInt();
                System.out.println(CYAN + "Digite o segundo parâmetro: " + RESET);
                int parametroDois = leitura.nextInt();

                // chama o método
                contar(parametroUm, parametroDois);
                parametroValido = true;

                // caso o input não seja um int
            } catch (InputMismatchException e) {
                System.out.println("Por favor, utilize apenas " + RED + "números inteiros." + RESET + "\n");
                leitura.next();

                // caso parametroum seja maior que parametrodois
            } catch (ParametrosInvalidosException e) {
                System.out.println(RED + "O segundo parâmetro deve ser maior que o primeiro." + RESET + "\n");
            }
        }
        leitura.close();

    }

    // método
    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        String RESET = "\u001B[0m";
        String CYAN = "\u001B[36m";

        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException();

        } else if (parametroUm < parametroDois) {
            int contagem = parametroDois - parametroUm;
            for (int i = 0; i < contagem; i++) {
                System.out.println(CYAN + "Imprimindo o número " + RESET + (i + 1));
            }
        }
    }

    // exception
    public static class ParametrosInvalidosException extends Exception {
        public ParametrosInvalidosException() {
            super("O segundo parâmetro deve ser maior que o primeiro.");
        }
    }

}
