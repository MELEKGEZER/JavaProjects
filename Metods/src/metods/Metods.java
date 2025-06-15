
package metods;

public class Metods {

    /***** voidli fonksiyonlar******
    public static void main(String[] args) {
     f(10);
    }
    static void f(int x){
        int sonuc=(x+5)*3;
        System.out.println("sonuc="+sonuc);
    }
*/
    /******eturnlu fonksiyonlar******
    static int f(int x){
        int r1=(x+5)*3;
        return r1;  
    }
    public static void main(String[] args) {
        int r2=f(10);
        System.out.println("sonuc="+r2);
    }
     * @param args
*/
   /*****OVERLOADİNG****
public static void main(String[] args) {
    int x= islem(3,7) ;
   System.out.println(x); 
   int y= islem(2,3,4) ;
   System.out.println(y); 
   int z=islem("melek",10);
   System.out.println(z); 
}
static int islem(int a, int b){
    return a+b;
}
static int islem(int a, int b,int c){
    return a*b*c;
  }
static int islem(String isim, int b){
   System.out.println(isim+" "+b); 
    return 0;  
}
*/
   //*****RECURSİVE(ÖZYİNELİ) FONSKİYONLAR**
    static int r(int x){
        if(x==1){
        return 1;
        }
        return x+r(x-1);
    }
      public static void main(String[] args) {
          System.out.println(r(3));
          // r(3)=3+r(2)
          // r(2)=2+r(1)
          // r(1)=1
      }  
 
}

