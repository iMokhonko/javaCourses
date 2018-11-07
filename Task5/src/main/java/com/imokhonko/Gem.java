package com.imokhonko;

import java.util.Objects;

public class Gem {

    private final int id;

    private String name;
    private String preciousness;
    private String origin;

    private String color;
    private int transparency;
    private int faces;

    private int value;

    public Gem(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPreciousness(String preciousness) {
        this.preciousness = preciousness;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setTransparency(int transparency) {
        this.transparency = transparency;
    }

    public void setFaces(int faces) {
        this.faces = faces;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPreciousness() {
        return preciousness;
    }

    public String getOrigin() {
        return origin;
    }

    public String getColor() {
        return color;
    }

    public int getTransparency() {
        return transparency;
    }

    public int getFaces() {
        return faces;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Gem{" + "id=" + id + ", name='" + name + '\'' + ", preciousness='" + preciousness + '\'' + ", origin='" + origin + '\'' + ", color='" + color + '\'' + ", transparency=" + transparency + ", faces=" + faces + ", value=" + value + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        Gem gem = (Gem) o;
        return id == gem.id && transparency == gem.transparency && faces == gem.faces && value == gem.value && Objects.equals(name, gem.name) && Objects.equals(preciousness, gem.preciousness) && Objects.equals(origin, gem.origin) && Objects.equals(color, gem.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, preciousness, origin, color, transparency, faces, value);
    }
}
