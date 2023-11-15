package example.org.funcoes_do_site.ProfilePackage;

import java.util.Optional;
import java.util.Scanner;

import static example.org.funcoes_do_site.ProfilePackage.Usuarios.getUsuariosCadastrados;

public class Login extends Cadastro{
    public static void realizarLogin(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--Realizando Cadastro--\n");

        System.out.println("E-mail: ");
        String loginEmail = scanner.nextLine();
        System.out.println("Senha: ");
        String loginSenha = scanner.nextLine();

        Optional<Usuarios> optional = getUsuariosCadastrados().stream()
                .filter(usuario -> usuario.getEmailCorporativo().equals(loginEmail) &
                        usuario.getSenha().equals(loginSenha)).findAny();

        if (optional.isPresent()){
            logarUsuario();
        } else {
            System.out.println("Login ou senha incorreto digite novamente");
        }
    }
    
    public static void logarUsuario(){
        System.out.println("Usuario Logado");
    }
}
