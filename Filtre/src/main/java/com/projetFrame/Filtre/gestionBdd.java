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
            this.con = DriverManager.getConnection("jdbc:h2:mem:testdb");
            lienBDD = con.createStatement();
            var rs = lienBDD.executeUpdate("create table Pokemon (ID int primary key, Name varchar(30) not null, Url varchar(150) not null)");
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }

    public void addPokemon(Pokemon poke) throws SQLException {
        PreparedStatement stmt=this.con.prepareStatement("insert into Pokemon (Name, Url) values (?,?)",Statement.SUCCESS_NO_INFO);
        stmt.setString(1,poke.getName());
        stmt.setString(2,poke.getImg());
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
