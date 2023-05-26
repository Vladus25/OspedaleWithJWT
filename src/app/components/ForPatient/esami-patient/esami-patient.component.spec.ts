import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EsamiPatientComponent } from './esami-patient.component';

describe('EsamiPatientComponent', () => {
  let component: EsamiPatientComponent;
  let fixture: ComponentFixture<EsamiPatientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EsamiPatientComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EsamiPatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
