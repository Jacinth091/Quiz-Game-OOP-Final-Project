package backend;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Images {
    private static Images instance;

    private File[] imagesPaths;
    private ImageIcon[] tempImgs;
    
    private ImageIcon[] iconImgs;
    private ImageIcon[] images;
    private final String[] imgPaths = {
            "src",
            "mmamammama",
            "assets/places",
            "src/assets/places",
    };

    private final String[] iconPaths = {
            "Assets/icons",
//            "src/assets/icons",
            "src/Assets/icons"
    };
    
    
    public Images(){
        initializeImages();
    }

    private File[] validatePaths(String[] imgPath){
        int pathIndex = -1;
        File[] paths = new File[imgPath.length];
        File[] tempImages = null;
        // Load all the paths in imgPaths String array
        try {
            for (int i = 0; i < paths.length; i++) {
                paths[i] = new File(imgPath[i]);
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

    
    private ImageIcon[] getImagesFromSource(String[] imagePaths, int width, int height){
        imagesPaths = validatePaths(imagePaths);
        tempImgs = new ImageIcon[imagesPaths.length];
        
       for (int i = 0; i < tempImgs.length; i++) {
            String filePath = imagesPaths[i].getPath();
            try {
                ImageIcon tempImg = new ImageIcon(filePath);
                // Check to see if the image load is successful or not
                if (tempImg.getImageLoadStatus() != MediaTracker.COMPLETE) {
                    throw new NullPointerException("Image failed to load at path: " + filePath);
                }
                tempImgs[i] = resizeImageIcon(tempImg, width,height);
                System.out.printf("Image %2d loaded successfully from: %s%n", i, filePath);

            } catch (NullPointerException e) {
                System.out.println("Image loading failed for file " + filePath + ": " + e.getMessage());
            }
        }
        
        return tempImgs;
    }    
    
    private ImageIcon[] getImagesFromSource(String[] imagePaths){
        imagesPaths = validatePaths(imagePaths);
        tempImgs = new ImageIcon[images.length];
        
       for (int i = 0; i < tempImgs.length; i++) {
            String filePath = imagesPaths[i].getPath();
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
    
    private void initializeImages() {
         iconImgs = getImagesFromSource(iconPaths, 50, 50);
//         images = getImagesFromSource()



    }
    
    
    
    public static synchronized Images getInstance(){
        if(instance == null){
            instance = new Images();
        }

        return instance;
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

    
    
    
}
