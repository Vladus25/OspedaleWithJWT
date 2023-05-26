import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewPazienteComponent } from './new-paziente.component';

describe('NewPazienteComponent', () => {
  let component: NewPazienteComponent;
  let fixture: ComponentFixture<NewPazienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewPazienteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewPazienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
