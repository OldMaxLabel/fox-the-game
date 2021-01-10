package max.example.foxthegame;

import java.util.Objects;

public class LoadGameCommand implements Command {

    private GameFunction gameFunction;

    public LoadGameCommand(GameFunction gameFunction) {
        this.gameFunction = Objects.requireNonNull(gameFunction);
    }

    @Override
    public void execute() {
        gameFunction.loadGame();
    }

}
