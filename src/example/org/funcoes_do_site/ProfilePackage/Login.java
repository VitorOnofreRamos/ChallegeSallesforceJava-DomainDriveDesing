package example.org.funcoes_do_site.ProfilePackage;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

import static example.org.funcoes_do_site.ProfilePackage.Usuarios.getUsuariosCadastrados;
import static example.org.funcoes_do_site.ProfilePackage.Usuarios.usuariosCadastrados;

public class Login {
    private String emailUsuario;
    private String senhaUsuario;

    public Login(){}

    public Login(String emailUsuario, String senhaUsuario) {
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    @Override
    public String toString() {
        return "Login{" +
                "emailUsuario='" + emailUsuario + '\'' +
                ", senhaUsuario='" + senhaUsuario + '\'' +
                '}';
    }

    public static Login realizarLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--Realizando Login--\n");

        System.out.println("Digite seu E-mail Corporativo: ");
        var emailUsuario = scanner.nextLine();
        System.out.println("Digite sua Senha: ");
        var senhaUsuario = scanner.nextLine();

        Optional<Cadastro> optional = getUsuariosCadastrados().stream()
                .filter(usuarios -> usuarios.getEmailCorporativo().equals(emailUsuario)&
                        usuarios.getSenha().equals(senhaUsuario)).findAny();

        if (optional.isPresent()) {
            usuarioLogado = optional;
        }
    }
}
