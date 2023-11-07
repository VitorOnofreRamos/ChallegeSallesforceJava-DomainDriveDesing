package example.org.paginas_do_site;

public class Home extends Page {
    public Home(){
        super("Página Inicial");
    }

    @Override
    public void showPage(){
        System.out.println("Bem vindo a " + getName() + "!");
    }
}
