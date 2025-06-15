package deneme;

public class Otomobil {
    
    private String renk;
    private String cant;
    private String model="Audi";
    private int en=2;
    private int boy=3;
    //consturactor metod1
    public Otomobil(String renk, String cant){
        this.renk=renk;
        this.cant=cant;
    }
    //consturactor metod2 default otomobil3 için
    public Otomobil(){
        this.renk="mavi";
         this.cant="normal";
    }
    public void setRenk(String renk){
        this.renk=renk;
    }
    public String getRenk(){
        return this.renk;
    }
    public void setCant(String cant){
        this.cant=cant;
    }
    public String getCant(){
        return this.cant;
    }
  public String getModel(){
        return this.model;
    }
    public int getEn(){
        return this.en;
    }
    public int getBoy(){
        return this.boy;
    }
      
}
