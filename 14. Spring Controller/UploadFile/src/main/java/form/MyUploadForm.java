/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/16/2019                     *
 * Time: 8:08 AM                     *
 *************************************
 */

package form;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class MyUploadForm {
    private String description;
    //upload files
    private CommonsMultipartFile[] fileDatas;
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public CommonsMultipartFile[] getFileDatas() {
        return fileDatas;
    }

    public void setFileDatas(CommonsMultipartFile[] fileDatas) {
        this.fileDatas = fileDatas;
    }
}
