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

    @GetMapping("/pokemons/{name}-{id}")
    @ResponseBody
    public Map<String,String> getPokemons(@PathVariable("name") String name,@PathVariable("id") int id){
        //String uri ="https://pokeapi.co/api/v2/pokemon?limit=151&offset=0";
        String uri ="https://pokeapi.co/api/v2/";
        if(id!=0){
            uri=uri+"pokemon/"+id;
        }else if(!name.equals("null")){
            uri=uri+"pokemon/"+name;
        }else{
            uri=uri+"pokemon/1";
            //uri ="https://pokeapi.co/api/v2/pokemon?limit=151&offset=0";
        }
        System.out.println(uri);
        RestTemplate rest=new RestTemplate();
        String res =rest.getForObject(uri,String.class);
        Map<String,String> map=new HashMap<String,String>();
        map.put("listPoke",res);
        return map;
    }
}
