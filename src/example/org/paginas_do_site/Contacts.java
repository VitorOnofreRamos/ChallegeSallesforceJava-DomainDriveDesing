package example.org.paginas_do_site;

public class Contacts extends Page {
    public Contacts(){
        super("Contatos");
    }

    @Override
    public void showPage(){
        System.out.println(getName());
    }
}
