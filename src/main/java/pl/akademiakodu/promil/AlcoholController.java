package pl.akademiakodu.promil;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlcoholController {
    private AlcoholCounter alcoholCounter = new AlcoholCounter();

//    ścieżka serwera lokalnego localhost:8080/
    @GetMapping("/")
    public String home(){
        return "alcohol";   // zwróć plik alcohol.html z folderu resources templates
    }
    @GetMapping("/result")
    public String getResult(@RequestParam Double quantity,
    @RequestParam Double weight, @RequestParam String alcohol, ModelMap modelMap){
        //        @RequestParam zamienia zmienne z adresu URL na zmienne Javowe
        float result = alcoholCounter.calculatePerMil(quantity*1000, weight, true, Alcohol.valueOf(alcohol));
        String resultString = String.format("%.2f", result);
        modelMap.put("result", resultString);
        return "result";
    }
//    Dla @GetMapping("/hello")
//    localhost:8080/hello


}
