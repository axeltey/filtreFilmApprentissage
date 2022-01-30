import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SauvPokeComponent } from './sauv-poke.component';

describe('SauvPokeComponent', () => {
  let component: SauvPokeComponent;
  let fixture: ComponentFixture<SauvPokeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SauvPokeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SauvPokeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
