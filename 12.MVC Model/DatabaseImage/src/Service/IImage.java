/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/9/2019                     *
 * Time: 4:44 PM                     *
 *************************************
 */

package Service;

import Model.Image;

import java.io.FileOutputStream;
import java.util.List;

public interface IImage {
    public void createImage(String image);

    public String ImageToByte(String image);

    public FileOutputStream getImage(String image);

    List<Image> getAllImage();
}
