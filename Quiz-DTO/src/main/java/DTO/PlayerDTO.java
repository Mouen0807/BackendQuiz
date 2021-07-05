package DTO;

import DTO.CountryDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;



public class PlayerDTO {


    private Long id;
    private String name;
    private String mail;
    private String password;
    private CountryDTO country;
    /*private List<PlayerGameDTO> player_games=new ArrayList<PlayerGameDTO>();*/

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }
    /*
    public List<PlayerGameDTO> getPlayer_games() {
        return player_games;
    }

    public void setPlayer_games(List<PlayerGameDTO> player_games) {
        this.player_games = player_games;
    }

     */
}
