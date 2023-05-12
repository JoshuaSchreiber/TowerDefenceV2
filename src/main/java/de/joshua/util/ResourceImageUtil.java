package de.joshua.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ResourceImageUtil {

    private ResourceImageUtil() {
    }

    public static NamedImage[] getImagesFromResources(String path) {
        try {
            Stream<Path> list = Files.list(new File(ResourceImageUtil.class.getClassLoader().getResource(path).toURI()).toPath());
            List<NamedImage> images = new ArrayList<>();
            list.forEach(pathImage -> {
                try {
                    images.add(new NamedImage(new File(pathImage.toUri()).getName(), ImageIO.read(pathImage.toFile())));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            return images.toArray(new NamedImage[0]);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
