package dev.donkz.demuyz.core.util.binary;

public class BinaryUtil {
    public static String get32BitString(int binary) {
        return String.format("%32s", Integer.toBinaryString(binary)).replace(' ', '0');
    }

    public static String getHexString(int binary) {
        return String.format("0x%32s", Integer.toHexString(binary)).replace(' ', '0');
    }

    public static String getHexString(int binary, int len) {
        return String.format("0x%" + len + "s", Integer.toHexString(binary)).replace(' ', '0');
    }

    public static String get16BitString(short binary) {
        return String.format("%16s", Integer.toBinaryString(binary)).replace(' ', '0');
    }

    public static int getBit(int bits, int pos) {
        return (bits >> pos) & 1;
    }

    public static int setBit(int bits, int pos) {
        return bits | (1 << pos);
    }

    public static int unsetBit(int bits, int pos) {
        return bits & ~(1 << pos);
    }

    public static boolean isInstructionMatch(int instruction, int mask, int opcode) {
        return (instruction & mask) == opcode;
    }
}
