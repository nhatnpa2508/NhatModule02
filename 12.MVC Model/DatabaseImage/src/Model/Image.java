/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/9/2019                     *
 * Time: 4:41 PM                     *
 *************************************
 */

package Model;

import java.io.FileOutputStream;

public class Image {
    private int id;
    private String image;
    private Byte[] imageByte;
    private FileOutputStream imageOut;

    public Image(){}
    public Image(int id, String image, Byte[] imageByte){
        this.id = id;
        this.image = image;
        this.imageByte = imageByte;
    }
    public Image(int id, FileOutputStream imageOut){
        this.id = id;
        this.imageOut = imageOut;
    }

    public Image(int id, String imageDB) {
        this.id = id;
        this.image = imageDB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Byte[] getImageByte() {
        return imageByte;
    }

    public void setImageByte(Byte[] imageByte) {
        this.imageByte = imageByte;
    }

    public FileOutputStream getImageOut() {
        return imageOut;
    }

    public void setImageOut(FileOutputStream imageOut) {
        this.imageOut = imageOut;
    }
}
