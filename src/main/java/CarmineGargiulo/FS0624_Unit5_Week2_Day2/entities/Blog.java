package CarmineGargiulo.FS0624_Unit5_Week2_Day2.entities;


import CarmineGargiulo.FS0624_Unit5_Week2_Day2.enums.TipoBlog;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Blog {
    private int id;
    private String titolo;
    private TipoBlog categoria;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;
    private static int count = 1;

    public Blog(String titolo, TipoBlog categoria, String contenuto, int tempoDiLettura) {
        this.id = count;
        this.titolo = titolo;
        this.categoria = categoria;
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLettura;
        count++;
    }
}
