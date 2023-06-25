import java.util.Scanner;

public class BaubleRaffle {
    public static void main(String[] args) {
        BaubleStore store = new BaubleStore();

        Bauble bauble1 = new Bauble("Игрушка 1", 10, 33);
        Bauble bauble2 = new Bauble("Игрушка 2", 10, 33);
        Bauble bauble3 = new Bauble("Игрушка 3", 10, 34);

        store.addBauble(bauble1);
        store.addBauble(bauble2);
        store.addBauble(bauble3);

        store.current_baubles_in_store();

        store.changeBaubleFrequency();

        String continue_flag = "1";
        while (continue_flag.equals("1")) {
            int bauble_id = store.organizeRaffle();
            store.getPrizeBauble(bauble_id);
            store.current_baubles_in_store();
            System.out.println("Сыграем в игру ещё раз? 1 - да, любой другой символ - нет");
            Scanner in = new Scanner(System.in);
            continue_flag = in.next();
        }
    }
}

