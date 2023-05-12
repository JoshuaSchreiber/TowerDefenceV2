package de.joshua.util;

import java.awt.*;

public class NamedImage {

    private String name;
    private final Image image;

    public Image getImage() {
        return image;
    }

    public NamedImage(String name, Image image) {
        this.name = name;
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
