package com.demo.swapijava.sw;

import com.demo.swapijava.models.*;
import retrofit2.http.Query;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StarWars {

    @GET("")
    Call<Root> getRootUrls();

    @GET("people/")
    Call<SWModelList<People>> getAllPeople(@Query("page") int page);

    @GET("people/{id}/")
    Call<People> getPeople(@Path("id") int peopleId);

    @GET("films/")
    Call<SWModelList<Film>> getAllFilms(@Query("page") int page);

    @GET("films/{id}/")
    Call<Film> getFilm(@Path("id") int filmId);

    @GET("starships")
    Call<SWModelList<Starship>> getAllStarships(@Query("page") int page);

    @GET("starships/{id}/")
    Call<Starship> getStarship(@Path("id") int starshipId);

    @GET("vehicles/")
    Call<SWModelList<Vehicle>> getAllVehicles(@Query("page") Integer page);

    @GET("vehicles/{id}/")
    Call<Vehicle> getVehicle(@Path("id") int vehicleId);

    @GET("species/")
    Call<SWModelList<Species>> getAllSpecies(@Query("page") int page);

    @GET("species/{id}/")
    Call<Species> getSpecies(@Path("id") int speciesId);

    @GET("planets/")
    Call<SWModelList<Planet>> getAllPlanets(@Query("page") Integer page);

    @GET("planets/{id}/")
    Call<Planet> getPlanet(@Path("id") int planetId);


}
