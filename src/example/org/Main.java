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

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import static example.org.funcoes_do_site.ProfilePackage.Usuarios.getUsuariosCadastrados;
import static example.org.funcoes_do_site.ProfilePackage.Usuarios.usuariosCadastrados;

public class Main{
    public static void main(String[] args){
        Page currentPage = new Home(); // Página Inicial como página padrão
        SiteFunctions currentFunctionality = null; //Não Ativa Funções

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
                  Profile();
                  break;
                case 7:
                  currentFunctionality = new Chat();
                  break;
                case 8:
                  currentFunctionality = new AccessibilityMenu();
                  break;
                case 0:
                  System.out.println("Saindo do site. Adeus!");
                  return;
                default:
                  System.out.println("Opção inválida. Tente novamente.");
            }

            if (currentFunctionality != null){
                currentFunctionality.executandoFuncoes();
                currentFunctionality = null;
            } else {
                currentPage.showPage();
            }
        }
    }

    public static void Profile() {
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
                    getUsuariosCadastrados().add(novoUsuario);
                    break;
                case 2:
                    //Login
                    break;
                case 3:
                    //Trocar de Conta
                    break;
                case 4:
                    //Sair da Conta
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

    public static void Login(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--Realizando Login--\n");

        System.out.println("Digite seu E-mail Corporativo: ");
        var emailUsuario = scanner.nextLine();
        System.out.println("Digite sua Senha: ");
        var senhaUsuario = scanner.nextLine();

        Optional<Cadastro> optional = usuariosCadastrados.stream()
                .filter(usuario -> usuario.getEmailCorporativo().equals(emailUsuario) &
                        usuario.getSenha().equals(senhaUsuario)).findAny();

        if(optional.isPresent()){}
    }
}
