package com.exmaple.stylesync;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;

public class CameraInput extends JFrame {

    public static void main(String[] args) {

        Scanner alpha = new Scanner(System.in);

        Picture img = new Picture();
        img.pick();
        BufferedImage clothingImg = img.getImage();

        System.out.println("Input the clothing type here:");
        String clothingType = alpha.nextLine();

        System.out.println("Input the season the clothing is worn in here:");
        String season = alpha.nextLine();

        System.out.println("Input the color of the clothing here:");
        String color = alpha.nextLine();

        System.out.println("Input whether or not the clothing is patterned (True or False) here:");
        Boolean patterned = alpha.nextBoolean();

        HashMap<String, Integer> typeToCasuality = new HashMap<String, Integer>();
        typeToCasuality.put("Sweatpants", 1);
        typeToCasuality.put("Trousers", 3);
        typeToCasuality.put("Tracksuit", 1);
        typeToCasuality.put("Dress Pants", 5);
        typeToCasuality.put("Cardigan", 2);
        typeToCasuality.put("Sweatshirt/Fleece", 2);
        typeToCasuality.put("Blazer", 4);
        typeToCasuality.put("Khakis", 4);
        typeToCasuality.put("Turtleneck", 3);
        typeToCasuality.put("Leggings", 2);
        typeToCasuality.put("Cargo Pants", 3);
        typeToCasuality.put("Boot-cut Pants", 3);
        typeToCasuality.put("Shorts", 1);
        typeToCasuality.put("Hot pants", 1);
        typeToCasuality.put("Carpenter", 3);
        typeToCasuality.put("Flare pants", 3);
        typeToCasuality.put("Jeans", 3);
        typeToCasuality.put("Winter Jacket", 2);
        typeToCasuality.put("Raincoat", 2);
        typeToCasuality.put("Lapel Jacket", 5);
        typeToCasuality.put("Button-down Shirt", 4);
        typeToCasuality.put("Skirt", 3);
        typeToCasuality.put("Dress", 4);
        typeToCasuality.put("Polo Shirt", 3);

        ArrayList<CasualityRating> clothing = new ArrayList<CasualityRating>();
        clothing.add(new CasualityRating(clothingImg, clothingType, typeToCasuality.get(clothingType), season, color,
                patterned));

        System.out.println(clothing.toString());
    }

}
