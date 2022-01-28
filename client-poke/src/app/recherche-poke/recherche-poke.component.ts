import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { AppelAPIService } from '../services/appel-api.service';

@Component({
  selector: 'app-recherche-poke',
  templateUrl: './recherche-poke.component.html',
  styleUrls: ['./recherche-poke.component.css']
})
export class RecherchePokeComponent implements OnInit {

  name =new FormControl('');
  id =new FormControl('');

  pokemons: any

  constructor(private api:AppelAPIService) { }

  ngOnInit(): void {
  }

  appelAPI(){
    let localName:String='null';
    let localId:number=-1;
    if (this.name.value!=''){
      localName=this.name.value;
    }
    if (this.id.value!=''){
      localId=this.id.value;
    }
    this.api.getPokemons(localName,localId).subscribe(data =>{
      this.pokemons= JSON.parse(data["listPoke"]);
    })
  }

}
