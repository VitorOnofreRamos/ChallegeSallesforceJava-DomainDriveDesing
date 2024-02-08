package example.org;

import example.org.funcoes_do_site.ProfilePackage.Cadastro;
import example.org.funcoes_do_site.ProfilePackage.Usuarios;
import example.org.paginas_do_site.Home;
import example.org.paginas_do_site.Products;
import example.org.paginas_do_site.About;
import example.org.paginas_do_site.Contacts;
import example.org.paginas_do_site.Faqs;
import example.org.paginas_do_site.Page;
import example.org.funcoes_do_site.SiteFunctions;
import example.org.funcoes_do_site.AcessibilityMenuPackage.AccessibilityMenu;
import example.org.funcoes_do_site.ChatBotPackage.Chat;

import java.util.Scanner;

import static example.org.funcoes_do_site.ProfilePackage.Login.logarUsuario;
import static example.org.funcoes_do_site.ProfilePackage.Login.realizarLogin;
import static example.org.funcoes_do_site.ProfilePackage.Usuarios.getUsuariosCadastrados;

public class Main{
    public static void main(String[] args){
        boolean usuarioLogado = false; //Usuário não logou ainda
        Page currentPage = new Home(); // Página Inicial como página padrão

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Página Inicial");
            System.out.println("2. Contatos");
            System.out.println("3. FAQs");
            System.out.println("4. Produtos");
            System.out.println("5. Sobre Nós");
            System.out.println("6. Cadastro e Login");
            System.out.println("7. Chat Bot");
            System.out.println("8. Menu de Acessibilidade");
            System.out.println("0. Sair");

            int choice = scanner.nextInt();

            switch(choice){
                case 1:
                  currentPage = new Home();
                  break;
                case 2:
                  currentPage = new Contacts();
                  break;
                case 3:
                  currentPage = new Faqs();
                  break;
                case 4:
                  currentPage = new Products();
                  break;
                case 5:
                  currentPage = new About();
                  break;
                case 6:
                  // Simulando oções de Cadastro e Login de um usuário:
                  Profile(usuarioLogado);
                  break;
                case 7:
                  //currentFunctionality = new Chat();
                  break;
                case 8:
                  //currentFunctionality = new AccessibilityMenu();
                  break;
                case 0:
                  System.out.println("Saindo do site. Adeus!");
                  return;
                default:
                  System.out.println("Opção inválida. Tente novamente.");
            }

            currentPage.showPage();
        }
    }

    public static void Profile(boolean usuarioLogado) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha uma opção de Cadastro e Login:");
            System.out.println("1. Cadastrar Conta");
            System.out.println("2. Login");
            System.out.println("3. Trocar de Conta");
            System.out.println("4. Sair da Conta");
            System.out.println("5. Listar todos os Cadastros");
            System.out.println("0. Sair do Menu de Cadatro e Login");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    //Cadastro
                    Cadastro novoUsuario = Cadastro.realizarCadastro();
                    if (novoUsuario == null) break;
                    getUsuariosCadastrados().add((Usuarios) novoUsuario);
                    if (!usuarioLogado) {
                        usuarioLogado = logarUsuario(((Usuarios) novoUsuario).getEmailCorporativo());
                    }
                    else
                        System.out.print("Você já está logado.");
                    break;
                case 2:
                    //Login
                    if (!usuarioLogado) {
                        realizarLogin();
                    }
                    else
                        System.out.print("Você já está logado.");
                    break;
                case 3:
                    //Trocar de Conta
                    if ((long) getUsuariosCadastrados().size() <= 1){
                        System.out.print("Não há outra conta cadatrada.");
                    } else if (!usuarioLogado) {
                        System.out.print("Você ainda não logou em nenhuma conta.");
                    } else {
                        usuarioLogado = false;
                        realizarLogin();
                    }
                    break;
                case 4:
                    //Sair da Conta
                    System.out.print("Saindo da conta.");
                    usuarioLogado = false;
                    break;
                case 5:
                    //Listar todos os Cadastros
                    if (getUsuariosCadastrados().isEmpty()){
                    System.out.println("Não há nenhum usuário cadastrado");
                    } else {
                        System.out.println("\nLista de usuários Cadastrados:");
                        for (Cadastro usuario : getUsuariosCadastrados()) {
                            System.out.println(usuario);
                        }
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
