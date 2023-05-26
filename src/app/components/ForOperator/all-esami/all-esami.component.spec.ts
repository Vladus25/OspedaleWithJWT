import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllEsamiComponent } from './all-esami.component';

describe('AllEsamiComponent', () => {
  let component: AllEsamiComponent;
  let fixture: ComponentFixture<AllEsamiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllEsamiComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllEsamiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
