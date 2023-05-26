import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DatiPatientComponent } from './dati-patient.component';

describe('DatiPatientComponent', () => {
  let component: DatiPatientComponent;
  let fixture: ComponentFixture<DatiPatientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DatiPatientComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DatiPatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
