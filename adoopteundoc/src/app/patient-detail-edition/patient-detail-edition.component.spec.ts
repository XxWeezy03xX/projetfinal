import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientDetailEditionComponent } from './patient-detail-edition.component';

describe('PatientDetailEditionComponent', () => {
  let component: PatientDetailEditionComponent;
  let fixture: ComponentFixture<PatientDetailEditionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PatientDetailEditionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientDetailEditionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
