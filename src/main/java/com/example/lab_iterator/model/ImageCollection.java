package com.example.lab_iterator.model;

import javafx.scene.image.Image;

import java.nio.file.Paths;

public class ImageCollection implements Aggregate {
    private String filetopic;
    private Image bi;
    public ImageCollection(String filetopic) {
        this.filetopic = filetopic;
    }
    public class ImageIterator implements Iterator {
        private int current=0;

        public Image setImage(int temp)
        {
            String filename = Paths.get("C:\\Users\\User\\IdeaProjects\\lab_iterator\\src\\main\\resources\\com\\example\\lab_iterator\\Image\\" + filetopic + (current) + ".jpg").toUri().toString();
            Image img = new Image(filename);
            return img;
        }

        @Override
        public boolean hasNext(int i) {
            String filename = Paths.get("C:\\Users\\User\\IdeaProjects\\lab_iterator\\src\\main\\resources\\com\\example\\lab_iterator\\Image\\" + filetopic + (current+i) + ".jpg").toUri().toString();
            try {
                bi = new Image(filename);
                return !bi.isError();
            } catch (Exception ex) {
                System.err.println("Не удалось загрузить картинку! " + filename);
                ex.printStackTrace();
                return false;
            }
        }

        @Override
        public Object next() {
            if(this.hasNext(1)){
                ++current;
                return setImage(current);
            }
            current = 1;
            return  setImage(current);
        }
        @Override
        public Object previous()
        {
            if(this.hasNext(-1)){
                --current;
                return setImage(current);
            }
            current = 5;
            return setImage(current);

        }
    }
    @Override
    public Iterator getIterator() {
        return new ImageIterator();
    }

}
