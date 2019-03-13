package org.pursuit.nasa_roverview.model;

import java.io.Serializable;
import java.util.List;

public class NASAPOJO implements Serializable {
    private List<PhotoRovers> photos;


    public NASAPOJO(List<PhotoRovers> photos) {
        this.photos = photos;
    }

    public List<PhotoRovers> getPhotos() {
        return photos;
    }

}
