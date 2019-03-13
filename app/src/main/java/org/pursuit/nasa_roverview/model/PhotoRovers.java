package org.pursuit.nasa_roverview.model;

import java.io.Serializable;
import java.util.List;

public class PhotoRovers implements Serializable {

    public String getImg_src() {
        return img_src;
    }

    public String getEarth_date() {
        return earth_date;
    }

    private String img_src;
    private String earth_date;

    public PhotoRovers(String img_src, String earth_date) {

        this.img_src = img_src;
        this.earth_date = earth_date;
    }
}
