import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllVisiteComponent } from './all-visite.component';

describe('AllVisiteComponent', () => {
  let component: AllVisiteComponent;
  let fixture: ComponentFixture<AllVisiteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllVisiteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllVisiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
