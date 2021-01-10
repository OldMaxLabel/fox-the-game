package max.example.foxthegame;

import java.io.*;
import java.util.*;

public class GameFunction {

    public static void go() {

        GameFunction gameFunction = new GameFunction();
        StartGameCommand startGameCommand = new StartGameCommand(gameFunction);
        LoadGameCommand loadGameCommand = new LoadGameCommand(gameFunction);
        ExitGameCommand exitGameCommand = new ExitGameCommand(gameFunction);

        Menu menu = new Menu(startGameCommand, loadGameCommand, exitGameCommand);

        Scanner scanner = new Scanner(System.in);

        boolean flag = true;
        while (flag) {

            System.out.println("Добро пожаловать в игру: \"История одного приключения Лисенка!\"");

            System.out.println("Меню");
            System.out.println("1. Начать игру");
            System.out.println("2. Загрузить игру");
            System.out.println("3. Выйти");

            System.out.println("Выберите действие:");

            if (scanner.hasNextInt()) {

                int var = scanner.nextInt();
                scanner.nextLine();

                switch (var) {
                    case 1:
                        menu.start();
                        break;
                    case 2:
                        menu.load();
                        break;
                    case 3:
                        menu.exit();
                        flag = false;
                        break;
                    default:
                        System.out.println("Нет такого варианта");
                        break;
                }

            } else {
                System.out.println("Вводите только цифры!");
                scanner.nextLine();
                flag = true;
            }

        }

    }


    public void startGame() {

        GameNode fox = new GameNode();
        fox.setNodeText("Каждое утро Лисёнок просыпался, завтракал и шёл увидеться с Бельчонком.\n" +
                "Это утро не было исключением. Лисёнок пришёл на их обычное место встречи, но Бельчонка там не было.\n" +
                "Лисёнок ждал, ждал, но так и не смог дождаться своего друга.\n" +
                "\"Бельчонок не пропустил еще ни одной встречи, вдруг он попал в беду.\" - подумал Лисёнок.\n" +
                "Как поступить Лисенку?");
        fox.setVarOne("Вернуться домой");
        fox.setVarTwo("Отправиться на поиски");

        GameNode arrivedHome = new GameNode();
        arrivedHome.setNodeText("Вернувшись домой, Лисёнок нашёл там Бельчонка. Оказалось, что Бельчонок пришёл \n" +
                "на место встречи раньше и увидел там рой злобных пчел. Он поспешил предупредить об этом Лисёнка, \n" +
                "но они разминулись. Наконец-то друзья нашли друг друга! Игра завершилась успехом!");

        GameNode adventureTime = new GameNode();
        adventureTime.setNodeText("Все лесные жители были заняты своими делами и не обращали внимания на Лисёнка и его проблему.\n" +
                "Но вдруг кто-нибудь видел Бельчонка... Лисёнок не знал, что ему делать. Помогите ему.");
        adventureTime.setVarOne("Попытаться разузнать о Бельчонке у лесных жителей");
        adventureTime.setVarTwo("Искать Бельчонка в одиночку");

        fox.setNodeOne(arrivedHome);
        fox.setNodeTwo(adventureTime);

        GameNode tryAskAbout = new GameNode();
        tryAskAbout.setNodeText("Пока Лисёнок принимал решение, лесные жители разошлись кто куда. \n" +
                "Остались только Сова и Волк. Но у Совы бывают проблемы с памятью, а Волк может сильно разозлиться из-за расспросов.\n" +
                "Кого выбрать?");
        tryAskAbout.setVarOne("Расспросить Сову");
        tryAskAbout.setVarTwo("Расспросить Волка");

        GameNode findAlone = new GameNode();
        findAlone.setNodeText("Лисёнок слишком долго плутал по лесу в поисках друга и сам не заметил, как заблудился.\n" +
                "Теперь его самого нужно искать. Игра завершилась неудачей.");

        adventureTime.setNodeOne(tryAskAbout);
        adventureTime.setNodeTwo(findAlone);

        GameNode askOwl = new GameNode();
        askOwl.setNodeText("Сова долго не хотела говорить, но в итоге сказала, что видела испуганного Бельчонка, \n" +
                "бежавшего вглубь леса. Все лесные жители знают, что в глубине леса опасно! Если Бельчонок там, \n" +
                "ему срочно нужна помощь.");
        askOwl.setVarOne("Поверить Сове и отправиться вглубь леса");
        askOwl.setVarTwo("Сове не стоит верить -> Искать Бельчонка в одиночку");

        GameNode askWolf = new GameNode();
        askWolf.setNodeText("Волк оказался вполне дружелюбным, но помочь не смог. Лишь сказал, \n" +
                "что маленькому лисенку не стоит бродить по лесу одному. И как теперь поступить?");
        askWolf.setVarOne("Волк прав -> Вернуться домой");
        askWolf.setVarTwo("Искать Бельчонка в одиночку");

        tryAskAbout.setNodeOne(askOwl);
        tryAskAbout.setNodeTwo(askWolf);

        GameNode trustOwl = new GameNode();
        trustOwl.setNodeText("В глубине леса Лисёнок встретил Медвежонка. Ленивый Медвежонок был готов рассказать все, \n" +
                "что знает, если Лисёнок принесёт ему мёда.");
        trustOwl.setVarOne("Нет, потрачено слишком много времени, нужно идти дальше -> Искать Бельчонка в одиночку");
        trustOwl.setVarTwo("Нужно воспользоваться шансом и раздобыть мёд");

        askOwl.setNodeOne(trustOwl);
        askOwl.setNodeTwo(findAlone);

        askWolf.setNodeOne(arrivedHome);
        askWolf.setNodeTwo(findAlone);

        GameNode takeHoney = new GameNode();
        takeHoney.setNodeText("Лисёнок быстро нашёл мёд, но вокруг летал рой злобных пчел. Лисёнок всегда боялся пчёл, \n" +
                "но и не найти друга он тоже боялся.");
        takeHoney.setVarOne("Подождать, вдруг пчёлы улетят");
        takeHoney.setVarTwo("Нужно попытаться выкрасть мёд немедленно");

        trustOwl.setNodeOne(findAlone);
        trustOwl.setNodeTwo(takeHoney);

        GameNode waitingBeesFlyAway = new GameNode();
        waitingBeesFlyAway.setNodeText("Лисёнок подождал немного и пчёлы разлетелись. Лисёнок без проблем набрал мёда. \n" +
                "Вдруг он понял, что очень голоден. Что же делать?");
        waitingBeesFlyAway.setVarOne("Поесть немного и передохнуть");
        waitingBeesFlyAway.setVarTwo("Скорее отнести мёд Медвежонку");

        GameNode robberHoneyImmediately = new GameNode();
        robberHoneyImmediately.setNodeText("Это была не лучшая идея. Пчёлы покусали Лисёнка, теперь ему самому нужна помощь. \n" +
                "Игра закончилась неудачей.");

        takeHoney.setNodeOne(waitingBeesFlyAway);
        takeHoney.setNodeTwo(robberHoneyImmediately);

        GameNode EatAndRest = new GameNode();
        EatAndRest.setNodeText("Пока Лисёнок ел, злобные пчёлы вернулись и покусали его. Лисёнку нужна помощь, \n" +
                "он не сможет продолжить поиски. Игра завершилась неудачей.");

        GameNode bringHoneyFast = new GameNode();
        bringHoneyFast.setNodeText("Довольный Медвежонок рассказал Лисёнку, что очень хорошо знает семью Белок и уверен, \n" +
                "что Бельчонок никогда не пошёл бы в глубь леса. Он заверял Лисёнка, что Белки не попадают в неприятности, \n" +
                "и что Совам нельзя верить, он также уговаривал Лисёнка вернуться домой.");
        bringHoneyFast.setVarOne("Медвежонок ничего не знает, нужно продолжить поиски -> Искать Бельчонка в одиночку");
        bringHoneyFast.setVarTwo("Может быть он прав и Лисёнок просто паникует -> Вернуться домой");

        waitingBeesFlyAway.setNodeOne(EatAndRest);
        waitingBeesFlyAway.setNodeTwo(bringHoneyFast);

        waitingBeesFlyAway.setNodeOne(findAlone);
        waitingBeesFlyAway.setNodeTwo(arrivedHome);

        Thread game = new Thread(fox);
        game.start();
        try {
            game.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void loadGame() {

        File file = new File("src/main/resources/saves.bin");

        Object o = null;

        try (FileInputStream fileInput = new FileInputStream(file);
             ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {
            o = objectInput.readObject();
        } catch (FileNotFoundException ignored) {
            System.out.println("Нет сохраненных игр!");
        } catch (IOException |
                ClassNotFoundException e) {
            e.printStackTrace();
        }

        Thread game = new Thread((Runnable) o);
        game.start();
        try {
            game.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void exitGame() {

        Thread.currentThread().interrupt();

    }

    public static void saveGame(String nodeText, String varOne, String varTwo, GameNode nodeOne, GameNode nodeTwo) {

        Objects.requireNonNull(nodeText);

        File file = new File("src/main/resources/saves.bin");

        try (FileOutputStream fileStream = new FileOutputStream(file);
             ObjectOutputStream objectOutput = new ObjectOutputStream(fileStream)) {
            GameNode gameNode = new GameNode();
            gameNode.setNodeText(nodeText);
            String varOneNew = varOne.substring(3);
            gameNode.setVarOne(varOneNew);
            String varTwoNew = varTwo.substring(3);
            gameNode.setVarTwo(varTwoNew);
            gameNode.setNodeOne(nodeOne);
            gameNode.setNodeTwo(nodeTwo);
            objectOutput.writeObject(gameNode);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        } catch (IOException io) {
            System.out.println("IOException");
        }

    }


}
