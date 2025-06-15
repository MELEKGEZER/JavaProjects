
import java.util.Random;

// Obstacle sınıfı, oyun içindeki düşman karakterlerini temsil eden bir sınıftır.
// Her bir canavarın benzersiz bir kimliği, ismi, verdiği hasar, sağlık puanı, ödül parası gibi özellikleri bulunur.
public class Obstacle {
  
    private String name; // Canavarın adını temsil eden değişken

    private int damage; // Canavarın verdiği hasarı temsil eden değişken
    private int health; // Canavarın sağlık puanını temsil eden değişken
    private int awardMoney; // Canavarın ödül parasını temsil eden değişken
    private int maxNumber;
    private int orginalHealth; // Canavarın orijinal sağlık puanını temsil eden değişken

    public Obstacle( String name, int damage, int health, int awardMoney,int maxNumber) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.orginalHealth = health;
        this.awardMoney = awardMoney;
        this.maxNumber= maxNumber;
    }
    
    public int Count(){
        Random r = new Random();
        return r.nextInt(this.maxNumber)+1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        // Sağlık puanı negatif olmaması için kontrol eklenmiştir.
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getAwardMoney() {
        return awardMoney;
    }

    public void setAwardMoney(int awardMoney) {
        this.awardMoney = awardMoney;
    }

    public int getOrginalHealth() {
        return orginalHealth;
    }

    public void setOrginalHealth(int orginalHealth) {
        this.orginalHealth = orginalHealth;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }
}