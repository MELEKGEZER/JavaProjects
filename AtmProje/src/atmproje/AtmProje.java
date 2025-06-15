
package atmproje;

import java.util.Scanner;
public class AtmProje {

    
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        int bakiye=1000,miktar;
        while(bakiye>0){
        System.out.println("1-para yatir:");
         System.out.println("2-para cek:");
          System.out.println("3-bakiye sorgula:");
           System.out.println("4-cikis yap:");
         System.out.println("yapmak istediginiz secim:");
         int secim=scan.nextInt();
         
         switch(secim){
             case 1:
                  System.out.println("yatirmak istediginiz miktar:");
                  miktar=scan.nextInt();
                 bakiye=bakiye+miktar;
                 break;
                 case 2:
                  System.out.println("cekmek istediginiz miktar:");
                   miktar=scan.nextInt();
                 bakiye=bakiye-miktar;
                 break;
                 case 3:
                     System.out.println("bakiyeniz:"+bakiye);
                 break;
                 case 4:
                     System.out.println("cikis yapiliyor...");
                     break;
                     
                 default:
         }
         
    }
    
}
}