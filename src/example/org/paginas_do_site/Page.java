package example.org.paginas_do_site;

public class Page {
    private String name;

    public Page(){}

    public Page(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Page{" +
                "name='" + name + '\'' +
                '}';
    }

    public void showPage() {
        System.out.println(name);
    }
}
