
package tersEleman;

public class TersElemanSayisi {
    public static int tersElemanSayisi(int[] B) {
        int tersElemanSayisi = 0;
        int n = B.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (B[i] > B[j]) {
                    tersElemanSayisi++;
                }
            }
        }
        
        return tersElemanSayisi;
        
    }
    
    public static void main(String[] args) {
        int[] B = {2, 4, 1, 3, 5};
        System.out.println("Ters eleman sayısı: " + tersElemanSayisi(B));
    }
}