package cadastro_de_filmes;

import cadastro_de_filmes.objects.Filme;
import java.util.Scanner;

public class Cadastro_de_filmes {

    static Filme[] filmes = new Filme[10];

    public static void main(String[] args) {
        int opcao = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem Vindo ao catalogo de filmes ");
        while (opcao != 6) {
            System.out.println("Digite a opção desejada");
            System.out.println("1 - Cadastrar Filme");
            System.out.println("2 - Listar Filmes");
            System.out.println("3 - Excluir Filme");
            System.out.println("4 - Buscar Filme");
            System.out.println("5 - Alterar Filme");
            System.out.println("6 - Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    CadastrarFilme();
                    break;
                case 2:
                    System.out.println("Todos os Filmes:");
                    for (int i = 0; i < filmes.length; i++) {
                        if (filmes[i] != null) {
                            System.out.println(filmes[i].ToString());
                        }
                    }
                    break;
                case 3:
                    ExcluirFilme();
                    break;
                case 4:
                    BuscarFilme();
                    break;
                case 5:
                    AlterarFilme();
                    break;
                case 6:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    public static void CadastrarFilme() {
        Scanner scanner = new Scanner(System.in);
        String Titulo;
        int Ano;
        String Diretor;
        String[] Genero = new String[10];
        int Minutos;
        System.out.println("Digite o Titulo do Filme");
        Titulo = scanner.nextLine();
        System.out.println("Digite o Ano de Lançamento do Filme");
        Ano = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o Diretor do Filme");
        Diretor = scanner.nextLine();
        int p = 0;
        int opcao = 0;
        while (p < 10) {
            System.out.println("Digite o Genero do Filme");
            Genero[p] = scanner.nextLine();
            p++;
            if (p < 10) {
                System.out.println("Deseja cadastrar mais um Genero? 1 - Sim    2 - Não");
                opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao == 2) {
                    break;
                }
            }
        }
        System.out.println("Digite o Tempo em Minutos do Filme");
        Minutos = scanner.nextInt();
        scanner.nextLine();
        System.out.println("1");
        Filme filme = new Filme(Titulo, Ano, Diretor, Minutos, Genero);
        for (int i = 0; i <= filmes.length; i++) {
            System.out.println("2");
            if (filmes.length == i) {
                System.out.println("3");
                Filme[] filmes2 = filmes;
                filmes = new Filme[filmes.length * 2];
                for (int a = 0; a < filmes2.length; a++) {
                    System.out.println("4");
                    filmes[a] = filmes2[a];
                }
            }
            if (filmes[i] == null) {
                filmes[i] = filme;
                System.out.println("O Filme " + filmes[i].ToString() + " foi cadastrado com sucesso");
                break;
            }

        }
    }

    public static void ExcluirFilme() {
        Scanner scanner = new Scanner(System.in);
        String Genero = null;
        System.out.println("Digite o Genero do Filme");
        Genero = scanner.nextLine();
        for (int i = 0; i < filmes.length; i++) {
            if (filmes[i] != null) {
                for (int a = 0; a < filmes[i].getGeneros().length; a++) {
                    if (filmes[i].getGeneros()[a].equals(Genero)) {
                        filmes[i] = null;
                        break;
                    }
                }
            }
        }
        System.out.println("Todos os filmes do genêro " + Genero + " foram excluidos com sucesso");
    }

    public static void BuscarFilme() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o Tipo de Busca");
        System.out.println("1 - Buscar por Titulo     2 - Buscar por Diretor      3 - Buscar por Ano");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        switch (opcao) {
            case 1:
                System.out.println("Digite o Titulo do Filme");
                String Titulo = scanner.nextLine();
                for (int i = 0; i < filmes.length; i++) {
                    if (filmes[i] != null) {
                        System.out.println(filmes[i].getTitulo());
                        if (filmes[i].getTitulo().equals(Titulo)) {
                            System.out.println(filmes[i].ToString());
                        }
                    }
                }
                break;
            case 2:
                System.out.println("Digite o Diretor do Filme");
                String Diretor = scanner.nextLine();
                for (int i = 0; i < filmes.length; i++) {
                    if (filmes[i] != null) {
                        if (filmes[i].getDiretor().equals(Diretor)) {
                            System.out.println(filmes[i].ToString());
                        }
                    }
                }
                break;
            case 3:
                System.out.println("digite o ano do Filme");
                int Ano = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < filmes.length; i++) {
                    if (filmes[i] != null) {
                        if (filmes[i].getAno() == Ano) {
                            System.out.println(filmes[i].ToString());
                        }
                    }
                }
                break;
            default:
                System.out.println("Dado Invalido");
        }
    }

    public static void AlterarFilme() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o Titulo");
        String Titulo = scanner.nextLine();
        System.out.println("Digite o Ano");
        int Ano = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < filmes.length; i++) {
            if (filmes[i] != null) {
                if (filmes[i].getTitulo().equals(Titulo) && filmes[i].getAno() == Ano) {
                    System.out.println("Digite o Novo Nome de Diretor");
                    String Diretor = scanner.nextLine();
                    filmes[i].setDiretor(Diretor);
                    int p = 0;
                    int opcao = 0;
                    String[] Genero = new String[10];
                    while (p < 10) {
                        System.out.println("Digite o Novo Genero do Filme");
                        Genero[p] = scanner.nextLine();
                        p++;
                        if (p < 10) {
                            System.out.println("Deseja cadastrar mais um Genero? 1 - Sim    2 - Não");
                            opcao = scanner.nextInt();
                            scanner.nextLine();

                            if (opcao == 2) {
                                break;
                            }
                        }
                    }
                    filmes[i].setGeneros(Genero);
                    System.out.println("Digite o Novo Tempo em Minutos do Filme");
                    int Minutos = scanner.nextInt();
                    scanner.nextLine();
                    filmes[i].setMinutos(Minutos);
                    System.out.println("Filme Alterado com Sucesso");
                }
            }
        }

    }
}
