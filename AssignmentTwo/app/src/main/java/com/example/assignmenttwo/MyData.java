package com.example.assignmenttwo;

import java.io.Serializable;

class MyData implements Serializable {
    String word, location;

    MyData(String wrd, String loc) { //paramenterized constructor
        this.word = wrd;
        this.location = loc;
    }

    MyData() {
    } //default constructor
}
