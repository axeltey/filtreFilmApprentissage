import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { RecherchePokeComponent } from './recherche-poke/recherche-poke.component';

@NgModule({
  declarations: [
    AppComponent,
    RecherchePokeComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
