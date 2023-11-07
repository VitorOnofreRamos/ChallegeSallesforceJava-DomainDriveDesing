package example.org.funcoes_do_site.ProfilePackage;

import example.org.funcoes_do_site.SiteFunctions;

import java.util.Scanner;
public class Login extends SiteFunctions {
    @Override
    public void executandoFuncoes() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu nome de usuário: ");
        String nomeDeUsuário = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();
        System.out.println("Login bem-sucedido!");
    }
}
