
package com.example.json.Domain;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Our {

    @SerializedName("keyString")
    @Expose
    private String keyString;
    @SerializedName("keyNum")
    @Expose
    private Integer keyNum;
    @SerializedName("xyz")
    @Expose
    private Double xyz;
    @SerializedName("adds")
    @Expose
    private List<String> adds = null;
    @SerializedName("mouse")
    @Expose
    private Mouse mouse;
    @SerializedName("parse")
    @Expose
    private String parse;
    @SerializedName("devices")
    @Expose
    private List<Device> devices = null;

    public String getKeyString() {
        return keyString;
    }

    public void setKeyString(String keyString) {
        this.keyString = keyString;
    }

    public Integer getKeyNum() {
        return keyNum;
    }

    public void setKeyNum(Integer keyNum) {
        this.keyNum = keyNum;
    }

    public Double getXyz() {
        return xyz;
    }

    public void setXyz(Double xyz) {
        this.xyz = xyz;
    }

    public List<String> getAdds() {
        return adds;
    }

    public void setAdds(List<String> adds) {
        this.adds = adds;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public String getParse() {
        return parse;
    }

    public void setParse(String parse) {
        this.parse = parse;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

}
