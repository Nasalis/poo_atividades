package aula04;

import java.util.Arrays;
import java.util.Scanner;

public class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // boolean calcula = true;
        // int soma = 0;

        // while(calcula) {
        //     System.out.println("Digite um valor");
        //     int a = scanner.nextInt(); // Stack

        //     if(a == -1) {
        //         break;
        //     }

        //     soma += a;
        // }

        // System.out.println(soma);

        System.out.println("Digite vários números");
        String line = scanner.nextLine();
        String[] tokens = line.split(" ");
        int qtd = tokens.length;
        System.out.println("Voce digitou " + qtd + " palavras");

        //somando todos
        int acc = 0;
        for(int i = 0; i < qtd; i++) {
            acc += Integer.parseInt(tokens[i]);
        }

        System.out.println("A soma dos valores digitados equivale a " + acc);

        System.out.println(Arrays.asList(tokens));

        scanner.close();
    }
}
