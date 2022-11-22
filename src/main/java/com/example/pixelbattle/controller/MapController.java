package com.example.pixelbattle.controller;

import com.example.pixelbattle.entity.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;

@RestController
public class MapController {

    private static Map map = new Map();

    @GetMapping("/map")
    HashMap<String,String> getMap() {
        return map.cells;
    }

    @GetMapping("/clearMap")
    public static RedirectView  clearMap() {
        Map.clear();
        return new RedirectView("/");
    }

    public static void putCell(String coordinates, String color){
        map.cells.put(coordinates, color);
    }

}
