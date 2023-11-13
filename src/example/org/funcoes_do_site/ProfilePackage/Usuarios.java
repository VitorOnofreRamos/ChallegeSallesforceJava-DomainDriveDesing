package example.org.funcoes_do_site.ProfilePackage;

import java.util.ArrayList;

public class Usuarios extends Cadastro{
    private static ArrayList<Cadastro> usuariosCadastrados = new ArrayList<>();

    public Usuarios() {
    }

    public Usuarios(String nome, String sobrenome, String cargo, String emailCorporativo, String telefone, String empresa, String tamanhoDaEmpresa, String paisRegiao, String idioma, String senha) {
        super(nome, sobrenome, cargo, emailCorporativo, telefone, empresa, tamanhoDaEmpresa, paisRegiao, idioma, senha);
    }

    public static ArrayList<Cadastro> getUsuariosCadastrados() {
        return usuariosCadastrados;
    }

    public static void setUsuariosCadastrados(ArrayList<Cadastro> usuariosCadastrados) {
        Usuarios.usuariosCadastrados = usuariosCadastrados;
    }
}
