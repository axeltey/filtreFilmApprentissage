package com.projetFrame.Filtre;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

public class ListPokemon {

    public ListPokemon(){
        getPorkemons();
    }

    @GetMapping(value="/porkemons")
    private String getPorkemons(){
        String uri ="https://pokeapi.co/api/v2/pokemon?limit=151&offset=0";
        RestTemplate rest=new RestTemplate();
        String res =rest.getForObject(uri,String.class);
        System.out.println(res);
        return res;
    }
}
