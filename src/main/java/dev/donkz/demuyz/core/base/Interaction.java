package main.java.dev.donkz.demuyz.core.base;

public abstract class Interaction {
    private final ActionType type;
    private final KeyCode code;
    private final ActionState state;

    public Interaction(ActionType type, KeyCode code, ActionState state) {
        this.type = type;
        this.code = code;
        this.state = state;
    }

    public abstract void execute(KeyCode code);

    public ActionType getType() {
        return type;
    }

    public KeyCode getCode() {
        return code;
    }

    public ActionState getState() {
        return state;
    }
}
