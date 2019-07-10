/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/9/2019                     *
 * Time: 5:01 PM                     *
 *************************************
 */

package Service;
import Model.ConnectDatabase;
import Model.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class ImageImpl implements IImage {
    Connection connection = ConnectDatabase.getConnection();
    ResultSet resultSet = null;
    Statement statement;
    String sql;

    @Override
    public void createImage(String image) {
        sql = "insert into image(Image)" +
                " values('" + image + "')";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String ImageToByte(String image) {
        String base64Image = "";
        File file = new File(image);
        try (FileInputStream imageInFile = new FileInputStream(file)) {
            byte imageData[] = new byte[(int) file.length()];
            imageInFile.read(imageData);
            base64Image = Base64.getEncoder().encodeToString(imageData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return base64Image;
    }

    @Override
    public FileOutputStream getImage(String imageDB) {
        FileOutputStream imageOutFile = null;
        byte[] imageByteArray = null;
        try {
            imageByteArray = Base64.getDecoder().decode(imageDB);
            imageOutFile.write(imageByteArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageOutFile;
    }

    @Override
    public List<Image> getAllImage() {
        List<Image> imageList = new ArrayList<>();
        sql = "SELECT id, Image FROM image.image";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String imageDB = resultSet.getString("Image");
                Image image = new Image(id,imageDB);
                imageList.add(image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imageList;
    }
}
