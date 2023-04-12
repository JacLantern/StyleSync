package com.example.stylesync;

import java.awt.image.BufferedImage;

public class CasualityRating {

    private BufferedImage clothingImg;
    private double casualityRate;
    private String clothingType;
    private String season;
    private String color;
    private Boolean patterned;

    public CasualityRating (BufferedImage clothingImg, String clothingType, int casualityRating, String season, String color, Boolean
            patterned)	{

        this.clothingImg = clothingImg;
        this.casualityRate = casualityRating;
        this.clothingType = clothingType;
        this.season = season;
        this.color = color;
        this.patterned = patterned;
    }

    public BufferedImage getClothingImg()	{
        return clothingImg;
    }

    public String getClothingType()	{
        return clothingType;
    }

    public double getCasualityRating()	{
        return casualityRate;
    }

    public String getSeason()	{
        return season;
    }

    public String getColor()	{
        return color;
    }

    public Boolean getPatterned()	{
        return patterned;
    }

    public String toString()	{
        return "Clothing Image: " + clothingImg + "\nClothing Type: " + clothingType + "\nCasuality Rating: " +
                casualityRate + "\nSeason: " + season + "\nColor: " + color + "\nPatterned: " + patterned;
    }

}

