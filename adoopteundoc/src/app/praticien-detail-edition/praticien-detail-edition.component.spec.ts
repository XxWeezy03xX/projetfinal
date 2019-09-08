import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PraticienDetailEditionComponent } from './praticien-detail-edition.component';

describe('PraticienDetailEditionComponent', () => {
  let component: PraticienDetailEditionComponent;
  let fixture: ComponentFixture<PraticienDetailEditionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PraticienDetailEditionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PraticienDetailEditionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
