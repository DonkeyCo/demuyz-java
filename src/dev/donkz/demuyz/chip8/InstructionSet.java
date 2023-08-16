package dev.donkz.demuyz.chip8;

import dev.donkz.demuyz.chip8.instructions.*;

public enum InstructionSet {
    CLEAR(          0xFFFF, 0x00E0, CLS.class),
    RETURN(         0xFFFF, 0x00EE, RET.class),
    JUMP(           0xF000, 0x1000, JP.class),
    CALL(           0xF000, 0x2000, CALL.class),
    SE_REG_VAL(     0xF000, 0x3000, SEVxB.class),
    SNE_REG_VAL(    0xF000, 0x4000, SNEVxB.class),
    SEV_REG_REG(    0xF000, 0x5000, SEVxVy.class),
    LD_REG_VAL(     0xF000, 0x6000, LDVxB.class),
    ADD_REG_VAL(    0xF000, 0x7000, ADDVxB.class),
    LD_REG_REG(     0xF00F, 0x8000, LDVxVy.class),
    OR_REG_REG(     0xF00F, 0x8001, ORVxVy.class),
    AND_REG_REG(    0xF00F, 0x8002, ANDVxVy.class),
    XOR_REG_REG(    0xF00F, 0x8003, XORVxVy.class),
    ADD_REG_REG(    0xF00F, 0x8004, ADDVxVy.class),
    SUB_REG_REG(    0xF00F, 0x8005, SUBVxVy.class),
    SHR_REG(        0xF00F, 0x8006, SHRVx.class),
    SUBN_REG_REG(   0xF00F, 0x8007, SUBNVxVy.class),
    SHL_REG(        0xF00F, 0x800E, SHLVx.class),
    SNE_REG_REG(    0xF00F, 0x9000, SNEVxVy.class),
    LD_I_ADDR(      0xF000, 0xA000, LDIAddr.class),
    JP_V0_ADDR(     0xF000, 0xB000, JPV0Addr.class),
    RND_VX_VAL(     0xF000, 0xC000, RNDVxB.class),
    DRW_REG_REG_VAL(0xF000, 0xD000, DRWVxVyN.class),
    SKP_REG(        0xF0FF, 0xE09E, SKPVx.class),
    SKNP_REG(       0xF0FF, 0xE0A1, SKNPVx.class),
    LD_REG_DT(      0xF0FF, 0xF007, LDVxDT.class),
    LD_REG_K(       0xF0FF, 0xF00A, LDVxK.class),
    LD_DT_REG(      0xF0FF, 0xF015, LDDTVx.class),
    LD_ST_REG(      0xF0FF, 0xF018, LDSTVx.class),
    ADD_I_REG(      0xF0FF, 0xF01E, ADDIVx.class),
    LD_F_REG(       0xF0FF, 0xF029, LDFVx.class),
    LD_B_REG(       0xF0FF, 0xF033, LDBVx.class),
    LD_I_REG(       0xF0FF, 0xF055, LDIVx.class),
    LD_REG_I(       0xF0FF, 0xF065, LDVxI.class);

    public final int mask;
    public final int opcode;
    public final Class<? extends Instruction> instructionClass;

    InstructionSet(int mask, int opcode, Class<? extends Instruction> instructionClass) {
        this.mask = mask;
        this.opcode = opcode;
        this.instructionClass = instructionClass;
    }
}
