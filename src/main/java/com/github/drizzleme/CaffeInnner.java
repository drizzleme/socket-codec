package com.github.drizzleme;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created with socket-codec
 *
 * @author ; DRIZZLEME
 *         DATE : 2016/9/23
 */
public class CaffeInnner {
    private int id;
    private String header;
    private float val;
    private boolean quest;
    private byte flag;
    private byte[] bytes;
    private double d21;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public float getVal() {
        return val;
    }

    public void setVal(float val) {
        this.val = val;
    }

    public boolean isQuest() {
        return quest;
    }

    public void setQuest(boolean quest) {
        this.quest = quest;
    }

    public byte getFlag() {
        return flag;
    }

    public void setFlag(byte flag) {
        this.flag = flag;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public double getD21() {
        return d21;
    }

    public void setD21(double d21) {
        this.d21 = d21;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof CaffeInnner)) return false;

        CaffeInnner that = (CaffeInnner) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(val, that.val)
                .append(quest, that.quest)
                .append(flag, that.flag)
                .append(d21, that.d21)
                .append(header, that.header)
                .append(bytes, that.bytes)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(header)
                .append(val)
                .append(quest)
                .append(flag)
                .append(bytes)
                .append(d21)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("header", header)
                .append("val", val)
                .append("quest", quest)
                .append("flag", flag)
                .append("bytes", bytes)
                .append("d21", d21)
                .toString();
    }
}
