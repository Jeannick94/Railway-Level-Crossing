package com.example.sensorapp.controllerstate;

public class DFlipFlop {
    private Boolean d;
    private Boolean q;
    private Boolean clk;

    public DFlipFlop() {
        q = false;
        clk = false;
    }

    public DFlipFlop(Boolean d, Boolean CLK) {
        this.d = d;
        this.clk = CLK;
    }

    public Boolean getD() {
        return d;
    }

    public void setD(Boolean d) {
        this.d = d;
    }

    public Boolean getQ() {
        return q;
    }

    public void setQ(Boolean q) {
        this.q = q;
    }

    public Boolean getClk() {
        return clk;
    }

    public void setClk(Boolean clk) {
        this.clk = clk;
    }

    public void clock() {
        if (clk) {
            q = d;
        }
    }

    @Override
    public String toString() {
        return "DFlipFlop{" +
                "D=" + d +
                ", Q=" + q +
                ", CLK=" + clk +
                '}';
    }

}
