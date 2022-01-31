import { Component, OnInit } from '@angular/core';
import { AppelAPIService } from '../services/appel-api.service';

@Component({
  selector: 'app-sauv-poke',
  templateUrl: './sauv-poke.component.html',
  styleUrls: ['./sauv-poke.component.css']
})
export class SauvPokeComponent implements OnInit {
  
  pokemonsSelected:any
  pokemons:any[]=[]

  constructor(private appelApi:AppelAPIService) { }

  ngOnInit(): void {
  }

  refresh(){
    this.pokemons=[];
    this.appelApi.getSelectedPokemons().subscribe(data =>{
      console.log(data["pokeSelected"]);
      this.pokemonsSelected=JSON.parse(data["pokeSelected"]);
      this.pokemonsSelected.forEach((element: any) => {
        this.pokemons.push(element);
      });
    })
  }

}
