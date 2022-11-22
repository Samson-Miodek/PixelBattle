package com.example.pixelbattle.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pixel {

    private float x;
    private float y;
    private String color;

    public void normalize(int s){
        this.x = Math.round(x/s)*s;
        this.y = Math.round(y/s)*s;
    }

    public String getCoordinates(){
        return String.format("%.0f %.0f",this.x,this.y);
    }

    @Override
    public String toString() {
        return "Pixel{" +
                "x=" + x +
                ", y=" + y +
                ", color='" + color + '\'' +
                '}';
    }
}
