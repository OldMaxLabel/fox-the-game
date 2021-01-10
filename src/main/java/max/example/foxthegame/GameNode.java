package max.example.foxthegame;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class GameNode implements Runnable, Serializable {

    private static final long serialVersionUID = 1L;

    private Menu menu;

    private String nodeText;
    private String varOne;
    private String varTwo;

    protected String varThree = "3. Сохранить игру";
    protected String varFour = "4. Завершить игру";

    private GameNode nodeOne;
    private GameNode nodeTwo;

    public GameNode() {

    }

    public String getNodeText() {
        return nodeText;
    }

    public void setNodeText(String nodeText) {
        this.nodeText = Objects.requireNonNull(nodeText);
    }

    public String getVarOne() {
        return varOne;
    }

    public void setVarOne(String varOne) {
        this.varOne = "1. " + varOne;
    }

    public String getVarTwo() {
        return varTwo;
    }

    public void setVarTwo(String varTwo) {
        this.varTwo = "2. " + varTwo;
    }

    public GameNode getNodeOne() {
        return nodeOne;
    }

    public void setNodeOne(GameNode nodeOne) {
        this.nodeOne = nodeOne;
    }

    public GameNode getNodeTwo() {
        return nodeTwo;
    }

    public void setNodeTwo(GameNode nodeTwo) {
        this.nodeTwo = nodeTwo;
    }

    @Override
    public void run() {

        if (nodeText == null) {
            throw new RuntimeException("Вы забыли установить значение!");
        }

        System.out.println(nodeText);

        if (varOne != null && varTwo != null) {

            GameFunction gameFunction = new GameFunction();
            ExitGameCommand exitGameCommand = new ExitGameCommand(gameFunction);
            menu = new Menu();
            menu.setExitGameCommand(exitGameCommand);

            Scanner scanner = new Scanner(System.in);

            boolean flag = true;
            while (flag) {

                System.out.println(varOne);
                System.out.println(varTwo);
                System.out.println();
                System.out.println(varThree);
                System.out.println(varFour);

                System.out.println("Выберите действие:");

                if (scanner.hasNextInt()) {

                    int var = scanner.nextInt();
                    scanner.nextLine();

                    Thread newThread = null;

                    switch (var) {
                        case 1:
                            newThread = new Thread(nodeOne);
                            newThread.start();
                            try {
                                newThread.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                            break;
                        case 2:
                            newThread = new Thread(nodeTwo);
                            newThread.start();
                            try {
                                newThread.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                            break;
                        case 3:
                            GameFunction.saveGame(nodeText, varOne, varTwo, nodeOne, nodeTwo);
                            break;
                        case 4:
                            menu.exit();
                            flag = false;
                            break;
                        default:
                            System.out.println("Нет такого варианта");
                    }

                } else {
                    System.out.println("Вводите только цифры!");
                    scanner.nextLine();
                    System.out.println(nodeText);
                    flag = true;
                }

            }

        }

    }

}


