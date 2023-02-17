package src;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ControleCandidato {
    public static void main(String[] args) {
        String[] candidatos = {
                "Felipe",
                "Marcia",
                "Julia",
                "Paulo",
                "Mônica"
        };
        for (String candidato:candidatos)
            entrandoEmContato(candidato);
    }

    static void entrandoEmContato(String candidato){
        var tentativasRealiadas = 1;
        var continuartentando = true;
        var atendeu = false;

        do {
            atendeu = atender();
            continuartentando = !atendeu;

            if(continuartentando)
                tentativasRealiadas++;
            else System.out.println("Contato realizado com sucesso");
        }while(continuartentando && tentativasRealiadas<3);

        if (atendeu)
            System.out.println("Conseguimos contato com "+candidato+ " na "+tentativasRealiadas+ " tentativa");
        else
            System.out.println("Não conseguimos contato com "+candidato+", número máximo de tentaivas "+tentativasRealiadas+" realizadas" );

    }

    static boolean atender(){
        return new Random().nextInt(3) == 1;
    }
    static void imprimirSelecionados(){
        String[] candidatos = {
                "Felipe",
                "Marcia",
                "Julia",
                "Paulo",
                "Mônica"
        };

        for(String candidato: candidatos)
            System.out.println("O candidato selecionado foi "+ candidato);
    }

    static void selecaoCandidatos(){
        String[] candidatos = {
                "Felipe",
                "Marcia",
                "Julia",
                "Paulo",
                "Mônica"
        };

        var salarioBase = 2000.0;
        var candidatosSelecionados = 0;
        var candidatoAtual = 0;

        while(candidatosSelecionados < 5 && candidatoAtual<candidatos.length){
            var candidato = candidatos[candidatoAtual];
            var salarioPretendido = valorPretendido();

            System.out.println("O canditato "+candidato+" Solicitou  este valor de salário "
            +salarioPretendido);

            if(salarioBase>= salarioPretendido){
                System.out.println("O canditato "+candidato+" foi selecionado para a vaga");
                candidatosSelecionados++;
            }

            candidatoAtual++;
        }
    }

    static void analisarCandidato(double salarioPretendido){
        var salarioBase = 2000.0;
        if(salarioBase>salarioPretendido){
            System.out.println("Ligar para o candidato");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contra proposta");
        }else {
            System.out.println("Aguardando resultado dos demais candidatos");
        }
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }
}
