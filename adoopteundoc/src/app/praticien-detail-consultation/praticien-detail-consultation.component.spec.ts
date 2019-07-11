import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PraticienDetailConsultationComponent } from './praticien-detail-consultation.component';

describe('PraticienDetailConsultationComponent', () => {
  let component: PraticienDetailConsultationComponent;
  let fixture: ComponentFixture<PraticienDetailConsultationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PraticienDetailConsultationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PraticienDetailConsultationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
