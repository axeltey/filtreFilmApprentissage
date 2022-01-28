package com.projetFrame.Filtre;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class ListPokemon {

    public ListPokemon(){
    }

    @GetMapping("/pokemons/{name}-{type}-{id}")
    @ResponseBody
    public Map<String,String> getPokemons(@PathVariable("name") String name,@PathVariable("type") String type,@PathVariable("id") int id){
        System.out.println(name + " " + type + " " + id);
        String uri ="https://pokeapi.co/api/v2/pokemon?limit=151&offset=0";
        RestTemplate rest=new RestTemplate();
        String res =rest.getForObject(uri,String.class);
        Map<String,String> map=new HashMap<String,String>();
        map.put("listPoke",res);
        return map;
    }
}
