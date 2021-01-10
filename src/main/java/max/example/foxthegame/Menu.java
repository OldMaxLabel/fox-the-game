package max.example.foxthegame;

import java.util.Objects;

public class Menu {

    private StartGameCommand startGameCommand;
    private LoadGameCommand loadGameCommand;
    private ExitGameCommand exitGameCommand;

    public Menu() {

    }

    public Menu(StartGameCommand startGameCommand, LoadGameCommand loadGameCommand, ExitGameCommand exitGameCommand) {
        setStartGameCommand(startGameCommand);
        setLoadGameCommand(loadGameCommand);
        setExitGameCommand(exitGameCommand);
    }

    public void setStartGameCommand(StartGameCommand startGameCommand) {
        this.startGameCommand = Objects.requireNonNull(startGameCommand);
    }

    public void setLoadGameCommand(LoadGameCommand loadGameCommand) {
        this.loadGameCommand = Objects.requireNonNull(loadGameCommand);
    }

    public void setExitGameCommand(ExitGameCommand exitGameCommand) {
        this.exitGameCommand = Objects.requireNonNull(exitGameCommand);
    }

    public void start() {
        startGameCommand.execute();
    }

    public void load() {
        loadGameCommand.execute();
    }

    public void exit() {
        exitGameCommand.execute();
    }

}
