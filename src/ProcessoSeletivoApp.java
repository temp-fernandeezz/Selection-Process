import java.util.*;
import java.text.NumberFormat;
import java.util.stream.Collectors;

public class ProcessoSeletivoApp {

    static class Candidato {
        final String nome;
        final double pretensao;

        Candidato(String nome, double pretensao) {
            if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome inválido");
            if (pretensao <= 0) throw new IllegalArgumentException("Pretensão inválida");
            this.nome = nome.trim();
            this.pretensao = pretensao;
        }
    }

    static final int LIMITE_SELECAO = 5;
    static double SALARIO_BASE = 2000.0;

    static String analisarCandidato(double pret) {
        if (pret < SALARIO_BASE) return "LIGAR PARA CANDIDATO";
        if (pret == SALARIO_BASE) return "LIGAR, COM CONTRA PROPOSTA";
        return "AGUARDAR RESULTADO DOS DEMAIS CANDIDATOS";
    }

    static List<Candidato> selecionarCandidatos(List<Candidato> todos) {
        return todos.stream()
                .filter(c -> c.pretensao <= SALARIO_BASE)
                .sorted(Comparator.comparingDouble(c -> c.pretensao))
                .limit(LIMITE_SELECAO)
                .collect(Collectors.toList());
    }

    static boolean tentarContato(Candidato c) {
        Random r = new Random();
        for (int tent = 1; tent <= 3; tent++) {
            boolean atendeu = r.nextInt(3) == 0;
            System.out.printf("Tentando contato com %s (tentativa %d)... %s%n",
                    c.nome, tent, atendeu ? "ATENDEU" : "não atendeu");
            if (atendeu) return true;
        }
        return false;
    }

    static final Locale PT_BR = new Locale("pt", "BR");
    static final NumberFormat MOEDA = NumberFormat.getCurrencyInstance(PT_BR);

    public static void main(String[] args) {
        Locale.setDefault(PT_BR);
        Scanner sc = new Scanner(System.in);
        List<Candidato> banco = new ArrayList<>();

        while (true) {
            System.out.println("\n=== Processo Seletivo ===");
            System.out.println("Salário base atual: " + MOEDA.format(SALARIO_BASE));
            System.out.println("1) Definir salário base");
            System.out.println("2) Adicionar candidato");
            System.out.println("3) Listar candidatos");
            System.out.println("4) Analisar todos");
            System.out.println("5) Selecionar (top " + LIMITE_SELECAO + ") e tentar contato");
            System.out.println("0) Sair");

            int op = lerInt(sc, "Escolha: ");
            try {
                switch (op) {
                    case 1 -> SALARIO_BASE = lerDouble(sc, "Novo salário base (ex: 2500,00): ");
                    case 2 -> {
                        String nome = lerTexto(sc, "Nome: ");
                        double pret = lerDouble(sc, "Pretensão (ex: 1800,00): ");
                        banco.add(new Candidato(nome, pret));
                        System.out.println("Candidato adicionado.");
                    }
                    case 3 -> listarCandidatos(banco);
                    case 4 -> analisarTodos(banco);
                    case 5 -> selecionarEContatar(banco);
                    case 0 -> {
                        System.out.println("Encerrado. Boa seleção!");
                        sc.close();
                        return;
                    }
                    default -> System.out.println("Opção inválida.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    static void listarCandidatos(List<Candidato> banco) {
        if (banco.isEmpty()) {
            System.out.println("Nenhum candidato cadastrado.");
            return;
        }
        for (int i = 0; i < banco.size(); i++) {
            Candidato c = banco.get(i);
            System.out.printf("%d) %s - %s%n", i + 1, c.nome, MOEDA.format(c.pretensao));
        }
    }

    static void analisarTodos(List<Candidato> banco) {
        if (banco.isEmpty()) {
            System.out.println("Nenhum candidato para analisar.");
            return;
        }
        for (Candidato c : banco) {
            System.out.printf("%s: %s%n", c.nome, analisarCandidato(c.pretensao));
        }
    }

    static void selecionarEContatar(List<Candidato> banco) {
        List<Candidato> aprovados = selecionarCandidatos(banco);
        if (aprovados.isEmpty()) {
            System.out.println("Nenhum candidato selecionado para contato.");
            return;
        }
        System.out.println("Selecionados:");
        aprovados.forEach(c -> System.out.printf("- %s (%s)%n", c.nome, MOEDA.format(c.pretensao)));

        System.out.println("\n== Tentativas de contato ==");
        for (Candidato c : aprovados) {
            boolean sucesso = tentarContato(c);
            System.out.printf("Resultado com %s: %s%n", c.nome, sucesso ? "CONTATO REALIZADO" : "NÃO CONSEGUIMOS CONTATO");
        }
    }

    static int lerInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try { return Integer.parseInt(s); }
            catch (NumberFormatException e) { System.out.println("Informe um inteiro válido."); }
        }
    }

    static double lerDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim().replace(".", "").replace(",", ".");
            try { return Double.parseDouble(s); }
            catch (NumberFormatException e) { System.out.println("Informe um valor numérico válido."); }
        }
    }

    static String lerTexto(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }
}