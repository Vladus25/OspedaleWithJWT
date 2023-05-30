import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssociateMedicoRepartoComponent } from './associate-medico-reparto.component';

describe('AssociateMedicoRepartoComponent', () => {
  let component: AssociateMedicoRepartoComponent;
  let fixture: ComponentFixture<AssociateMedicoRepartoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssociateMedicoRepartoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AssociateMedicoRepartoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
