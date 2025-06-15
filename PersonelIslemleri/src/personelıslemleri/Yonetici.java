package personelıslemleri;

public class Yonetici extends Personel {

    private String sorumluBirim;

    public Yonetici() {
        super();
    }

    public Yonetici(String ad, String soyad, int gunSayisi) {
        super(ad, soyad, gunSayisi);
    }

    public String getSorumluBirim() {
        return sorumluBirim;
    }

    public void setSorumluBirim(String sorumluBirim) {
        this.sorumluBirim = sorumluBirim;
    }

    public int MaasHesapla() {
        return this.getGunSayisi() * 300;
    }
}
