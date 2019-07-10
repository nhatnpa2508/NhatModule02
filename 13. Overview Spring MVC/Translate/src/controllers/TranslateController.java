/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/10/2019                     *
 * Time: 11:03 PM                     *
 *************************************
 */

package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TranslateController {

    @GetMapping("/")
    public String converter(){
        return "index";
    }
    @GetMapping("/trainslate")
    public String conversion(@RequestParam String word,  Model model) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");
        String result = dictionary.get(word);
        if (result == null){
            result = "Khong tim thay ket qua";
        }
        model.addAttribute("word", word);
        model.addAttribute("result", result);
        return "trainslate";
    }
}
