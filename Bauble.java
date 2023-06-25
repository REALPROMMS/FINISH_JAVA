import java.util.concurrent.atomic.AtomicInteger;

public class Bauble {
    private static final AtomicInteger COUNTER = new AtomicInteger(0);                     // id игрушки
    private final String name;                // название
    private final int id;
    private int quantity;               // количество
    private double frequency;           // частота выпадения 


    @Override
    public String toString() {
        return "Bauble{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", frequency=" + frequency +
                '}';
    }

    public Bauble(String name, int quantity, double frequency) {
        this.id = COUNTER.getAndIncrement();
        this.name = name;
        this.quantity = quantity;
        this.frequency = frequency;
    }


    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public int getQuantity() {
        return quantity;
    }


    public double getFrequency() {
        return frequency;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }
    
}