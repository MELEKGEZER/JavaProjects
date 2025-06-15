package personelıslemleri;

public class Calisan extends Personel {

    private String birim;

    public Calisan() {

    }

    public Calisan(String ad, String soyad, int gunSayisi, String birim) {
        super(ad, soyad, gunSayisi);
        this.birim = birim;
    }

    public String getBirim() {
        return birim;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public int MaasHesapla() {
        return this.getGunSayisi() * 200;

    }

    public void Yazdir() {
        super.Yazdir();//üst sınıftaki(Personel) Yazdir çağrılıyor
        System.out.println(" Birimi:" + this.birim);
//System.out.println("Ad:"+this.getAd()+" Soyad:"+getSoyad()+" Gun Sayisi:"+getGunSayisi()+" Birimi:"+this.birim);
    }
}
