public class Weapon {

    //Weapon sınıfı, oyun içinde kullanılan silahları temsil eder.
    private String name;
    private int id;
    private int damage;
    private int price;

    public Weapon(String name, int id, int damage, int price) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    //Oyun içinde kullanılacak silahları içeren bir dizi oluşturan metot.
    public static Weapon[] weapons() {
        Weapon[] weaponList = new Weapon[3];
        weaponList[0] = new Weapon("Tabanca", 1, 2, 15);
        weaponList[1] = new Weapon("Kilic", 2, 3, 35);
        weaponList[2] = new Weapon("Tufek", 3, 7, 45);
        return weaponList;
    }

    //Verilen ID'ye sahip silahı döndüren metot.
    public static Weapon getWeaponObjByID(int id) {

        for (Weapon w : Weapon.weapons()) {
            if (w.getId() == id) {
                return w;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
