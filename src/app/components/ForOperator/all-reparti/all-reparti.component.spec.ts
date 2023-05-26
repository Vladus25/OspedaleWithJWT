import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllRepartiComponent } from './all-reparti.component';

describe('AllRepartiComponent', () => {
  let component: AllRepartiComponent;
  let fixture: ComponentFixture<AllRepartiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllRepartiComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllRepartiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
