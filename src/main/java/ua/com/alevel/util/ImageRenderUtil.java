package ua.com.alevel.util;

import org.springframework.web.multipart.MultipartFile;
import ua.com.alevel.properties.StaticProperties;

import java.io.File;
import java.io.IOException;
import java.util.Objects;


public final class ImageRenderUtil {

    private static String pathToImage;
    private static String newPostId;


    private ImageRenderUtil() {
        throw new IllegalStateException("Utility class.");
    }


    public static String writeImageToFilesAndGetPath(MultipartFile multipartFile, String newPostId) throws IOException {
        ImageRenderUtil.newPostId = newPostId;
        return savingLargeImage(multipartFile);
    }

    private static String savingLargeImage(MultipartFile image) throws IOException {

        pathToImage = generatePathToPackageForSavedImage() + "/" + newPostId + getExtensionFile(Objects.requireNonNull(image.getOriginalFilename()));
        image.transferTo(new File(pathToImage));


        return pathToImage;
    }


    private static String generatePathToPackageForSavedImage() {
        return StaticProperties.PATH_PROJECT + "/src/main/resources/static/files";
    }

    private static String getExtensionFile(String originalFileName) {
        return originalFileName.substring(originalFileName.lastIndexOf('.'));
    }

}
