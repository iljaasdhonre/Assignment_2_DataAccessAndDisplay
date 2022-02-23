package com.modandmohamed.assignment_2_dataaccessanddisplay.data.genre;

import com.modandmohamed.assignment_2_dataaccessanddisplay.model.Genre;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IGenreRepo {
    ArrayList<Genre> getAllGenres();
}
