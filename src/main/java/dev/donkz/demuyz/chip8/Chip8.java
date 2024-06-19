package main.java.dev.donkz.demuyz.chip8;

import main.java.dev.donkz.demuyz.chip8.instructions.JP;
import main.java.dev.donkz.demuyz.core.emulator.BaseInstruction;
import main.java.dev.donkz.demuyz.core.emulator.CPU;
import main.java.dev.donkz.demuyz.core.util.binary.BinaryUtil;
import main.java.dev.donkz.demuyz.core.util.files.FileHandler;
import main.java.dev.donkz.demuyz.core.util.logger.Logger;
import main.java.dev.donkz.demuyz.swing.KeypadDriver;
import main.java.dev.donkz.demuyz.swing.SwingDisplay;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Chip8 implements CPU<Integer> {
    public static final int REGISTERS = 16;
    public static final long CYCLE_TIME = 60L;

    private final Logger logger;
    private final Memory memory;
    private final Keypad keypad;
    private final Display display;
    private int PC;
    private final Register I;
    private final Stack<Integer> stack;
    private final Timer delay;
    private final Timer sound;
    private final Register[] registers;

    public Chip8(Logger logger) {
        this.logger = logger;
        memory = new Memory();
        display = new Display(new SwingDisplay(64, 32, 5));
        keypad = new Keypad(new KeypadDriver());
        PC = 0x200;
        I = new Register();
        stack = new Stack<>();
        delay = new Timer(60);
        sound = new Timer(60);
        registers = Stream.generate(Register::new).limit(REGISTERS).toArray(Register[]::new);
    }

    @Override
    public void loadROM(String path) {
        byte[] bytes = FileHandler.readFile(path);
        if (bytes != null) {
            memory.write(bytes, PC);
        }
    }

    @Override
    public void start() {
        display.connectPeripherals(keypad.getDriver());
        display.on();
        ScheduledExecutorService s = new ScheduledThreadPoolExecutor(1);
        s.scheduleAtFixedRate(this::cycle, 0, CYCLE_TIME, TimeUnit.MILLISECONDS);
    }

    @Override
    public void run() {
        try {
            cycle();
        } catch (Throwable t) {
            System.out.println("Caught exception in Chip8#run. StackTrace: \n" + t.getStackTrace());
        }
    }

    @Override
    public void cycle() {
        logger.debug("Cycle", "CPU");
        int instructionCode = fetch();
        Instruction instruction = decode(instructionCode);
        execute(instruction);

        if (!(instruction instanceof JP)) {
            PC += 2;
        }
    }

    @Override
    public Integer fetch() {
        int[] addresses = memory.read(PC, 2);
        return addresses[0] << 8 | addresses[1];
    }

    @Override
    public Instruction decode(Integer instruction) {
        InstructionSet instructionVal = Arrays.stream(InstructionSet.values())
            .filter(it -> BinaryUtil.isInstructionMatch(instruction, it.mask, it.opcode))
            .findFirst().orElse(null);

        if (instructionVal != null) {
            try {
                return instructionVal.instructionClass.
                        getDeclaredConstructor(int.class, main.java.dev.donkz.demuyz.chip8.Chip8.class)
                        .newInstance(instruction, this);
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                logger.error("Exception", e.getMessage());
            }
        } else {
            logger.error("Instruction not found: " + BinaryUtil.getHexString(instruction), "Chip8", "Decode");
        }

        return null;
    }

    @Override
    public void execute(BaseInstruction instruction) {
        instruction.execute();
    }

    @Override
    public Register getRegister(int i) {
        if (i >= REGISTERS) {
            throw new RuntimeException("Register out of bounds"); // TODO: Separate exception
        }
        return registers[i];
    }

    @Override
    public Integer getPC() {
        return PC;
    }

    @Override
    public void setPC(Integer PC) {
        this.PC = PC;
    }

    @Override
    public Integer getSP() {
        return stack.size();
    }

    public Timer getDelay() {
        return delay;
    }

    public Timer getSound() {
        return sound;
    }

    public Memory getMemory() {
        return memory;
    }

    public Display getDisplay() {
        return display;
    }

    public Register getI() {
        return I;
    }

    public Stack<Integer> getStack() {
        return stack;
    }

    public Logger getLogger() {
        return logger;
    }
}
