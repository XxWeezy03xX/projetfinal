import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientDetailConsultationComponent } from './patient-detail-consultation.component';

describe('PatientDetailConsultationComponent', () => {
  let component: PatientDetailConsultationComponent;
  let fixture: ComponentFixture<PatientDetailConsultationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PatientDetailConsultationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientDetailConsultationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
