package com.api.book.bootrestbook.helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.Paths;
import java.io.IOException;

@Component
public class FileUploadHelper {

    // public final String UPLOAD_DIR =
    // "C:\\SpringBootProjects\\bootrestbook\\src\\main\\resources\\static\\image";
    // we use \\ for path in windows
    public final String UPLOAD_DIR = new ClassPathResource("static/image").getFile().getAbsolutePath();// uploading file
                                                                                                       // for
                                                                                                       // dynamically

    // default constructor
    public FileUploadHelper() throws IOException {

    }

    public boolean uploadFile(MultipartFile multipartFile) {
        boolean f = false;
        try {
            // read data
            /*
             * InputStream is = multipartFile.getInputStream();
             * byte data[] = new byte[is.available()]; // here array will form and the size
             * of array is equal to numbert of
             * // bytes available in "is" i.e inputstream
             * is.read(data);
             * 
             * // write data on destination folder
             * 
             * // FileOutputStream fos=new
             * // FileOutputStream(UPLOAD_DIR+"\\"+multipartFile.getOriginalFilename());
             * FileOutputStream fos = new FileOutputStream(
             * UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename());
             * fos.write(data);
             * fos.flush();
             * fos.close();
             */

            // this is the replacement of above code to read and write the files
            Files.copy(multipartFile.getInputStream(),
                    Paths.get(UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;

    }

}
