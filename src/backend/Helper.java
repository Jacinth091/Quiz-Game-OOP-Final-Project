package backend;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Helper {

    public Helper(){

    }
    ImageIcon[] eyeIcon;
    final String[] imgPaths = {
            "src",
            "mmamammama",
            "assets/places",
            "src/assets/places",
    };

    final String[] iconPaths = {
            "Assets/icons",
//            "src/assets/icons",
            "src/Assets/icons"
    };

    public File[] validateImagePaths(){
        int pathIndex = -1;
        File[] paths = new File[imgPaths.length];
        File[] tempImages = null;
        // Load all the paths in imgPaths String array
        try {
            for (int i = 0; i < paths.length; i++) {
                paths[i] = new File(imgPaths[i]);

                // Checking if the current path exist or a directory
                if (paths[i].exists() && paths[i].isDirectory() && !paths[i].getPath().equals("src")) {
                    pathIndex = i;
                    break;  // If it is valid, use the index and break out of the loop
                } else {
                    System.out.println("Invalid path at index " + i + ": " + paths[i].getPath());
                }
            }

            if (pathIndex == -1) {
                throw new IOException("No valid paths to initialize images.");
            }
            // Logging into console if valid index found
            System.out.println("Valid path found at index " + pathIndex + ": " + paths[pathIndex].getPath());
            tempImages = paths[pathIndex].listFiles();

            // Check if the image array is null (no files in directory)
            if (tempImages == null) {
                throw new NullPointerException("Image files array is null, check if directory is empty.");
            }

        } catch (IOException | NullPointerException e) {
            System.out.println("Directory or image loading failed: " + e.getMessage());
//            return; // Exit if no valid path or empty directory
        }

        return tempImages;

    }

    public File[] validateIconPaths(){
        int pathIndex = -1;

        File[] paths = new File[iconPaths.length];
        File[] tempImages = null;
        // Load all the paths in iconPaths String array
        try {
            for (int i = 0; i < iconPaths.length; i++) {
                paths[i] = new File(iconPaths[i]);

                // Checking if the current path exist or a directory
                if (paths[i].exists() && paths[i].isDirectory() && !paths[i].getPath().equals("src")) {
                    pathIndex = i;
                    break;  // If it is valid, use the index and break out of the loop
                } else {
                    System.out.println("Invalid path at index " + i + ": " + paths[i].getPath());
                }
            }

            if (pathIndex == -1) {
                throw new IOException("No valid paths to initialize images.");
            }
            // Logging into console if valid index found
            System.out.println("Valid path found at index " + pathIndex + ": " + paths[pathIndex].getPath());
            tempImages = paths[pathIndex].listFiles();

            // Check if the image array is null (no files in directory)
            if (tempImages == null) {
                throw new NullPointerException("Image files array is null, check if directory is empty.");
            }

        } catch (IOException | NullPointerException e) {
            System.out.println("Directory or image loading failed: " + e.getMessage());
//            return; // Exit if no valid path or empty directory
        }

        return tempImages;

    }

    public ImageIcon[] initializePlaceImages(){
        File[] placeImages = validateImagePaths();
        ImageIcon[] tempImgs = new ImageIcon[placeImages.length];
        // Initialize and load images in the array

        for (int i = 0; i < placeImages.length; i++) {
            String filePath = placeImages[i].getPath();
            try {
                ImageIcon tempImg = new ImageIcon(filePath);
                // Check to see if the image load is successful or not
                if (tempImg.getImageLoadStatus() != MediaTracker.COMPLETE) {
                    throw new NullPointerException("Image failed to load at path: " + filePath);
                }
                tempImgs[i] = tempImg;
                System.out.printf("Image %2d loaded successfully from: %s%n", i, filePath);

            } catch (NullPointerException e) {
                System.out.println("Image loading failed for file " + filePath + ": " + e.getMessage());
            }
        }
        return tempImgs;
    }

    public void initIcons(){
        File[] iconPaths = validateIconPaths();
        eyeIcon = new ImageIcon[iconPaths.length];


        for (int i = 0; i < eyeIcon.length; i++) {
            String filePath = iconPaths[i].getPath();
            try {
                ImageIcon tempImg = new ImageIcon(filePath);
                // Check to see if the image load is successful or not
                if (tempImg.getImageLoadStatus() != MediaTracker.COMPLETE) {
                    throw new NullPointerException("Image failed to load at path: " + filePath);
                }
                eyeIcon[i] = tempImg;
                System.out.printf("Image %2d loaded successfully from: %s%n", i, filePath);

            } catch (NullPointerException e) {
                System.out.println("Image loading failed for file " + filePath + ": " + e.getMessage());
            }
        }
    }

    public ImageIcon[] initializeIcons(){
        File[] iconImages = validateIconPaths();
        ImageIcon[] tempImgs = new ImageIcon[iconImages.length];
        for (int i = 0; i < iconImages.length; i++) {
            String filePath = iconImages[i].getPath();
            try {
                ImageIcon tempImg = new ImageIcon(filePath);
                // Check to see if the image load is successful or not
                if (tempImg.getImageLoadStatus() != MediaTracker.COMPLETE) {
                    throw new NullPointerException("Image failed to load at path: " + filePath);
                }
                tempImgs[i] = tempImg;
                System.out.printf("Image %2d loaded successfully from: %s%n", i, filePath);

            } catch (NullPointerException e) {
                System.out.println("Image loading failed for file " + filePath + ": " + e.getMessage());
            }
        }
        return tempImgs;

    }
    public void initImages() {
        initIcons();



    }

    public ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage(); // Get the image from the ImageIcon
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // Resize the image
        return new ImageIcon(resizedImage); // Create a new ImageIcon with the resized image
    }

    public ImageIcon resizeImageIcon(String filePath, int width, int height) {
        ImageIcon icon = new ImageIcon(filePath);
        Image image = icon.getImage(); // Get the image from the ImageIcon
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // Resize the image
        return new ImageIcon(resizedImage); // Create a new ImageIcon with the resized image
    }

    public ImageIcon[] getEyeIcon() {
        return eyeIcon;
    }
}
