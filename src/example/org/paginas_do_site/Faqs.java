package example.org.paginas_do_site;

public class Faqs extends Page {
    public Faqs(){
        super("Faqs");
    }

    @Override
    public void showPage(){
        System.out.println(getName());
    }
}
