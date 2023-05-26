import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllPazientiComponent } from './all-pazienti.component';

describe('AllPazientiComponent', () => {
  let component: AllPazientiComponent;
  let fixture: ComponentFixture<AllPazientiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllPazientiComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllPazientiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
