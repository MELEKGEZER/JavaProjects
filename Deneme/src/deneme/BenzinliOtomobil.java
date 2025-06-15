
package deneme;


public class BenzinliOtomobil extends Otomobil{
   private int yakitDurumu;
   public BenzinliOtomobil(int yakitDurumu){
       super("sari","normal");
       this.yakitDurumu=yakitDurumu;
   }
   
    public int getYakitDurumu(){
        return this.yakitDurumu;
    }
    public void setYakitDurumu(int yakitMiktari){
        this.yakitDurumu=yakitMiktari;
    }

  
}
