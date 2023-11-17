package example.org.funcoes_do_site.ProfilePackage;

import java.util.Optional;
import java.util.Scanner;

import static example.org.funcoes_do_site.ProfilePackage.Usuarios.getUsuariosCadastrados;

public class Login extends Cadastro{
    public static void realizarLogin(){
        Scanner scanner = new Scanner(System.in);

        if (getUsuariosCadastrados().isEmpty()){
            System.out.println("\nNão há nenhum usuário cadastrado ainda.\n");
        /*} else if (usuarioLogado) {
            System.out.println("\nJá existe um usuário logado no momento.\n");*/
        } else {
            System.out.println("\n--Realizando Cadastro--\n");

            System.out.println("E-mail: ");
            String loginEmail = scanner.nextLine();
            System.out.println("Senha: ");
            String loginSenha = scanner.nextLine();

            Optional<Usuarios> optional = getUsuariosCadastrados().stream()
                    .filter(usuario -> usuario.getEmailCorporativo().equals(loginEmail) &
                            usuario.getSenha().equals(loginSenha)).findAny();

            if (optional.isPresent()) {
                logarUsuario(loginEmail);
            } else {
                System.out.println("Login ou senha incorreto(s)! Tente novamente.");
            }
        }
    }
    
    public static boolean logarUsuario(String email){
        String nomeUsuario;
        Optional<Usuarios> usuarioEncontrado = getUsuariosCadastrados().stream()
                        .filter(u -> u.getEmailCorporativo().equals(email)).findFirst();

        if (usuarioEncontrado.isPresent()){
            nomeUsuario = usuarioEncontrado.get().getNome();
            System.out.println("Bem vindo " + nomeUsuario + "!");
        }

        return true;
    }
}
