package com.projetFrame.Filtre;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.projetFrame.Filtre.model.Pokemon;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.print.attribute.standard.Media;
import java.sql.SQLException;
import java.util.*;

@SpringBootApplication
@RestController
public class ListPokemon {
    private gestionBdd bdd=new gestionBdd();
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

    @PostMapping(value = "/add_pokemon",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public void addPokeToBdd(@RequestBody Pokemon poke) throws SQLException {
        this.bdd.addPokemon(poke);
    }

    @GetMapping("/pokemonsSelected")
    @ResponseBody
    public Map<String,String> getSelectedPokemon() throws SQLException {
        List<Pokemon> pokemonSelected =this.bdd.getAllPokemonSelected();
        String jsonValue="[";
        Pokemon pokeNow;
        Iterator it=pokemonSelected.iterator();
        while(it.hasNext()){
            pokeNow=(Pokemon) it.next();
            jsonValue+="{\"name\":\""+pokeNow.getName()+"\",\"img\":\""+pokeNow.getImg()+"\"}";
            if(it.hasNext()){
                jsonValue+=",";
            }
        }
        jsonValue+="]";
        Map<String,String> map=new HashMap<String,String>();
        map.put("pokeSelected",jsonValue);
        return map;
    }
}
