package example.org.paginas_do_site;

public class About extends Page {
    public About(){
        super("Sobre Nós");
    }

    @Override
    public void showPage(){
        System.out.println(getName());
    }
}
