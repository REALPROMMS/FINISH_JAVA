import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BaubleStore {
    public ArrayList<Bauble> getBaubles() {
        return baubles;
    }

    public ArrayList<Bauble> getPrizeBaubles() {
        return prizeBaubles;
    }

    public String getPrizeFilePath() {
        return prizeFilePath;
    }

    private final ArrayList<Bauble> baubles;
    private final ArrayList<Bauble> prizeBaubles;
    private final String prizeFilePath;

    public BaubleStore() {
        baubles = new ArrayList<Bauble>();
        prizeBaubles = new ArrayList<Bauble>();
        prizeFilePath = "prize_baubles.txt";
    }

    public void addBauble(Bauble bauble) {
        baubles.add(bauble);
    }

    public void changeToyFrequency() {
        ArrayList<Double> freq = new ArrayList<Double>(baubles.size());
        int index = 0;
        for (Bauble bauble : baubles) {
            Scanner in = new Scanner(System.in);
            System.out.printf("Введи частоту выпадения игрушки (положительное число) %s\n", bauble.getName());
            freq.add(in.nextDouble());
            }
        int freq_sum = freq.stream().mapToInt(Double::intValue).sum();
        for (int i=0; i < baubles.size(); i++) {
            freq.set(i, freq.get(i)/freq_sum);
        }
        for (Bauble bauble : baubles) {
            bauble.setFrequency((Double) freq.get(index++));
        }
    }

    public int organizeRaffle() {
        ArrayList<Double> chance = new ArrayList<Double>(baubles.size());
        prizeBaubles.clear();

        for (Bauble bauble : baubles) {
            double random = Math.random() * 100;
            chance.add(random*bauble.getFrequency());
            }

        Double max_chance = Collections.max(chance);
        System.out.println(chance);
        System.out.println(max_chance);
        for (Bauble bauble: baubles) {
            if (bauble.getId() == chance.indexOf(max_chance)) {
                System.out.printf("Выпала игрушка: %s\n", bauble.getName());
                return bauble.getId();
            }
        }
        return 0;
    }
    public void getPrizeBauble(int bauble_id) {
        if (baubles.get(bauble_id).getQuantity() != 0) {
            baubles.get(bauble_id).setQuantity(baubles.get(bauble_id).getQuantity() - 1);
            try {
                FileWriter writer = new FileWriter(prizeFilePath, true);
                writer.write(baubles.get(bauble_id).getName() + "\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("Ошибка при записи в файл игрушки");
            }

        } else {
            System.out.println("Игрушки кончились");
        }
    }

    public void current_baubles_in_store() {
        System.out.println("Информация по игрушкам: ");
        for (Bauble bauble : baubles)
            System.out.println(bauble.toString());
    }
}
