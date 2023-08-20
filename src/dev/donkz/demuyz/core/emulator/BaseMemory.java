package dev.donkz.demuyz.core.emulator;

public abstract class BaseMemory {
    protected int size;
    protected int[] memory;

    public BaseMemory(int size) {
        this.size = size;
        memory = new int[size];
    }

    /**
     * Write to memory. Start at target address.
     * @param content content to write
     * @param targetAddress target address
     */
    public void write(int[] content, int targetAddress) {
        for (int i = targetAddress; i < targetAddress + content.length; i++) {
            int val = content[i - targetAddress];
            if (val < 0) {
                val &= 0xFF;
            }
            memory[i] = val;
        }
    }

    /**
     * Write to memory. Start at target address.
     * @param content content to write
     * @param targetAddress target address
     */
    public void write(byte[] content, int targetAddress) {
        for (int i = targetAddress; i < targetAddress + content.length; i++) {
            int val = content[i - targetAddress];
            if (val < 0) {
                val &= 0xFF;
            }
            memory[i] = val;
        }
    }

    /**
     * Read from memory. Starts at target address until length is reached
     * @param targetAddress target address
     * @param length length to read
     * @return memory from targetAddress to targetAddress + length
     */
    public int[] read(int targetAddress, int length) {
        int[] read = new int[length];
        if (targetAddress + length >= 0) {
            System.arraycopy(memory, targetAddress, read, 0, length);
        }

        return read;
    }
}
