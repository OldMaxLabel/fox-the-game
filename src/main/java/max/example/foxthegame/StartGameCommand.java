package max.example.foxthegame;

import java.util.Objects;

public class StartGameCommand implements Command {

    private GameFunction gameFunction;

    public StartGameCommand(GameFunction gameFunction) {
        this.gameFunction = Objects.requireNonNull(gameFunction);
    }

    @Override
    public void execute() {
        gameFunction.startGame();
    }

}
