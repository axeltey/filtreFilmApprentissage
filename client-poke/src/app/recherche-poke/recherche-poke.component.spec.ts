import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecherchePokeComponent } from './recherche-poke.component';

describe('RecherchePokeComponent', () => {
  let component: RecherchePokeComponent;
  let fixture: ComponentFixture<RecherchePokeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RecherchePokeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RecherchePokeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
