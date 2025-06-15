
package deneme;

public class Deneme {

    public static void main(String[] args) {
       Otomobil otomobil1= new Otomobil("yesil","celik");
     //  otomobil1.setRenk("yesil");
      // otomobil1.setCant("Celik");
        System.out.println(otomobil1.getRenk() +","+ otomobil1.getCant()+","+ otomobil1.getModel()+","+ otomobil1.getEn());
       Otomobil otomobil2= new Otomobil("kirmizi","normal");
      // otomobil2.setRenk("kirmizi");
      // otomobil2.setCant("normal");
        System.out.println(otomobil2.getRenk ()+","+ otomobil2.getCant()+","+ otomobil1.getModel());
        Otomobil otomobil3= new Otomobil();
        System.out.println(otomobil3.getRenk ()+","+ otomobil3.getCant());
        //kalıtım
        BenzinliOtomobil benzinliotomobil= new BenzinliOtomobil(57);
        System.out.println(benzinliotomobil.getRenk()+","+benzinliotomobil.getCant()+","+benzinliotomobil.getYakitDurumu());
        ElektrikliOtomobil elektrikliotomobil= new ElektrikliOtomobil(20,"A-Tipi");
        System.out.println(elektrikliotomobil.getRenk()+","+ elektrikliotomobil.getCant()+","+ elektrikliotomobil.getSarjDurumu()+","+elektrikliotomobil.getAkuTipi());
        
        
    }  
} 
