package main.java.dev.donkz.demuyz.core.event;

public interface Callback<T extends KeyEventInfo> {
    void execute(T eventInfo);
}
