import { Component, OnInit } from '@angular/core';
import { AppelAPIService } from '../services/appel-api.service';

@Component({
  selector: 'app-sauv-poke',
  templateUrl: './sauv-poke.component.html',
  styleUrls: ['./sauv-poke.component.css']
})
export class SauvPokeComponent implements OnInit {

  constructor(private appelApi:AppelAPIService) { }

  ngOnInit(): void {
  }

}
