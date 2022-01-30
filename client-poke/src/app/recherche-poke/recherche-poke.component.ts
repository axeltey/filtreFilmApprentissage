import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { AppelAPIService } from '../services/appel-api.service';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-recherche-poke',
  templateUrl: './recherche-poke.component.html',
  styleUrls: ['./recherche-poke.component.css']
})
export class RecherchePokeComponent implements OnInit {

  name =new FormControl('');
  id =new FormControl('');

  pokemons: any[]=[]
  listinfo:any

  constructor(private api:AppelAPIService,private domSanitizer:DomSanitizer) { }

  ngOnInit(): void {
  }

  appelAPI(){
    let localName:String='null';
    let localId:number=0;
    if (this.name.value!=''){
      localName=this.name.value;
    }
    if (this.id.value!=''){
      localId=this.id.value;
    }
    this.api.getPokemons(localName,localId).subscribe(data =>{
      this.listinfo= JSON.parse(data["listPoke"]);
      this.pokemons.push({"name":this.listinfo.name,"img":this.listinfo.sprites.front_default});
    })
  }

  selec(){

  }

}
