
package deneme;
public class ElektrikliOtomobil extends Otomobil{
    private int sarjDurumu;
    private String akuTipi;
    
    public ElektrikliOtomobil(int sarjDurumu, String akuTipi){
        super("gri","celik");
     this.sarjDurumu=sarjDurumu;
      this.akuTipi=akuTipi;
    }
    
    public int getSarjDurumu(){
        return this.sarjDurumu;
    }
    public void setSarjDurumu(int sarjDurumu){
        this.sarjDurumu=sarjDurumu;
     
    }
    public String getAkuTipi(){
        return this.akuTipi;
    }
    public void setAkuTipi(String akuTipi){
        this.akuTipi=akuTipi;
    
    }
}
