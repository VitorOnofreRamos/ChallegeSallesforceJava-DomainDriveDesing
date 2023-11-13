package example.org.paginas_do_site;

import example.org.funcoes_do_site.SiteFunctions;

public class Page {
    private String name;
    private Page currentPage;
    private SiteFunctions currentFunctionality;

    public Page(){}

    public Page(String name, Page currentPage, SiteFunctions currentFunctionality) {
        this.name = name;
        this.currentPage = currentPage;
        this.currentFunctionality = currentFunctionality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Page getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Page currentPage) {
        this.currentPage = currentPage;
    }

    public SiteFunctions getCurrentFunctionality() {
        return currentFunctionality;
    }

    public void setCurrentFunctionality(SiteFunctions currentFunctionality) {
        this.currentFunctionality = currentFunctionality;
    }

    @Override
    public String toString() {
        return "Page{" +
                "name='" + name + '\'' +
                ", currentPage=" + currentPage +
                ", currentFunctionality=" + currentFunctionality +
                '}';
    }

    public void showPage() {
        System.out.println("Você está na página: " + name);
    }
}
