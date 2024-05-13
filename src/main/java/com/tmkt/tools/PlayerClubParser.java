package com.tmkt.tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.util.HashMap;

public class PlayerClubParser {
    
    private HashMap<String, String> playerClubMap;

    @SuppressWarnings("unchecked")
    public PlayerClubParser() {
        InputStream input = getClass().getClassLoader().getResourceAsStream("PlayerClub.json");
        try {
            ObjectMapper mapper = new ObjectMapper();
            playerClubMap = mapper.readValue(input, HashMap.class);
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getClub(String country) {
        return playerClubMap.get(country);
    }
}
