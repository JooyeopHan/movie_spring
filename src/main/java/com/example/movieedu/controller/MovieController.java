package com.example.movieedu.controller;

import com.example.movieedu.api.API;
import com.example.movieedu.model.vo.MovieVO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.example.movieedu.service.MovieService;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes(value = {"select","subject"})
public class MovieController {
    @Autowired
    MovieService ms;

    @ModelAttribute("select")
    public static ArrayList<MovieVO> create(){
        return new ArrayList<>();
    }

    @ModelAttribute("subject")
    public static ArrayList<String> subcreate(){
        return new ArrayList<>();
    }

    @GetMapping("/movie/country")
    public String country(@ModelAttribute("select") ArrayList<MovieVO> results,@ModelAttribute("subject")ArrayList<String> sub,String subject,int num) {
        List<MovieVO> countries = ms.country("test", num);
        if(results.size() != 0) {
            results.clear();
        }
        if(sub.size() != 0 ){
            sub.clear();
        }
        for (int i = 0; i < 10; i++) {
            MovieVO vo = new MovieVO();
            String result = API.get(countries.get(i).getMovieNM());
            JSONObject object = new JSONObject(result);
            JSONArray items = object.getJSONArray("items");
            JSONObject item = (JSONObject) items.get(0);
            vo.setSubtitle(item.getString("subtitle"));
            vo.setRank(countries.get(i).getRank());
            vo.setMovieNM(countries.get(i).getMovieNM());
            vo.setActor(item.getString("actor"));
            vo.setImgUrl(item.getString("image").replaceAll("mit110", "mit500"));
            vo.setPubDate(Integer.parseInt(item.getString("pubDate")));
            vo.setUserRating(Double.parseDouble(item.getString("userRating")));
            results.add(vo);
        }

        sub.add(subject);


        return "login";
    }

    @GetMapping("/movie/ganre")
    public String ganre(@ModelAttribute("select") ArrayList<MovieVO> results,@ModelAttribute("subject")ArrayList<String> sub,String subject,int num) {
        List<MovieVO> ganres = ms.ganre("test", num);
        if(results.size() != 0) {
            results.clear();
        }
        if(sub.size() != 0 ){
            sub.clear();
        }
        for (int i = 0; i < 10; i++) {
            MovieVO vo = new MovieVO();
            String result = API.get(ganres.get(i).getMovieNM());
            JSONObject object = new JSONObject(result);
            JSONArray items = object.getJSONArray("items");
            JSONObject item = (JSONObject) items.get(0);
            vo.setSubtitle(item.getString("subtitle"));
            vo.setRank(ganres.get(i).getRank());
            vo.setMovieNM(ganres.get(i).getMovieNM());
            vo.setActor(item.getString("actor"));
            vo.setImgUrl(item.getString("image").replaceAll("mit110", "mit500"));
            vo.setPubDate(Integer.parseInt(item.getString("pubDate")));
            vo.setUserRating(Double.parseDouble(item.getString("userRating")));
            results.add(vo);
        }
        sub.add(subject);

        return "login";
    }

    @GetMapping("/movie/delete")
    public String delete(@ModelAttribute("select") ArrayList<MovieVO> results,@ModelAttribute("subject")ArrayList<String> sub) {
        results.clear();
        sub.clear();
        return "login";
    }
}