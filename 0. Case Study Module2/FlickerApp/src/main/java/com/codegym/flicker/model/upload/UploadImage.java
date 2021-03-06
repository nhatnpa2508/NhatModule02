/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 8/6/2019                     *
 * Time: 11:16 AM                     *
 *************************************
 */

package com.codegym.flicker.model.upload;

import com.codegym.flicker.model.Image;
import org.springframework.web.multipart.MultipartFile;

public class UploadImage extends Image {
    private MultipartFile multipartFile;

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}
