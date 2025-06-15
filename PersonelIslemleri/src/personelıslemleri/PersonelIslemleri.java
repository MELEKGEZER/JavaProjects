package personelıslemleri;

import java.util.Scanner;

public class PersonelIslemleri {

    public static void main(String[] args) {

        Calisan furkan = new Calisan();
        furkan.setAd("Furkan");
        furkan.setSoyad("Caliskan");
        furkan.setGunSayisi(20);
        furkan.setBirim("Bilgi Islem");
        furkan.Yazdir();

        System.out.println("Maas=" + furkan.MaasHesapla());

        Yonetici Adem = new Yonetici("Adem", "Yildiz", 30);
        Adem.setSorumluBirim("Yazilim Departmani");
        Adem.Yazdir();
        int maasAdem = Adem.MaasHesapla();
        System.out.println("Maas=" + maasAdem);

        Calisan calisanlar[] = new Calisan[3];
//        calisanlar[0] = furkan;
//        calisanlar[1] = new Calisan("Ali", "Kacmaz", 30, "Tasarım");

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < calisanlar.length; i++) {
            //Yeni çalışan nesnesi oluştur ve her nesne için bilgileri al
            Calisan c = new Calisan();
            System.out.println((i + 1) + ".calisanin Adini giriniz:");
            String ad = sc.next();
            System.out.println((i + 1) + ".calisanin Soyad giriniz:");
            String soyad = sc.next();

            c.setAd(ad);
            c.setSoyad(soyad);
            c.MaasHesapla();
            calisanlar[i] = c;//c nesnesini diziye ekle            
        }

        //Diziyi yazdır:
        System.out.println("Calisan Listesi:");
        for (int i = 0; i < calisanlar.length; i++) {
            calisanlar[i].Yazdir();
        }
    }

}
