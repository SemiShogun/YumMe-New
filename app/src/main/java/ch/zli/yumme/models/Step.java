package ch.zli.yumme.models;

import java.io.Serializable;

public class Step implements Serializable {
    private String instruction;

    public Step() {

    }

    public Step(String instruction) {
        this.instruction = instruction;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
