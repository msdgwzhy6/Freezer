package com.github.florent37.orm.model;

import fr.xebia.android.freezer.annotations.Model;

import java.util.List;

/**
 * Created by florentchampigny on 21/01/2016.
 */
@Model
public class Cat {

    String shortName;

    public Cat() {
    }

    public Cat(String shortName) {
        this.shortName = shortName;
    }
}
