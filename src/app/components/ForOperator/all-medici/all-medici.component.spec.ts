import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllMediciComponent } from './all-medici.component';

describe('AllMediciComponent', () => {
  let component: AllMediciComponent;
  let fixture: ComponentFixture<AllMediciComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllMediciComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllMediciComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
