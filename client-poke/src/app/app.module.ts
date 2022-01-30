import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RecherchePokeComponent } from './recherche-poke/recherche-poke.component';
import { SauvPokeComponent } from './sauv-poke/sauv-poke.component';

@NgModule({
  declarations: [
    AppComponent, 
    RecherchePokeComponent, SauvPokeComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
