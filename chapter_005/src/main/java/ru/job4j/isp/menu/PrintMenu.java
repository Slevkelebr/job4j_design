package ru.job4j.isp.menu;
/**
 * Class PrintMenu - print menu.
 *
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 05.05.2020
 */
public class PrintMenu implements Print {
    /**
     * start Item of menu
     */
    private Item root;

    /**
     * Constructor of menu class, set start Item
     *
     * @param root start Item of menu
     */
    private PrintMenu(Item root) {
        this.root = root;
    }

    /**
     * Static class to get PrintMenu example
     *
     * @param root start Item of menu
     * @return PrintMenu example
     */
    public static PrintMenu getMenu(Item root) {
        return new PrintMenu(root);
    }

    /**
     * Print menu
     */
    public void print() {
        for (var e : root.itemsMenu) {
            System.out.printf("%s Пункт %s %s \n", "===", e.number + ".", e.name);
            innerPrint(e, "==", e.number + ".");
        }


    }

    /**
     * Print itemsMenu of Item
     *
     * @param item Item which leafs are printed
     * @param inTab tab
     * @param number position
     */
    private void innerPrint(Item item, String inTab, String number) {
        inTab = inTab + "===";
        for (var e : item.itemsMenu) {
            String outNum = number +  e.number + ".";
            System.out.printf("%s Пункт %s %s \n", inTab, outNum, e.name);
            innerPrint(e, inTab, outNum);
        }
    }
}