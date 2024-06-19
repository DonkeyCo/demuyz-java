package main.java.dev.donkz.demuyz.core.emulator;

/**
 * Interface representing the CPU.
 *
 * Defines methods that a CPU needs to provide to function correctly.
 */
public interface CPU<T> extends Runnable {

    void loadROM(String path);

    void start();

    void run();

    void cycle();

    /**
     * Fetch next instruction
     */
    T fetch();

    /**
     * Decode instruction
     */
    BaseInstruction decode(T instructionCode);

    /**
     * Execute instruction
     */
    void execute(BaseInstruction instruction);

    /**
     * Retrieves register i
     * @param i register i
     * @return register
     */
    BaseRegister<T> getRegister(int i);

    /**
     * Retrieves the program counter
     * @return program counter
     */
    T getPC();

    void setPC(T pc);

    /**
     * Retrieves the stack pointer register
     * @return stack pointer register
     */
    T getSP();
}
