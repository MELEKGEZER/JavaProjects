
// Armor sınıfı, karakterin zırh özelliklerini temsil eder.
public class Armor {
    private String name;
    private int id;
    private int defence;
    private int price;

    public Armor(String name, int id, int defence, int price) {
        this.name = name; // Zırhın adını tutan degisken
        this.id = id; // Zırhın benzersiz kimligini tutan degisken
        this.defence = defence; // Zırhın savunma gücünü tutan degisken
        this.price = price; // Zırhın fiyatını tutan degisken
    }


    // Tanımlanan üç farklı zırh türünü içeren bir dizi döndüren statik metot
    public static Armor[] armors() {
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor("Hafif", 1, 1, 15);
        armorList[1] = new Armor("Orta", 2, 3, 25);
        armorList[2] = new Armor("Agir", 3, 5, 40);
        return armorList;
    }

    // Verilen bir zırh ID'sine sahip zırh nesnesini döndüren statik metot
    public static Armor getArmorObjByID(int id) {
        for (Armor a : Armor.armors()) {
            if (a.getId() == id) {
                return a;
            }
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
