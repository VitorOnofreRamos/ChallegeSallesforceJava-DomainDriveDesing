package example.org.funcoes_do_site.ProfilePackage;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        System.out.println("Telefone: ");
        String novoTelefone = scanner.nextLine();
        while (!validarTelefone(novoTelefone)) {
            System.out.println("Telefone inválido. Digite um telefone válido: ");
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

            switch (choise){
                case 1:
                    novoTamanhoDaEmpresa = "1 - 50 funcionários";
                    break;
                case 2:
                    novoTamanhoDaEmpresa = "51 - 300 funcionários";
                    break;
                case 3:
                    novoTamanhoDaEmpresa = "301 - 1000 funcionários";
                    break;
                case 4:
                    novoTamanhoDaEmpresa = "1001 - 2000 funcionários";
                    break;
                case 5:
                    novoTamanhoDaEmpresa = "2001+ funcionários";
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente");
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
                ""
        );

        System.out.println("Tudo certo! Agora digite uma senha de no mínimo 4 dígitos, contendo um caracter especial.");
        String novaSenha = scanner.nextLine();
        while (!validarSenha(novaSenha)) {
            System.out.println("Senha inválida. A senha deve conter no mínimo 4 caracteres, contendo um caracter especial.");
            novaSenha = scanner.nextLine();
        }
        novoUsuario.setSenha(novaSenha);

        return novoUsuario;
    }

    private static boolean validarEmail(String email) {
        boolean emailInvalido = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                emailInvalido = true;
            }
        }
        return emailInvalido;
        /*return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");*/
    }

    private static boolean validarTelefone(String telefone) {
        // Implemente a lógica de validação do telefone
        // Pode ser uma verificação de formato específico
        return telefone.matches("\\d{10,11}");
    }

    private static boolean validarSenha(String senha) {
        return senha.length() >= 4 && senha.matches(".*[^a-zA-Z0-9].*");
    }
}