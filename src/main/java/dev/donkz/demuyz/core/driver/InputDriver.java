package main.java.dev.donkz.demuyz.core.driver;

import main.java.dev.donkz.demuyz.core.base.ActionState;
import main.java.dev.donkz.demuyz.core.event.Callback;
import main.java.dev.donkz.demuyz.core.event.KeyEventInfo;

public interface InputDriver {
    void register(ActionState state, Callback<KeyEventInfo> callback);
    void deregister(ActionState state, Callback<KeyEventInfo> callback);
    void reset();
}
