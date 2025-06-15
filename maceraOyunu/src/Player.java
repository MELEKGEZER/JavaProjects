import java.util.Scanner;
public class Player {

    private int damage; // Oyuncunun verdiği hasarı temsil eden değişken
    private int health; // Oyuncunun sağlık puanını temsil eden değişken
    private int originalHealth; // Oyuncunun orijinal sağlık puanını temsil eden değişken
    private int money; // Oyuncunun sahip olduğu para miktarını temsil eden değişken
    private String charName; // Oyuncunun karakter adını temsil eden değişken
    private Inventory inventory; // Oyuncunun envanterini temsil eden değişken
    private String name; // Oyuncunun adını temsil eden değişken
    public Scanner scan = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory= new Inventory();
    }

    //Oyuncunun karakter seçimini gerçekleştiren metot.
    
    public void selectChar() {
        int chaMenu = chaMenu();
        switch (chaMenu) {
            case 1 -> initPlayer("Samuray",5,21,15);
            case 2 -> initPlayer("Okcu",7,18,20);
            case 3 -> initPlayer("Sovalye",8,24,5);
            default -> initPlayer("Samuray",5,21,15);
        }
        System.out.println("Karakter olusturuldu! Adi: "+getName()+ "Hasar: "+ getDamage()+ "Saglik: "+
                getHealth()+ "Para: " +getMoney());

    }
    public int chaMenu(){
         System.out.println("Lutfen oyuna baslamak icin bir karakter secin : ");
         System.out.println("1-Samuray \t Hasar : 5 \t Saglik : 21 \t Para: 15 ");
         System.out.println("2-Okcu    \t Hasar : 5 \t Saglik : 21 \t Para: 15 ");
         System.out.println("3-Sovalye \t Hasar : 5 \t Saglik : 21 \t Para: 15 ");
         System.out.println("Karakter seciniz");
         int chaID = scan.nextInt();
         
         while(chaID< 1 || chaID>3){
            System.out.println("Lutfen gecerli bir karakter seciniz"); 
            chaID = scan.nextInt();
         }
         return chaID;
    
    }


    //Oyuncunun başlangıç bilgilerini ayarlayan metot.
    public void initPlayer(String cName, int dmg, int hlthy, int mny) {
        setName(cName);
        setDamage(dmg);
        setHealth(hlthy);
        setMoney(mny);

    }

    //Oyuncunun toplam hasarını hesaplayan metot.
         public int getTotalDamage() {
             return this.getDamage()+ this.getInventory().getDamage();  

    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
      
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}
