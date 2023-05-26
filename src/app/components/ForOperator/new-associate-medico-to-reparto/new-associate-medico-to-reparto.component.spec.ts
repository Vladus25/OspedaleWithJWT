import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewAssociateMedicoToRepartoComponent } from './new-associate-medico-to-reparto.component';

describe('NewAssociateMedicoToRepartoComponent', () => {
  let component: NewAssociateMedicoToRepartoComponent;
  let fixture: ComponentFixture<NewAssociateMedicoToRepartoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewAssociateMedicoToRepartoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewAssociateMedicoToRepartoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
