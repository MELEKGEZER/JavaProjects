public class River extends BattleLoc{
// River sınıfı, BattleLoc sınıfından türetilmiştir, nehir konumunu temsil eder

    public River(Player player) {
        // BattleLoc sınıfının kurucusunu çağırarak nehir konumunu başlatır.
        // Bu konumda oyuncu ayılarla savaşır ve ödül olarak su kazanır.
        super(player,"Nehir",new Bear(),"Su");

    }
}