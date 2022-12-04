package si.fri.rso.samples.firstmicroservice.lib;

public class KosaricaMetadata {

    private Integer id;

    private String imeKosarice;
    // uporabnik lahko nastavi ime kosaric
    private String imeTrgovine;
    //ime trgovine iz katere so vsi izdelki

    private String izdelek1;

    private String izdelek2;

    private String izdelek3;

    //TODO popravi da bo seznam in ne posamezni izdelki

    private String cena_izdelek1;

    private String cena_izdelek2;

    private String cena_izdelek3;
    public Integer id() {
        return id;
    }

    public void setKosaricaId(Integer id) {
        this.id = id;
    }

    public String getImeTrgovine() {
        return imeTrgovine;
    }

    public void setimeTrgovine(String ime_trgovine) {
        this.imeTrgovine = ime_trgovine;
    }

    public String getImeKosarice() {
        return imeKosarice;
    }

    public void setImeKosarice(String ime_kosarice) {
        this.imeKosarice = ime_kosarice;
    }

    public String getIzdelek1() {
        return izdelek1;
    }

    public void setIzdelek1(String izdelek1, String cena_izdelek1) {
        this.izdelek1 = izdelek1;
        this.cena_izdelek1 = cena_izdelek1;
    }

    public String getIzdelek2() {
        return izdelek2;
    }

    public void setIzdelek2(String izdelek2, String cena_izdelek2) {
        this.izdelek2 = izdelek2;
        this.cena_izdelek2 = cena_izdelek2;
    }

    public String getIzdelek3() {
        return izdelek3;
    }

    public void setIzdelek3(String izdelek3, String cena_izdelek3) {
        this.izdelek3 = izdelek3;
        this.cena_izdelek3 = cena_izdelek3;
    }

    public String getCena_izdelek1() {
        return cena_izdelek1;
    }

    public String getCena_izdelek2() {
        return cena_izdelek2;
    }

    public String getCena_izdelek3() {
        return cena_izdelek3;
    }
    //TODO do it better

}
