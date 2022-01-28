import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-recherche-poke',
  templateUrl: './recherche-poke.component.html',
  styleUrls: ['./recherche-poke.component.css']
})
export class RecherchePokeComponent implements OnInit {

  pokemons: any[]=[
    {"name":"Charizar"},
    {"name":"arceus"},
    {"name":"bulbizar"},
    {"name":"carapuce"},
  ]

  constructor() { }

  ngOnInit(): void {
  }

}
