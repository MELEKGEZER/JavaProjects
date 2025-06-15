package personelıslemleri;

public class Personel {

    private String ad;
    private String soyad;
    private int gunSayisi;

    public Personel() {

    }

    public Personel(String ad, String soyad, int gunSayisi) {
        this.ad = ad;
        this.soyad = soyad;
        this.setGunSayisi(gunSayisi);
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public int getGunSayisi() {
        return gunSayisi;
    }

    public void setGunSayisi(int gunSayisi) {
        if (gunSayisi <= 0) {
            this.gunSayisi = 1;
        } else if (gunSayisi > 30) {
            this.gunSayisi = 30;
        } else {
            this.gunSayisi = gunSayisi;
        }
    }

    public void Yazdir() {
        System.out.print("Ad:" + this.ad + " Soyad:" + soyad + " Gun Sayisi:" + gunSayisi);
    }
}
