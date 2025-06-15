
package cokboyutlu;

import java.util.Scanner;


public class CokBoyutlu {

    public static void main(String[] args) {
        int liste[][]= new int[3][2];
        Scanner scan= new Scanner(System.in);
        for(int i=0; i<3;i++){
            for(int j=0; j<2;j++){
            System.out.print("sayi girin:");
            liste[i][j]=scan.nextInt();
        }
        }
        
        for(int i=0; i<3;i++){
            for(int j=0; j<2;j++){
                
             System.out.print(liste[i][j]+" "); 
            }
            System.out.println(); 
    }
  
}
}