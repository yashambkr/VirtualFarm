package com.example.virtualfarm2020;

public class Plants {
    private String mPlantName;
    private String PlantName;


    private int mimageResourceID =NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    ;

    public Plants(String PlantName) {
        mPlantName = PlantName;

    }

    public Plants(String PlantName, int imageResourceID){
        mPlantName = PlantName;

        mimageResourceID= imageResourceID;
    }

    /**
     * Get the default translation of the word.
     */

    public String getmPlantName() {
        return mPlantName;
    }



    public int getimageResourceID(){
        return mimageResourceID;
    }

    public boolean hasImage() {
        return mimageResourceID != NO_IMAGE_PROVIDED;
    }
}
