package src.JavaDIO.ProjetosEExercicios;

import java.util.concurrent.ThreadLocalRandom;
import java.math.*;

// TODO: 11/10/2022
//  Vamos imaginar que em um processo seletivo, existe o valor base salarial de R$ 2.000,00 e o salário pretentido pelo candidato. Vamos elaborar um controle de fluxo onde:
//  Se o valor salário base, for maior que valor salário pretentido, imprima : LIGAR PARA O CANDIDATO;
//  Senão, Se o valor salário base for igual ao valor salário pretentido, imprima : LIGAR PARA O CANDIDATO, COM CONTRA PROPOSTA;
//  Senão imprima: AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS.


public class ProjetoValidacao {
    public static void main(String[] args) {
        System.out.println("~Processo seletivo~\n\n");

        selecionaCandidato();


         imprimirSelecionados();
    }

    static void imprimirSelecionados() {
        //Informando o indice do elemento
        String[] candidatos = {"FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO"};
        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato n° " + (indice + 1) + " é o " + candidatos[indice]);
        }

//        //USANDO FOREACH
//        for (String candidato : candidatos) {
//            System.out.println("O candidato selecionado foi: " + candidato);
//        }
    }


    static void selecionaCandidato() {

        //TODO:Foi solicitado, que nosso sistema garanta que, diante das inúmeras candidaturas sejam selecionados apenas no máximo,
        // 5 candidatos para entrevista, onde o salário pretendido seja menor ou igual ao salário base.

        String[] candidatos = {"FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO", "MÔNICA", "FABRÍCIO", "MIRELA", "DANIELA", "JORGE"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        int nmrSelecionados = 0; // Imprimir o numero de candidatos selecionados

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String canditato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido(); //VALOR PRETENDIDO É O VALOR DO SALÁRIO QUE FOI GERADO ALEATORIAMENTE

            System.out.println("O candidato (a) " + canditato + " solicitou esse valor de salário: R$" + salarioPretendido);

            if (salarioPretendido <= salarioBase) {
                System.out.println("O candidato " + canditato + " foi selecionado para a vaga");
                candidatosSelecionados++;
                nmrSelecionados++;

            }
            if(salarioPretendido > salarioBase){
                System.out.println("O candidato " + canditato + " NÃO foi selecionado para a vaga");

            }       



            candidatoAtual++;
        }
        System.out.println(nmrSelecionados + " candidatos selecionados.");

    }

    static double valorPretendido() {
        double valorAleatorio = ThreadLocalRandom.current().nextDouble(1800, 2200);
        BigDecimal valorFormatado = new BigDecimal(valorAleatorio).setScale(2, RoundingMode.HALF_UP);
        return valorFormatado.doubleValue();
    }

    static void analisarCandidato(double ValorPretendido) {
        double valorBaseSalarial = 2000.00;

        if (valorBaseSalarial > ValorPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (valorBaseSalarial == ValorPretendido) {
            System.out.println("lIGAR PARA O CANDIDATO, COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }

}
