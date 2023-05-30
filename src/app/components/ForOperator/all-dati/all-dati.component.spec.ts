import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllDatiComponent } from './all-dati.component';

describe('AllDatiComponent', () => {
  let component: AllDatiComponent;
  let fixture: ComponentFixture<AllDatiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllDatiComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllDatiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
