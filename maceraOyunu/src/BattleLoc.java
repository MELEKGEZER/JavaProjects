import java.util.Random;

//BattleLoc sınıfı, savaş alanlarını temsil eden soyut bir sınıftır.
//Bu sınıf, oyuncunun canavarlarla savaştığı ve ödüller kazandığı özel bir konum türünü tanımlar.
public abstract class BattleLoc extends Location {
    protected Obstacle obstacle; // Savaş alanındaki canavarı temsil eden değişken
   protected String award; // Savaş sonrası kazanılacak ödülün adını tutan değişken
    public Random random = new Random();


    public BattleLoc(Player player, String name, Obstacle obstacle, String award) {
        super(player);
        this.name=name;
        this.obstacle =obstacle ;
        this.award = award;
    }


    //BattleLoc sınıfının üzerine yazılmış olan soyut metot.
    //Bu metot, savaş alanındaki olayları işler ve savaşın sonucunu belirler.
    @Override
    public boolean getLocation() {
        int obsNumber = obstacle.Count();
        System.out.println("Şu an burdasiniz : " + this.getName());
        System.out.println("Dikkatli ol, burada " + obsNumber + " tane " + obstacle.getName() + " yasiyor.");
        System.out.print("Savasmak icin <S> harfine bas, Kacmak için <K> harfine bas : ");
        String selectBattle = scan.nextLine().toUpperCase();
        if (selectBattle.equals("S") && combat(obsNumber)) {
            System.out.println(this.getName() + " bolgesinin tum dusmanlari oldurdunuz.");
            if(this.award.equals("Food") && player.getInventory().isFood()==false){
               System.out.println(this.award+ "Kazandiniz");  
               player.getInventory().setFood(true);
            }else if(this.award.equals("Water") && player.getInventory().isWater()==false){
               System.out.println(this.award+ "Kazandiniz");  
               player.getInventory().setWater(true);
                
            }else if(this.award.equals("FireWood") && player.getInventory().isFireWood()==false){
               System.out.println(this.award+ "Kazandiniz");  
               player.getInventory().setFireWood(true);
            }
            return true;
        }
        if(player.getHealth()<=9){
            
          System.out.println("Oldunuz..");  
          return false;
        }
    
    return true;
    }

    // Oyuncunun canavalarla savaştığı metot
    public boolean combat(int obsCount) {
         int defObsHealth = obstacle.getHealth();
        for (int i = 1; i <= obsCount; i++) {
            playerStats();
            monsterStats(i);

            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println();
                System.out.print("<V>ur veya <K>ac : ");
                String selectCombat =scan.nextLine().toUpperCase();

                if (selectCombat.equals("V")) {
                    
                        System.out.println(this.getPlayer().getName() + " vurdu.");
                        this.obstacle.setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                        if(obstacle.getHealth()>0){
                            
                        System.out.println();
                        System.out.println(this.getObstacle().getName() + " size vurdu.");
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - (obstacle.getDamage()-player.getInventory().getArmor()));
                        afterHit();
                        }
                    }else{
                    return false;

                    }
                }
            if(obstacle.getHealth()< player.getHealth()){
                System.out.println("Dusmani yendiniz.");
                System.out.println(this.getObstacle().getAwardMoney() + " para kazandınız.");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAwardMoney());
                System.out.println("Guncel Paraniz : " + this.getPlayer().getMoney());
                obstacle.setHealth(defObsHealth);
            }else{
                return false;   
            }
            System.out.println("------------");
        }
        return true;
    }
           
    //Her vuruş sonrasında ekrana canavar ve oyuncunun güncel sağlık durumlarını yazdıran metot.

    public void afterHit() {
        System.out.println("Caniniz : " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " cani : " + this.getObstacle().getHealth());
        System.out.println("------------");
    }


    //Oyuncunun genel istatiklerini ekrana yazdıran metot.
    public void playerStats() {
        System.out.println("Oyuncu degerleri : ");
        System.out.println("------------");
        System.out.println("Saglik : " + this.getPlayer().getHealth());
        System.out.println("Toplam Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Para : " + this.getPlayer().getMoney());
        if(player.getInventory().getDamage()>0){
         System.out.println("Silah : " + this.getPlayer().getInventory().getwName());   
        }
        if(player.getInventory().getArmor()>0){
         System.out.println("Zirh : " + this.getPlayer().getInventory().getaName());   
        }
    }

    // Canavarın genel özelliklerini ekrana yazdıran metot.

    public void monsterStats(int i) {
        System.out.println(i + ". " + this.getObstacle().getName() + " Degerleri");
        System.out.println("-------------------");
        System.out.println("Saglik : " + this.getObstacle().getHealth());
        System.out.println("Hasar : " + this.getObstacle().getDamage());
        System.out.println("Para Odulu : " + this.getObstacle().getAwardMoney());
    }



    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }


}

