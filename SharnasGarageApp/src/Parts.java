public class Parts
{
    private String id;
    private String itemName;
    private Double itemPrice;
    private boolean isGenuine;

    @Override
    public String toString() {
        return "Parts{" +
                "id='" + id + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", isGenuine=" + isGenuine +
                '}';
    }

    public Parts(){}

    public Parts(String id, String itemName, Double itemPrice) {
        this.id = id;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public Parts(String id, String itemName, Double itemPrice, boolean isGenuine) {
        this.id = id;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.isGenuine = isGenuine;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public boolean isGenuine() {
        return isGenuine;
    }

    public void setGenuine(boolean genuine) {
        isGenuine = genuine;
    }

}
