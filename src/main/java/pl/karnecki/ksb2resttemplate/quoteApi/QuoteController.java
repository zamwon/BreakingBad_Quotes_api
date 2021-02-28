package pl.karnecki.ksb2resttemplate.quoteApi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Controller
public class QuoteController {


    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/quotes/{number}")
    public String getQuote(@PathVariable Integer number, Model model){
        Quote[] quotes = restTemplate.getForObject("https://breaking-bad-quotes.herokuapp.com/v1/quotes/" + number, Quote[].class);
        model.addAttribute("quoteAttribute", quotes);
        return "QuoteView";
    }

}
