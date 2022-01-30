import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AppelAPIService {

  constructor(private httpClient: HttpClient) {}

  getPokemons(name: String,id: number): Observable<any> {
    return this.httpClient.get<any>(environment.apiUrl + '/pokemons/' + name +"-"+ id);
  }

  addPokeToBdd(name: String,urlImg: String): Observable<any>{
    return this.httpClient.post(environment.apiUrl + '/add_pokemon/',{"name":name,"img":urlImg});
  }

  getSelectedPokemons(): Observable<any> {
    return new Observable();
  }
}
