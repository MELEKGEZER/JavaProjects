public class SafeHouse extends NormalLoc {
    //SafeHouse sınıfı, oyuncunun güvenli ev konumunu temsil eden bir sınıftır.
    //Oyuncunun sağlığını yeniler ve oyunu kazanıp kazanmadığını kontrol eder.

    public SafeHouse(Player player) {
        super(player, "Guvenli ev");
    }



    //Güvenli evde gerçekleşen olayları işleyen metot.
    //Oyuncunun sağlığını yeniler ve tüm ödülleri toplamışsa oyunu kazanmıştır.
    @Override
    public boolean getLocation() {
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        System.out.println("Guvenli evdesiniz.");
        System.out.println("Caniniz yenilendi.");
        return true;
    }
}
