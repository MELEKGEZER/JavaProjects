
import java.util.Scanner;
public class Game {
    Player player;
    Location location;
    Scanner input= new Scanner (System.in);
   
    public void login(){
        
        System.out.println("Macera Oyununa Hos Geldiniz!");
        System.out.print("Lutfen bir isim giriniz: ");
        String playerName = input.nextLine();
        Player player = new Player (playerName);
        System.out.println(player.getName()+ " bu karanlik ve sisli adaya hos geldin!");
        player.selectChar();
        start();
    }
        public void start(){
       
        
        while(true){
            System.out.println();
            System.out.println("------Bolgeler-----");
            System.out.println();
            System.out.print("Eylem gerceklestirmek icin bir yer secin:");
            System.out.println("1- Guvenli Ev --> Burada guvendesiniz.");
            System.out.println("2-Magara --> Karsinia zombi cikabilir.");
            System.out.println("3- Orman --> Karsinia vampir cikabilir.");
            System.out.println("4-Nehir --> Karsinia ayi cikabilir..");
            System.out.println("5- Magaza --> silah veya zirh alabilirsiniz.");
            System.out.println("Gitmek istediginiz yer: ");
        int selLoc = input.nextInt();
        while (selLoc<0 || selLoc>5 ){
        System.out.println("lutfen gecerli bir seciniz: ");
        selLoc = input.nextInt();
        }

            switch(selLoc){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Cave(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);

            }
            if(location.getClass().getName().equals("SafeHouse")){
                if(player.getInventory().isFood()&& player.getInventory().isWater() &&player.getInventory().isFireWood()){
                 System.out.println("Tebrikler Oyunu Kazandiniz.");   
                 break;
                }
            }
            if(!location.getLocation()){
                System.out.println("Oyun Bitti");
                break;
            }
        }  
    }  
}
