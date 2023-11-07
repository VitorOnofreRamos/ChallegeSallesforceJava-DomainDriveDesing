package example.org;

import example.org.paginas_do_site.Home;
import example.org.paginas_do_site.Products;
import example.org.paginas_do_site.About;
import example.org.paginas_do_site.Contacts;
import example.org.paginas_do_site.Faqs;
import example.org.paginas_do_site.Page;
import example.org.funcoes_do_site.SiteFunctions;
import example.org.funcoes_do_site.ProfilePackage.Login;
import example.org.funcoes_do_site.AcessibilityMenuPackage.AccessibilityMenu;
import example.org.funcoes_do_site.ChatBotPackage.Chat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        class Site {
            private Page currentPage;
            private SiteFunctions currentFunctionality;

            public Site() {
                currentPage = new Home(); // Página Inicial como página padrão
                currentFunctionality = null;
            }

            public void run() {
                Scanner scanner = new Scanner(System.in);

                while (true) {
                    System.out.println("\nEscolha uma opção:");
                    System.out.println("1. Página Inicial");
                    System.out.println("2. Contatos");
                    System.out.println("3. FAQs");
                    System.out.println("4. Produtos");
                    System.out.println("5. Sobre Nós");
                    System.out.println("6. Login");
                    System.out.println("7. Chat Bot");
                    System.out.println("8. Menu de Acessibilidade");
                    System.out.println("0. Sair");

                    int choice = scanner.nextInt();
                    System.out.println();

                    switch (choice) {
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
                            currentFunctionality = new Login();
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

                    if (currentFunctionality != null) {
                        currentFunctionality.executandoFuncoes();
                        currentFunctionality = null;
                    } else {
                        currentPage.showPage();
                    }
                }
            }
        }
        Site site = new Site();
        site.run();
    }
}
