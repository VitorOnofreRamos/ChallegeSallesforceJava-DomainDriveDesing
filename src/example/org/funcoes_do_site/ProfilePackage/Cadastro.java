package example.org.funcoes_do_site.ProfilePackage;

import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import example.org.funcoes_do_site.ProfilePackage.Usuarios;

import static example.org.funcoes_do_site.ProfilePackage.Usuarios.getUsuariosCadastrados;

public class Cadastro{
    public static Cadastro realizarCadastro(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--Realizando Cadastro--\n");

        System.out.println("Nome: ");
        String novoNome = scanner.nextLine();
        while (!novoNome.matches(".*\\S.*")){
            System.out.println("Nome inválido. Digite um nome válido: ");
            novoNome = scanner.nextLine();
        }

        System.out.println("Sobrenome: ");
        String novoSobrenome = scanner.nextLine();
        while (!novoSobrenome.matches(".*\\S.*")){
            System.out.println("Sobrenome inválido. Digite um sobrenome válido: ");
            novoSobrenome = scanner.nextLine();
        }

        System.out.println("Cargo: ");
        String novoCargo = scanner.nextLine();
        while (!novoCargo.matches(".*\\S.*")){
            System.out.println("Nome do cargo inválido. Digite um cargo válido: ");
            novoCargo = scanner.nextLine();
        }

        System.out.println("E-mail Corporativo: ");
        String novoEmailCorporativo = scanner.nextLine();
        while (!validarEmail(novoEmailCorporativo)) {
            System.out.println("E-mail inválido. Digite um e-mail válido: ");
            novoEmailCorporativo = scanner.nextLine();
        }

        System.out.println("Telefone: \n(Exemplo de número de telefone válido: +11 11 111111111)");
        String novoTelefone = scanner.nextLine();
        while (!validarTelefone(novoTelefone)) {
            System.out.println("Telefone inválido. Digite um telefone válido: \n(Exemplo de número de telefone válido: +11 11 111111111)");
            novoTelefone = scanner.nextLine();
        }

        System.out.println("Empresa: ");
        String novoEmpresa = scanner.nextLine();
        while (!novoEmpresa.matches(".*\\S.*")){
            System.out.println("Nome da Empresa Inválida. Digite um nome válido: ");
            novoEmpresa= scanner.nextLine();
        }

        System.out.println("Tamanho da Empresa: \n(Escolha uma das opções abaixo)");
        String novoTamanhoDaEmpresa = null;
        while (novoTamanhoDaEmpresa == null){
            System.out.println("1. 1 - 50 funcionários");
            System.out.println("2. 51 - 300 funcionários");
            System.out.println("3. 301 - 1000 funcionários");
            System.out.println("4. 1001 - 2000 funcionários");
            System.out.println("5. 2001+ funcionários");

            int choise = scanner.nextInt();
            scanner.nextLine();

            switch (choise) {
                case 1 -> novoTamanhoDaEmpresa = "1 - 50 funcionários";
                case 2 -> novoTamanhoDaEmpresa = "51 - 300 funcionários";
                case 3 -> novoTamanhoDaEmpresa = "301 - 1000 funcionários";
                case 4 -> novoTamanhoDaEmpresa = "1001 - 2000 funcionários";
                case 5 -> novoTamanhoDaEmpresa = "2001+ funcionários";
                default -> System.out.println("Opção inválida. Tente novamente");
            }
        }

        System.out.println("País/Região: ");
        String novoPaisRegiao = scanner.nextLine();
        while (!novoPaisRegiao.matches(".*\\S.*")){
            System.out.println("País/Região inválido. Digite uma opção válida: ");
            novoPaisRegiao = scanner.nextLine();
        }

        System.out.println("Idioma: ");
        String novoIdioma = scanner.nextLine();
        while (!novoIdioma.matches(".*\\S.*")){
            System.out.println("Idioma inválido. Digite uma opção válida: ");
            novoIdioma = scanner.nextLine();
        }

        System.out.println("Tudo certo! Agora digite uma senha de no mínimo 4 dígitos, contendo um caracter especial.");
        String novaSenha = scanner.nextLine();
        while (!validarSenha(novaSenha)) {
            System.out.println("Senha inválida. A senha deve conter no mínimo 4 caracteres, contendo um caracter especial.");
            novaSenha = scanner.nextLine();
        }

        var novoUsuario = new Usuarios(
                novoNome,
                novoSobrenome,
                novoCargo,
                novoEmailCorporativo,
                novoTelefone,
                novoEmpresa,
                novoTamanhoDaEmpresa,
                novoPaisRegiao,
                novoIdioma,
                novaSenha
        );

        System.out.println("Cadastro concluído");

        Login.logarUsuario(novoUsuario.getEmailCorporativo());

        return novoUsuario;
    }

    private static boolean validarEmail(String email) {
        Optional<Usuarios> optional = getUsuariosCadastrados().stream()
                .filter(usuario -> usuario.getEmailCorporativo().equals(email)).findAny();

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches() && optional.isEmpty();


        //return email.matches("^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$") && optional.isEmpty();


        /*if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                emailInvalido = true;
            } else {
                Optional<Usuarios> optional = getUsuariosCadastrados().stream()
                        .filter(usuario -> usuario.getEmailCorporativo().equals(email)).findAny();
                if (optional.isPresent()){
                    emailInvalido = true;
                }
            }
        }*/
        //return emailInvalido;
    }

    private static boolean validarTelefone(String telefone) {
        Optional<Usuarios> optional = getUsuariosCadastrados().stream()
                .filter(usuario -> usuario.getTelefone().equals(telefone)).findAny();

        return telefone.matches("^\\+(?:[0-9] ?){6,14}[0-9]$") && optional.isEmpty();


        /*if (telefone != null && telefone.length() > 0) {
            String expression = "^\\+(?:[0-9] ?){6,14}[0-9]$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(telefone);
            if (matcher.matches()) {
                telefoneInvalido = true;
            } else {
                Optional<Usuarios> optional = getUsuariosCadastrados().stream()
                        .filter(usuario -> usuario.getEmailCorporativo().equals(telefone)).findAny();
                if (optional.isPresent()){
                    telefoneInvalido = true;
                }
            }
        }*/
        //return telefoneInvalido;
    }

    private static boolean validarSenha(String senha) {
        // Validar senha de no mínimo 4 caracteres e 1 caracter especial
        return senha.length() >= 4 && senha.matches(".*[^a-zA-Z0-9].*");
    }
}