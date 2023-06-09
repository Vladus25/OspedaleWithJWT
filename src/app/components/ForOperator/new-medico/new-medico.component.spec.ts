import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewMedicoComponent } from './new-medico.component';

describe('NewMedicoComponent', () => {
  let component: NewMedicoComponent;
  let fixture: ComponentFixture<NewMedicoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewMedicoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewMedicoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
