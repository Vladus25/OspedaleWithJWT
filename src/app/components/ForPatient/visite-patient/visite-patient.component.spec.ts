import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VisitePatientComponent } from './visite-patient.component';

describe('VisitePatientComponent', () => {
  let component: VisitePatientComponent;
  let fixture: ComponentFixture<VisitePatientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VisitePatientComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VisitePatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
