package example.org.funcoes_do_site.ProfilePackage;

import java.util.ArrayList;

public class Usuarios extends Cadastro {
    private String nome;
    private String sobrenome;
    private String cargo;
    private String emailCorporativo;
    private String telefone;
    private String empresa;
    private String tamanhoDaEmpresa;
    private String paisRegiao;
    private String idioma;
    private String senha;
    private static ArrayList<Usuarios> usuariosCadastrados = new ArrayList<>();

    public Usuarios() {
    }

    public Usuarios(String nome, String sobrenome, String cargo, String emailCorporativo, String telefone, String empresa, String tamanhoDaEmpresa, String paisRegiao, String idioma, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cargo = cargo;
        this.emailCorporativo = emailCorporativo;
        this.telefone = telefone;
        this.empresa = empresa;
        this.tamanhoDaEmpresa = tamanhoDaEmpresa;
        this.paisRegiao = paisRegiao;
        this.idioma = idioma;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmailCorporativo() {
        return emailCorporativo;
    }

    public void setEmailCorporativo(String emailCorporativo) {
        this.emailCorporativo = emailCorporativo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTamanhoDaEmpresa() {
        return tamanhoDaEmpresa;
    }

    public void setTamanhoDaEmpresa(String tamanhoDaEmpresa) {
        this.tamanhoDaEmpresa = tamanhoDaEmpresa;
    }

    public String getPaisRegiao() {
        return paisRegiao;
    }

    public void setPaisRegiao(String paisRegiao) {
        this.paisRegiao = paisRegiao;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static ArrayList<Usuarios> getUsuariosCadastrados() {
        return usuariosCadastrados;
    }

    public static void setUsuariosCadastrados(ArrayList<Usuarios> usuariosCadastrados) {
        Usuarios.usuariosCadastrados = usuariosCadastrados;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", emailCorporativo='" + emailCorporativo + '\'' +
                ", telefone='" + telefone + '\'' +
                ", empresa='" + empresa + '\'' +
                ", tamanhoDaEmpresa='" + tamanhoDaEmpresa + '\'' +
                ", paisRegiao='" + paisRegiao + '\'' +
                ", idioma='" + idioma + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
