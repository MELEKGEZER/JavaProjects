
package diziler;

import java.util.Scanner;

public class Diziler {

    public static void main(String[] args) {
       // veritipi diziadı[]= new vertipi[elemansayisi];
       // veritipi[] diziadı= new vertipi[elemansayisi];
       // veritipi[] diziadi= {v1,v2,v3,,,vn};
       
       //********
       int liste[]= new int[4];
       //int[] liste={1,2,3,4};
       liste[0]=1;
       liste[1]=2;
       liste[2]=3;
       liste[3]=4;
       for(int i=0; i<liste.length;i++){
           System.out.println(liste[i]);
      }
        //*******
       int[] liste2=new int[6];
       Scanner scan= new Scanner(System.in);
       for(int i=0; i<liste2.length;i++){
           System.out.println("sayi girin:");
           liste2[i]=scan.nextInt();
       }
       System.out.println("girilen sayilar:");
       for(int i=0; i<liste2.length;i++){
           System.out.print(liste2[i]+",");
       }
    }
    
}
