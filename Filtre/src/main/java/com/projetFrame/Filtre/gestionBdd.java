package com.projetFrame.Filtre;

import com.projetFrame.Filtre.model.Pokemon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class gestionBdd {
    private Connection con;
    private Statement lienBDD;

    public gestionBdd(){
        try{
            this.con = DriverManager.getConnection("jdbc:h2:mem:testdb","sa","");
            lienBDD = con.createStatement();
            var rs = lienBDD.executeUpdate("create table Pokemon (ID int primary key AUTO_INCREMENT, Name varchar(30) not null, Url varchar(150) not null)");
        }catch (SQLException ex){
            System.out.println(ex+"\n\n\n\n\n\n\n\n\n\n");
        }
    }

    public void addPokemon(Pokemon poke) throws SQLException {
        System.out.println(this.con);
        PreparedStatement stmt=this.con.prepareStatement("insert into Pokemon (Name, Url) values ('"+poke.getName()+"','"+poke.getImg()+"')",Statement.RETURN_GENERATED_KEYS);
        stmt.executeUpdate();
    }

    public List<Pokemon> getAllPokemonSelected() throws SQLException {
        List<Pokemon> pokemons =new ArrayList<>();
        PreparedStatement stmt = this.con.prepareStatement("SELECT * FROM Pokemon");
        ResultSet rs = stmt.executeQuery();
        Pokemon poke;
        while(rs.next()) {
            poke=new Pokemon();
            poke.setName(rs.getString("Name"));
            poke.setImg(rs.getString("Url"));
            pokemons.add(poke);
        }
        return pokemons;
    }
}
