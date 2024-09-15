package main.java.dev.donkz.demuyz.core.base;

public enum KeyCode {
    // Common Key Codes
    ENTER(13),
    ESCAPE(27),
    SPACE(32),
    LEFT_ARROW(37),
    UP_ARROW(38),
    RIGHT_ARROW(39),
    DOWN_ARROW(40),
    A(65),
    B(66),
    C(67),
    D(68),
    E(69),
    F(70),
    G(71),
    H(72),
    I(73),
    J(74),
    K(75),
    L(76),
    M(77),
    N(78),
    O(79),
    P(80),
    Q(81),
    R(82),
    S(83),
    T(84),
    U(85),
    V(86),
    W(87),
    X(88),
    Y(89),
    Z(90),
    NUM_0(48),
    NUM_1(49),
    NUM_2(50),
    NUM_3(51),
    NUM_4(52),
    NUM_5(53),
    NUM_6(54),
    NUM_7(55),
    NUM_8(56),
    NUM_9(57),

    // Function Keys
    F1(112),
    F2(113),
    F3(114),
    F4(115),
    F5(116),
    F6(117),
    F7(118),
    F8(119),
    F9(120),
    F10(121),
    F11(122),
    F12(123),

    // Special Keys
    BACKSPACE(8),
    TAB(9),
    SHIFT(16),
    CTRL(17),
    ALT(18),
    CAPS_LOCK(20),
    DELETE(46),
    HOME(36),
    END(35),
    PAGE_UP(33),
    PAGE_DOWN(34),
    INSERT(45);

    private final int code;

    KeyCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static KeyCode fromCode(int code) {
        for (KeyCode keyCode : KeyCode.values()) {
            if (keyCode.getCode() == code) {
                return keyCode;
            }
        }
        return null;
    }
}
