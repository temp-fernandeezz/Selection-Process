import java.util.*;

public class ProcessoSeletivoMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int qtd = sc.hasNextInt() ? sc.nextInt() : 0;

        final double SALARIO_BASE = 2000.0;

        for (int i = 0; i < qtd; i++) {
            String nome = sc.next();
            double pretensao = sc.nextDouble();

            if (pretensao < SALARIO_BASE) {
                System.out.println("LIGAR PARA CANDIDATO");
            } else if (pretensao == SALARIO_BASE) {
                System.out.println("LIGAR, COM CONTRA PROPOSTA");
            } else {
                System.out.println("AGUARDAR RESULTADO DOS DEMAIS CANDIDATOS");
            }
        }

        sc.close();
    }
}
