package com.bstech.khamarapp.HelperClasses.Model;

public class CowModel {
    private Integer id;
    private String pic;
    private String species;
    private String birthdate;

    public CowModel(int id, String pic, String species, String birthdate){
        this.id = id;
        this.pic = pic;
        this.species = species;
        this.birthdate = birthdate;
    }

    public CowModel(){

    }

    public Integer getId() {
        return id;
    }

    public String getPic() {
        return pic;
    }

    public String getSpecies() {
        return species;
    }

    public String getBirthdate() {
        return birthdate;
    }
}
