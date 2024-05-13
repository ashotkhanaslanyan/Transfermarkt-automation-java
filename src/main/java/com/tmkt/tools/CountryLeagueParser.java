package com.tmkt.tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.util.HashMap;

public class CountryLeagueParser {

    private HashMap<String, String> countryLeagueMap;

    @SuppressWarnings("unchecked")
    public CountryLeagueParser() {
        InputStream input = getClass().getClassLoader().getResourceAsStream("CountryLeague.json");
        try {
            ObjectMapper mapper = new ObjectMapper();
            countryLeagueMap = mapper.readValue(input, HashMap.class);
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getLeague(String country) {
        return countryLeagueMap.get(country);
    }
}
