import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PraticienDetailEditComponent } from './praticien-detail-edit.component';

describe('PraticienDetailEditComponent', () => {
  let component: PraticienDetailEditComponent;
  let fixture: ComponentFixture<PraticienDetailEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PraticienDetailEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PraticienDetailEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
